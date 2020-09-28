package com.springboot.demo.common.constant;

import org.apache.tomcat.util.buf.HexUtils;
import org.crazycake.shiro.exception.SerializationException;
import org.crazycake.shiro.serializer.ObjectSerializer;
import redis.clients.jedis.Jedis;

/**
 * @author zwj * @since 1.0
 */
public class RedisConstant {

    private RedisConstant() {

    }

    public static final int REDIS_DB_SESSION = 0; //会话DB


    public static final String KEY_PREFIX_SESSION = "Demo#Session";
    public static final String KEY_PREFIX_SHIRO_SESSION = KEY_PREFIX_SESSION + "shiro-sessionId:";

    public static final String CURRENT_USER = "currentUser";
}
