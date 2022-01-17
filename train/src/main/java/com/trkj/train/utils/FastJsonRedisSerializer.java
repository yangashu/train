package com.trkj.train.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    private static final Charset DEFAUTL_CHARSET=Charset.forName("UTF-8");
    private Class<T> clazz;
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }
    public FastJsonRedisSerializer(Class<T> clazz){
        super();
        this.clazz=clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if(t==null){
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAUTL_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes==null || bytes.length<=0){
            return null;
        }
    String str=new String(bytes,DEFAUTL_CHARSET);
        return JSON.parseObject(str,clazz);
    }
    protected JavaType getJavaType(Class<T> clazz){
    return TypeFactory.defaultInstance().constructType(clazz);
    }
}
