package com.mads.cache;

import com.mads.cache.redis.RedisCache;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*****
 *  开启 缓存功能。
 * 关于 缓存注解的测试用请看  {@link com.mads.service.UserServiceImpl#queryUser(String)} 中 @Cacheable注解
 **/
@Component
@EnableCaching
public class CacheBean {


    /*****
     * 缓存的实现方式之  redis
     * @param redisTemplate
     * @return
     */
    @Bean
    public Cache redisCache(RedisTemplate redisTemplate) {
        RedisCache cache = new RedisCache();
        cache.setName("redisCache");
        cache.setRedisTemplate(redisTemplate);
        return cache;
    }

    /******
     * 缓存的实现方式之  map
     * @return
     */
    @Bean
    public FactoryBean<ConcurrentMapCache> mapCache() {
        ConcurrentMapCacheFactoryBean bean = new ConcurrentMapCacheFactoryBean();
        bean.setName("mapCache");
        return bean;
    }

    /*****
     * cache的管理器。此方法是一定要有的
     *
     *将是上面的两种实现方式放到管理器中，让用户灵活选择使用具体的缓存方式
     * @param redisCache
     * @param concurrentMapCacheFactoryBean
     * @return
     */
    @Bean
    public CacheManager simpleCacheManager(@Qualifier("redisCache") Cache redisCache,
                                           @Qualifier("mapCache") Cache concurrentMapCacheFactoryBean) {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        List<Cache> list = new ArrayList<>();
        list.add(redisCache);
        list.add(concurrentMapCacheFactoryBean);

        simpleCacheManager.setCaches(list);
        return simpleCacheManager;
    }

}
