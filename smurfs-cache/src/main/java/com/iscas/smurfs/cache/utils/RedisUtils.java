package com.iscas.smurfs.cache.utils;

import com.iscas.smurfs.common.utils.SpringContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: lee
 * @date: 2018-10-26
 */
public class RedisUtils {


    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static RedisTemplate<String, Object> redisTemplate = SpringContextUtils.getBean(RedisTemplate.class);

//    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

    /**
     *
     * <Description> 根据前缀进行清除缓存<br>
     *
     * @author lu.wei<br>
     * @email wei.lu@qq.com<br>
     * @date 2016年8月25日 下午2:41:29
     * @param prefix
     * <br>
     */
    public static void cleanRedis(String prefix) {
        logger.info("cleanRedis prefix: {}", prefix);
        try {
            if (null != prefix) {
                if (null != redisTemplate) {
                    Set<String> keys = redisTemplate.keys(prefix + "*");
                    for (String key : keys) {
                        redisTemplate.delete(key);
                    }
                }
            }

        } catch (Exception e) {
            logger.error("cleanRedis error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 根据KEY进行清除缓存<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年10月28日 上午10:50:52
     * @param key
     * <br>
     */
    public static void cleanRedisByKey(String key) {
        logger.info("cleanRedisByKey key: {}", key);
        try {
            if (null != key) {
                if (null != redisTemplate) {
                    redisTemplate.delete(key);
                }
            }

        } catch (Exception e) {
            logger.error("cleanRedisByKey error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 缓存字符串<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午5:47:44
     * @param key
     * @param data
     * @param minus
     * <br>
     */
    public static void putCacheStr(String key, String data, Long minus) {
        logger.info("putCacheStr : {}, {}, {} minute", key, data, minus);
        try {
            ValueOperations<String, Object> opsValue = null;
            if (null != redisTemplate) {
                opsValue = redisTemplate.opsForValue();
                if (null != opsValue) {
                    opsValue.set(key, data);
                }
            }
        } catch (Exception e) {
            logger.error("putCacheStr error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 获取缓存字符串<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午5:48:00
     * @param key
     * @return <br>
     */
    public static String getCacheStr(String key) {
        logger.info("getCacheStr : {}", key);

        String retStr = null;
        try {
            ValueOperations<String, Object> opsValue = null;
            if (null != redisTemplate) {
                opsValue = redisTemplate.opsForValue();
                if (null != opsValue) {
                    retStr = String.valueOf(opsValue.get(key));
                }
            }
        } catch (Exception e) {
            logger.error("getCacheStr error : {} ", e.getMessage(), e);
        }
        return retStr;
    }

    /**
     *
     * <Description> 缓存简单对象<br>
     * 基本数据类型和简单对象
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午4:47:14
     * @param key
     * @param
     * @param minus
     * <br>
     */
    public static void putCacheSimple(String key, Object data, Long minus) {
        logger.info("putCacheSimple : {}, {}, {} minute", key, data, minus);
        try {
            ValueOperations<String, Object> opsValue = null;
            if (null != redisTemplate) {
                opsValue = redisTemplate.opsForValue();
                if (null != opsValue) {
                    opsValue.set(key, data);

                    if (null != minus) {
                        redisTemplate.expire(key, minus, TimeUnit.MINUTES);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("putCacheSimple error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 获取缓存的简单对象<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午4:50:16
     * @param key
     * @return <br>
     */
    public static Object getCacheSimple(String key) {
        logger.info("getCacheSimple : {}", key);

        Object object = null;
        try {
            ValueOperations<String, Object> opsValue = null;
            if (null != redisTemplate) {
                opsValue = redisTemplate.opsForValue();
                if (null != opsValue) {
                    object = (Object) opsValue.get(key);
                }
            }
        } catch (Exception e) {
            logger.error("getCacheSimple error : {} ", e.getMessage(), e);
        }
        return object;
    }

    /**
     *
     * <Description> 缓存List数据<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午4:52:43
     * @param key
     * @param datas
     * @param minus
     * <br>
     */
    public static void putCacheList(String key, List<?> datas, Long minus) {
        logger.info("putCacheList : {}, {}, {} minute", key, datas, minus);
        try {
            ListOperations<String, Object> opsList = null;
            if (null != redisTemplate) {
                opsList = redisTemplate.opsForList();
                if (null != opsList) {
                    int size = datas.size();
                    for (int i = 0; i < size; i++) {
                        opsList.leftPush(key, datas.get(i));
                    }

                    if (null != minus) {
                        redisTemplate.expire(key, minus, TimeUnit.MINUTES);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("putCacheList error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 获取缓存的List对象<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午4:50:16
     * @param key
     * @return <br>
     */
    public static List<Object> getCacheList(String key) {
        logger.info("getCacheList : {}", key);

        List<Object> dataList = new ArrayList<Object>();
        try {
            ListOperations<String, Object> opsList = null;
            if (null != redisTemplate) {
                opsList = redisTemplate.opsForList();
                if (null != opsList) {
                    Long size = opsList.size(key);
                    for (int i = 0; i < size; i++) {
                        dataList.add(opsList.index(key, i));
                    }
                }
            }
        } catch (Exception e) {
            logger.error("getCacheList error : {} ", e.getMessage(), e);
        }
        return dataList;
    }

    /**
     *
     * <Description> 缓存SET数据<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午5:21:30
     * @param key
     * @param datas
     * @param minus
     * <br>
     */
    public static void putCacheSet(String key, Set<?> datas, Long minus) {
        logger.info("putCacheList : {}, {}, {} minute", key, datas, minus);
        try {
            SetOperations<String, Object> opsSet = null;
            if (null != redisTemplate) {
                opsSet = redisTemplate.opsForSet();
                if (null != opsSet) {
                    opsSet.add(key, datas);

                    if (null != minus) {
                        redisTemplate.expire(key, minus, TimeUnit.MINUTES);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("putCacheList error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 获取缓存的SET对象<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午4:50:16
     * @param key
     * @return <br>
     */
    public static Set<Object> getCacheSet(String key) {
        logger.info("getCacheSet : {}", key);

        Set<Object> dataSet = new HashSet<Object>();
        try {
            SetOperations<String, Object> opsSet = null;
            if (null != redisTemplate) {
                opsSet = redisTemplate.opsForSet();
                if (null != opsSet) {
                    dataSet = opsSet.members(key);
                }
            }
        } catch (Exception e) {
            logger.error("getCacheSet error : {} ", e.getMessage(), e);
        }
        return dataSet;
    }

    /**
     *
     * <Description> 缓存MAP数据<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午5:21:30
     * @param key
     * @param datas
     * @param minus
     * <br>
     */
    public static void putCacheMap(String key, Map<Object, Object> datas, Long minus) {
        logger.info("putCacheMap : {}, {}, {} minute", key, datas, minus);
        try {
            HashOperations<String, Object, Object> opsHash = null;
            if (null != redisTemplate) {
                opsHash = redisTemplate.opsForHash();
                if (null != opsHash) {
                    opsHash.putAll(key, datas);

                    if (null != minus) {
                        redisTemplate.expire(key, minus, TimeUnit.MINUTES);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("putCacheMap error : {} ", e.getMessage(), e);
        }
    }

    /**
     *
     * <Description> 获取缓存的MAP对象<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年12月22日 下午4:50:16
     * @param key
     * @return <br>
     */
    public static Map<Object, Object> getCacheMap(String key) {
        logger.info("getCacheMap : {}", key);

        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        try {
            HashOperations<String, Object, Object> opsHash = null;
            if (null != redisTemplate) {
                opsHash = redisTemplate.opsForHash();
                if (null != opsHash) {
                    dataMap = opsHash.entries(key);
                }
            }
        } catch (Exception e) {
            logger.error("getCacheMap error : {} ", e.getMessage(), e);
        }
        return dataMap;
    }

    /**
     *
     * <Description> TODO<br>
     *
     * @author lu.wei<br>
     * @email 1025742048@qq.com<br>
     * @date 2016年10月27日 下午1:54:58
     * @return <br>
     */
    public static RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }
}