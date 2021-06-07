package com.cyn.demo.cache;

import com.cyn.demo.bean.Man;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

/**
 * @Description: 学习Google内部使用的工具包Guava，在Java项目中轻松地增加缓存，提高程序获取数据的效率.
 * * 当获取数据时，程序将先从一个存储在内存中的数据结构中获取数据。如果数据不存在，
 * * 则在磁盘或者数据库中获取数据并存入到数据结构当中。之后程序需要再次获取数据时，则会先查询这个数据结构
 * * 从内存中获取数据时间明显小于通过IO获取数据，这个数据结构就是缓存的实现。
 * * <p>
 * * 这里引入一个概念，缓存命中率：从缓存中获取到数据的次数/全部查询次数，命中率越高说明这个缓存的效率好。
 * * 由于机器内存的限制，缓存一般只能占据有限的内存大小，缓存需要不定期的删除一部分数据，
 * * 从而保证不会占据大量内存导致机器崩溃.
 * * <p>
 * * 目前有三种删除数据的方式
 * * FIFO（先进先出）
 * * LFU（定期淘汰最少使用次数）
 * * LRU（淘汰最长时间未被使用）
 * @Author: ynchen9
 * @CreateTime: 2021-06-07
 */
public class GuavaCacheDemo {
    private LoadingCache<String, Man> loadingCache;

    //loadingCache
    public void initLoadingCache() {
        //指定一个如果数据不存在获取数据的方法
        CacheLoader<String, Man> cacheLoader = new CacheLoader<String, Man>() {
            @Override
            public Man load(String key) throws Exception {
                //模拟mysql操作
                Logger logger = LoggerFactory.getLogger("LoadingCache");
                logger.info("LoadingCache测试 从mysql加载缓存ing...(2s)");
                Thread.sleep(2000);
                logger.info("LoadingCache测试 从mysql加载缓存成功");
                Man tmpman = new Man();
                tmpman.setId(key);
                tmpman.setName("其他人");
                if (key.equals("001")) {
                    tmpman.setName("张三");
                    return tmpman;
                }
                if (key.equals("002")) {
                    tmpman.setName("李四");
                    return tmpman;
                }
                return tmpman;
            }
        };
        //缓存数量为1，为了展示缓存删除效果
        loadingCache = CacheBuilder.newBuilder().maximumSize(1).build(cacheLoader);
    }

    //获取数据，如果不存在返回null
    public Man getIfPresentloadingCache(String key) {
        return loadingCache.getIfPresent(key);
    }

    //获取数据，如果数据不存在则通过cacheLoader获取数据，缓存并返回
    public Man getCacheKeyloadingCache(String key) {
        try {
            return loadingCache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    //直接向缓存put数据
    public void putloadingCache(String key, Man value) {
        Logger logger = LoggerFactory.getLogger("LoadingCache");
        logger.info("put key :{} value : {}", key, value.getName());
        loadingCache.put(key, value);
    }
}
