package com.redis.client.demo.redisconfig;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;


/**
 * 为了能够使redis可以直接存java对象,所以我们需要对其配置,以及自定义序列化器和反序列化器
 */
public class RedisConverter implements RedisSerializer {

    private Converter<Object, byte[]> serializer = new SerializingConverter();//序列化器
    private Converter<byte[], Object> deserializer = new DeserializingConverter();//反序列化器

    @Override
    public byte[] serialize(Object t) throws SerializationException {//将对象序列化成字节数组
        if(t == null) {
            return null;
        }

        return JSONObject.toJSONString(t,  SerializerFeature.WriteClassName).getBytes(IOUtils.UTF8);


    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {//将字节数组反序列化成对象
        if(bytes == null) {
            return null;
        }

        return JSONObject.parse(bytes);


    }
}
