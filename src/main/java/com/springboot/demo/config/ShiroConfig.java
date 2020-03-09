package com.springboot.demo.config;

import com.springboot.demo.common.constant.RedisConstant;
import com.springboot.demo.common.properties.ShiroProperties;
import com.springboot.demo.common.serializer.ShiroRedisSessionDao;
import com.springboot.demo.common.shiro.SysUserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ReflectionUtils;
import redis.clients.jedis.JedisPool;

import javax.servlet.Filter;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(value = {ShiroProperties.class})
public class ShiroConfig {

    private static final String SHIRO_FILTER_NAME = "shiroFilter";

    @Autowired
    private ShiroProperties shiroProperties;

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public JedisPool jedisPool(JedisConnectionFactory jedisConnectionFactory) {
        Field poolField = ReflectionUtils.findField(JedisConnectionFactory.class, "pool");
        ReflectionUtils.makeAccessible(poolField);
        JedisPool jedisPool = (JedisPool) ReflectionUtils.getField(poolField, jedisConnectionFactory);
        return jedisPool;
    }

    @Bean
    public RedisManager redisManager(JedisPool jedisPool) {
        RedisManager redisManager = new RedisManager();
        redisManager.setJedisPool(jedisPool);
        redisManager.setHost("localhost:6379");
        redisManager.setDatabase(RedisConstant.REDIS_DB_SESSION);
        redisManager.setTimeout(2222);
        return redisManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        redisSessionDAO.setKeyPrefix(RedisConstant.KEY_PREFIX_SHIRO_SESSION);
        redisSessionDAO.setExpire(3600 * 24);
//        redisSessionDAO.setKeySerializer();
//        redisSessionDAO.setSessionInMemoryTimeout();
        return redisSessionDAO;
    }

    @Bean
    public ShiroRedisSessionDao shiroRedisSessionDao(RedisTemplate redisTemplate) {
        ShiroRedisSessionDao sessionDao = new ShiroRedisSessionDao();
        sessionDao.setExpire(3600 * 24);
        sessionDao.setKeyPrefix(RedisConstant.KEY_PREFIX_SHIRO_SESSION);
        sessionDao.setRedisTemplate(redisTemplate);
        return sessionDao;
    }

    @Bean
    public SessionManager sessionManager(RedisSessionDAO redisSessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO);
        sessionManager.getSessionIdCookie().setName("demo_sessionId");
        return sessionManager;
    }


    @Bean
    public SecurityManager securityManager(SysUserRealm sysUserRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(sysUserRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }

    @Bean
    public SysUserRealm sysUserRealm() {
        return new SysUserRealm();
    }

    @Bean(name = SHIRO_FILTER_NAME)
    public ShiroFilterFactoryBean getAbstractShiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();
        factory.setSecurityManager(securityManager);

        factory.setUnauthorizedUrl("/unLogin");

        Map<String, Filter> filterMap = new LinkedHashMap<>();
        PermissionsAuthorizationFilter permissionsAuthorizationFilter = new PermissionsAuthorizationFilter();
        permissionsAuthorizationFilter.setUnauthorizedUrl("/error");

        filterMap.put("permissionsAuthorizationFilter", permissionsAuthorizationFilter);

        factory.setFilters(filterMap);

        Map<String, String> filter = new LinkedHashMap<String, String>();
        filter.put("/", "anon");
        filter.put("/login", "anon");
        filter.put("/**", "authc");

        factory.setFilterChainDefinitionMap(filter);
        return factory;
    }

}
