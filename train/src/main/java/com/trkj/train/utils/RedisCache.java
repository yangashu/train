package com.trkj.train.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings(value = {"unchecke","rawtypes"})
@Component
public class RedisCache {

    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer,String,实体类等
     * @param key   存缓的键值
     * @param value 存缓的值
     * @param <T>
     */
    public <T> void setCacheobject(final String key,final T value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 缓存基本的对象，Integer,String,实体类等
     * @param key   存缓的键值
     * @param value 存缓的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     * @param <T>
     */
    public <T> void setCacheobject(final String key,final T value,final Integer timeout,final TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    /**
     * 设置有效时间
     * @param key Redis值
     * @param timeout 超时时间
     * @return  true=设置成功；false=设置失败
     */
    public boolean expire(final String key,final long timeout){
return expire(key,timeout,TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     * @param key Redis值
     * @param timeout 超时时间
     * @param unit 时间单位
     * @returnc true=设置成功；false=设置失败
     */
    public boolean expire(final String key,final long timeout,final TimeUnit unit){
        return expire(key,timeout,unit);
    }

    /**
     * 获得缓存的基本对象
     * @param key 缓存键值
     * @param <T>
     * @return  缓存键值的对应的数据
     */

    public <T> T getCacheobject(final String key){
    ValueOperations<String,T> operations=redisTemplate.opsForValue();
    return operations.get(key);
    }

    /**
     * 删除单个对象
     * @param key
     * @return
     */

    public boolean deleteobject(final String key){
        return redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     * @param collection 多个对象
     * @return
     */

    public long deleteobject(final Collection collection){
        return redisTemplate.delete(collection);
}

    /**
     * 缓存List数据
     * @param key 缓存的键值
     * @param datalist 待缓存的List数据
     * @param <T>   缓存的数据
     * @return
     */

    public <T> long setCacheList(final String key,final List<?> datalist){
        Long count=redisTemplate.opsForList().rightPushAll(key,datalist);
        return count==null?0:count;
    }

    /**
     * 获得缓存的list对象
     * @param key 缓存的键值
     * @param <T>
     * @return 缓存键值对应的数据
     */

    public <T> List<T> getCacheList(final String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }

    /**
     * 缓存Set
     * @param key 缓存的键值
     * @param dataSet 缓存的数据
     * @param <T>
     * @return  缓存数据的对象
     */

    public <T> BoundSetOperations<String,T> setCacheSet(final String key, final Set<T> dataSet){
        BoundSetOperations<String,T> setOperations=redisTemplate.boundSetOps(key);
        Iterator<T> it=dataSet.iterator();
        while (it.hasNext()){
            setOperations.add(it.next());
        }
        return setOperations;
    }

    /**
     * 获得缓存的Set
     * @param key
     * @param <T>
     * @return
     */

    public <T> Set<T> getCaCheSet(final String key){
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存
     * @param key
     * @param dataMap
     * @return
     */

    public <T> void setCachemap(final String key,final Map<String,T> dataMap){
        if (dataMap!=null){
            redisTemplate.opsForHash().putAll(key,dataMap);
        }
    }

    /**
     * 获得缓存的Map
     * @param key
     * @param <T>
     * @return
     */

    public <T> Map<String,T> getCacheMap(final String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     *  往Hash中存入数据
     * @param key Redis键
     * @param hkey Hash键
     * @param value value值
     * @param <T>
     */

    public <T> void setCacheMapValue(final String key,final String hkey,final T value){
        redisTemplate.opsForHash().put(key,hkey,value);
    }
    /**
     *  获取Hash中的数据
     * @param key Redis键
     * @param hkey Hash键
     * return Hash中的对象
     */

    public <T> T getCacheMapValue(final String key,final String hkey){
        HashOperations<String,String,T> operations=redisTemplate.opsForHash();
        return operations.get(key,hkey);
    }

    /**
     * 删除Hash中的对象
     * @param key
     * @param hkey
     */

    public void delCacheMapValue(final String key,final String hkey){
        HashOperations hashOperations= redisTemplate.opsForHash();
        hashOperations.delete(key,hkey);
    }

    /**
     * 获取多个Hash中数据
     * @param key Redis键
     * @param hkeys Hash集合
     * @param <T>
     * @return  Hash对象集合
     */

    public <T> List<T> geetMultiCacheMapvalue(final String key,final Collection<Object> hkeys){
        return redisTemplate.opsForHash().multiGet(key,hkeys);
    }

    /**
     * 获得缓存的基本对象列表
     * @param pattern 字符串前缀
     * @return  对象列表
     */

    public Collection<String> keys(final String pattern){
        return redisTemplate.keys(pattern);
    }

}
