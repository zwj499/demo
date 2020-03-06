package com.springboot.demo.common.serializer;

import org.crazycake.shiro.exception.SerializationException;
import org.crazycake.shiro.serializer.RedisSerializer;

/**
 * @author zwj * @since 1.0
 */
public class ShiroStringSerializer implements RedisSerializer<String> {

    @Override
    public byte[] serialize(String s) throws SerializationException {
        return new byte[0];
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        return null;
    }
}
