package com.mads.cache.redis;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * @Description: 具体的缓存实现者 之  redis
 * @Date 2020/3/29
 * @Version V1.0
 * @Author Mads
 **/
public class RedisCache implements Cache {
    //redis操作模板
    private RedisTemplate<String, Object> redisTemplate;
    //这个名字对应 用户使用时  选择哪种缓存方式传的别名。
    private String name;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    /***
     * 核心方法
     */
    @Override
    public void clear() {
        System.out.println("-------緩存清理------");
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /***
     * 核心方法
     * @param key
     */
    @Override
    public void evict(Object key) {
        System.out.println("-------緩存刪除------");
        final String keyf = key.toString();
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(keyf.getBytes());
            }
        });
    }
    /***
     * 核心方法
     * @param key
     */
    @Override
    public ValueWrapper get(Object key) {
        System.out.println("------缓存获取-------" + key.toString());
        final String keyf = key.toString();
        Object object = null;
        object = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    System.out.println("------缓存不存在-------");
                    return null;
                }
                return SerializationUtils.deserialize(value);
            }
        });
        ValueWrapper obj = (object != null ? new SimpleValueWrapper(object) : null);
        System.out.println("------获取到内容-------" + (obj != null ? obj.get() : ""));
        return obj;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }
    /***
     * 核心方法  设置缓存
     * @param key
     */
    @Override
    public void put(Object key, Object value) {
        System.out.println("-------加入缓存------");
        System.out.println("key----:" + key);
        System.out.println("value----:" + value);
        final String keyString = key.toString();
        final Object valuef = value;
        final long liveTime = 86400;
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyb = keyString.getBytes();
                //序列化值
                byte[] valueb = SerializationUtils.serialize((Serializable) valuef);
                connection.set(keyb, valueb);
                if (liveTime > 0) {
                    connection.expire(keyb, liveTime);
                }
                return 1L;
            }
        });
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}
