package com.cyn.demo.cache;

import com.cyn.demo.bean.Man;;import java.util.concurrent.ExecutionException;


/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-07
 */
public class CacheDemo {

    public static void main(String[] args) {
        // testCacheDemo();
        testCacheDemo2();

    }

    public static void testCacheDemo2() {
        GuavaCacheDemo2 cacheDemo = new GuavaCacheDemo2();
        cacheDemo.init();

        System.out.println("使用loadingCache");
        cacheDemo.initLoadingCache();

        System.out.println("使用loadingCache get方法  第一次加载");
        Man man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);

        System.out.println("\n使用loadingCache getIfPresent方法  第一次加载");
        man = cacheDemo.getIfPresentloadingCache("002");
        System.out.println(man);

        System.out.println("\n使用loadingCache get方法  第一次加载");
        man = cacheDemo.getCacheKeyloadingCache("002");
        System.out.println(man);

        System.out.println("\n使用loadingCache get方法  已加载过");
        man = cacheDemo.getCacheKeyloadingCache("002");
        System.out.println(man);

        System.out.println("\n使用loadingCache get方法  已加载过,但是已经被剔除掉,验证重新加载");
        man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);

        System.out.println("\n使用loadingCache getIfPresent方法  已加载过");
        man = cacheDemo.getIfPresentloadingCache("001");
        System.out.println(man);

        System.out.println("\n使用loadingCache put方法  再次get");
        Man newMan = new Man();
        newMan.setId("001");
        newMan.setName("额外添加");
        cacheDemo.putloadingCache("001",newMan);
        man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);

        ///////////////////////////////////
        System.out.println("\n\n使用Cache");
        cacheDemo.initDefault();

        System.out.println("使用Cache get方法  第一次加载");
        try {
            man = cacheDemo.getCacheKeyCache("001");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(man);

        System.out.println("\n使用Cache getIfPresent方法  第一次加载");
        man = cacheDemo.getIfPresentCache("002");
        System.out.println(man);

        System.out.println("\n使用Cache get方法  第一次加载");
        try {
            man = cacheDemo.getCacheKeyCache("002");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(man);

        System.out.println("\n使用Cache get方法  已加载过");
        try {
            man = cacheDemo.getCacheKeyCache("002");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(man);

        System.out.println("\n使用Cache get方法  已加载过,但是已经被剔除掉,验证重新加载");
        try {
            man = cacheDemo.getCacheKeyCache("001");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(man);

        System.out.println("\n使用Cache getIfPresent方法  已加载过");
        man = cacheDemo.getIfPresentCache("001");
        System.out.println(man);

        System.out.println("\n使用Cache put方法  再次get");
        Man newMan1 = new Man();
        newMan1.setId("001");
        newMan1.setName("额外添加");
        cacheDemo.putloadingCache("001",newMan1);
        man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);


        man = cacheDemo.getCacheKeyloadingCache("001222");

    }

    public static void testCacheDemo() {
        GuavaCacheDemo cacheDemo = new GuavaCacheDemo();
        System.out.println("使用loadingCache");
        cacheDemo.initLoadingCache();

        System.out.println("使用loadingCache get方法  第一次加载");
        Man man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);

        System.out.println("\n使用loadingCache getIfPresent方法  第一次加载");
        man = cacheDemo.getIfPresentloadingCache("002");
        System.out.println(man);

        System.out.println("\n使用loadingCache get方法  第一次加载");
        man = cacheDemo.getCacheKeyloadingCache("002");
        System.out.println(man);

        System.out.println("\n使用loadingCache get方法  已加载过");
        man = cacheDemo.getCacheKeyloadingCache("002");
        System.out.println(man);

        System.out.println("\n使用loadingCache get方法  已加载过,但是已经被剔除掉,验证重新加载");
        man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);

        System.out.println("\n使用loadingCache getIfPresent方法  已加载过");
        man = cacheDemo.getIfPresentloadingCache("001");
        System.out.println(man);

        System.out.println("\n使用loadingCache put方法  再次get");
        Man newMan = new Man();
        newMan.setId("001");
        newMan.setName("额外添加");
        cacheDemo.putloadingCache("001", newMan);
        man = cacheDemo.getCacheKeyloadingCache("001");
        System.out.println(man);
    }
}
