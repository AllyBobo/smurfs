//package com.iscas.smurfs.dbservice.config;
//
//
//import com.iscas.smurfs.cache.utils.RedisHelper;
//import com.iscas.smurfs.common.utils.SerializeUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.cache.Cache;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
///**
// * @author: lee
// * @date: 2018-10-31
// */
//@Slf4j
//public class MybatisRedisCache implements Cache {
//    @Autowired
//    RedisHelper redisHelper;
//    private String id;
//    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    public MybatisRedisCache(final String id) {
//        if (id == null) {
//            throw new IllegalArgumentException("Cache instances require an ID");
//        }
//        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);
//        this.id = id;
//    }
//    @Override
//    public String getId() {
//        return this.id;
//    }
//
//    @Override
//    public void putObject(Object o, Object o1) {
//        redisHelper.putCacheSimple(o.toString(),o1,null);
//    }
//
//    @Override
//    public Object getObject(Object o) {
//        Object value = redisHelper.getCacheSimple(o.toString());
//        return value;
//    }
//
//    @Override
//    public Object removeObject(Object o) {
//        redisHelper.cleanRedisByKey(o.toString());
//        return null;
//    }
//
//    @Override
//    public void clear() {
//        redisHelper.cleanRedis("");
//    }
//
//    @Override
//    public int getSize() {
//        return 0;
//    }
//
//    @Override
//    public ReadWriteLock getReadWriteLock() {
//        return readWriteLock;
//    }
//}
