package com.springboot.demo.common.serializer;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.crazycake.shiro.RedisSessionDAO;
import org.crazycake.shiro.SessionInMemory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;

/**
 * @author zwj * @since 1.0
 */
public class ShiroRedisSessionDao extends AbstractSessionDAO {
    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
    private static final String DEFAULT_SESSION_KEY_PREFIX = "shiro:session:";
    private String keyPrefix = "shiro:session:";
    private static final long DEFAULT_SESSION_IN_MEMORY_TIMEOUT = 1000L;
    private long sessionInMemoryTimeout = 1000L;
    private static final boolean DEFAULT_SESSION_IN_MEMORY_ENABLED = true;
    private boolean sessionInMemoryEnabled = true;
    private static final int DEFAULT_EXPIRE = -2;
    private static final int NO_EXPIRE = -1;
    private int expire = -2;
    private static final int MILLISECONDS_IN_A_SECOND = 1000;
    //    private IRedisManager redisManager;
//    private RedisSerializer keySerializer = new StringSerializer();
//    private RedisSerializer valueSerializer = new ObjectSerializer();
    private static ThreadLocal sessionsInThread = new ThreadLocal();
    private RedisTemplate redisTemplate = new RedisTemplate();

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
        if (this.sessionInMemoryEnabled) {
            this.setSessionToThreadLocal(session.getId(), session);
        }

    }

    private void saveSession(Session session) throws UnknownSessionException {
        if (session != null && session.getId() != null) {
            String key;

            key = this.getRedisSessionKey(session.getId());



            if (this.expire == -2) {
                redisTemplate.opsForValue().set(key, session, (int) (session.getTimeout() / 1000L));
            } else {
                if (this.expire != -1 && (long) (this.expire * 1000) < session.getTimeout()) {
                    logger.warn("Redis session expire time: " + this.expire * 1000 + " is less than Session timeout: " + session.getTimeout() + " . It may cause some problems.");
                }

                redisTemplate.opsForValue().set(key, session, this.expire);
            }
        } else {
            logger.error("session or session id is null");
            throw new UnknownSessionException("session or session id is null");
        }
    }

    public void delete(Session session) {
        if (session != null && session.getId() != null) {
            redisTemplate.delete(this.getRedisSessionKey(session.getId()));
        } else {
            logger.error("session or session id is null");
        }
    }

    public Collection<Session> getActiveSessions() {
        HashSet sessions = new HashSet();

        Set<String> keys = redisTemplate.keys(this.keyPrefix + "*");
        if (keys != null && keys.size() > 0) {
            Iterator var3 = keys.iterator();

            while (var3.hasNext()) {
                Session s = (Session) redisTemplate.opsForValue().get(var3.next());
                sessions.add(s);
            }
        }

        return sessions;
    }

    protected Serializable doCreate(Session session) {
        if (session == null) {
            logger.error("session is null");
            throw new UnknownSessionException("session is null");
        } else {
            Serializable sessionId = this.generateSessionId(session);
            this.assignSessionId(session, sessionId);
            this.saveSession(session);
            return sessionId;
        }
    }

    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            logger.warn("session id is null");
            return null;
        } else {
            Session session;
            if (this.sessionInMemoryEnabled) {
                session = this.getSessionFromThreadLocal(sessionId);
                if (session != null) {
                    return session;
                }
            }

            session = null;
            logger.debug("read session from redis");

            session = (Session) redisTemplate.opsForValue().get(this.getRedisSessionKey(sessionId));
            if (this.sessionInMemoryEnabled) {
                this.setSessionToThreadLocal(sessionId, session);
            }

            return session;
        }
    }

    private void setSessionToThreadLocal(Serializable sessionId, Session s) {
        Map<Serializable, SessionInMemory> sessionMap = (Map) sessionsInThread.get();
        if (sessionMap == null) {
            sessionMap = new HashMap();
            sessionsInThread.set(sessionMap);
        }

        this.removeExpiredSessionInMemory((Map) sessionMap);
        SessionInMemory sessionInMemory = new SessionInMemory();
        sessionInMemory.setCreateTime(new Date());
        sessionInMemory.setSession(s);
        ((Map) sessionMap).put(sessionId, sessionInMemory);
    }

    private void removeExpiredSessionInMemory(Map<Serializable, SessionInMemory> sessionMap) {
        Iterator it = sessionMap.keySet().iterator();

        while (it.hasNext()) {
            Serializable sessionId = (Serializable) it.next();
            SessionInMemory sessionInMemory = (SessionInMemory) sessionMap.get(sessionId);
            if (sessionInMemory == null) {
                it.remove();
            } else {
                long liveTime = this.getSessionInMemoryLiveTime(sessionInMemory);
                if (liveTime > this.sessionInMemoryTimeout) {
                    it.remove();
                }
            }
        }

    }

    private Session getSessionFromThreadLocal(Serializable sessionId) {
        if (sessionsInThread.get() == null) {
            return null;
        } else {
            Map<Serializable, SessionInMemory> sessionMap = (Map) sessionsInThread.get();
            SessionInMemory sessionInMemory = (SessionInMemory) sessionMap.get(sessionId);
            if (sessionInMemory == null) {
                return null;
            } else {
                long liveTime = this.getSessionInMemoryLiveTime(sessionInMemory);
                if (liveTime > this.sessionInMemoryTimeout) {
                    sessionMap.remove(sessionId);
                    return null;
                } else {
                    logger.debug("read session from memory");
                    return sessionInMemory.getSession();
                }
            }
        }
    }

    private long getSessionInMemoryLiveTime(SessionInMemory sessionInMemory) {
        Date now = new Date();
        return now.getTime() - sessionInMemory.getCreateTime().getTime();
    }

    private String getRedisSessionKey(Serializable sessionId) {
        return this.keyPrefix + sessionId;
    }

    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public long getSessionInMemoryTimeout() {
        return this.sessionInMemoryTimeout;
    }

    public void setSessionInMemoryTimeout(long sessionInMemoryTimeout) {
        this.sessionInMemoryTimeout = sessionInMemoryTimeout;
    }

    public int getExpire() {
        return this.expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public boolean getSessionInMemoryEnabled() {
        return this.sessionInMemoryEnabled;
    }

    public void setSessionInMemoryEnabled(boolean sessionInMemoryEnabled) {
        this.sessionInMemoryEnabled = sessionInMemoryEnabled;
    }

    public static ThreadLocal getSessionsInThread() {
        return sessionsInThread;
    }
}
