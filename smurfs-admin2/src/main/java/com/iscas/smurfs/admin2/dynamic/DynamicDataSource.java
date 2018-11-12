package com.iscas.smurfs.admin2.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lee
 * @date: 2018-11-12
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

    /**
     * 动态更新自定义数据源
     * @param
     * @param customDataSources
     */
    public void updateTargetDataSource(Map<String, DataSource> customDataSources){
        Map<Object,Object> customDS=new HashMap<Object, Object>();
        customDS.putAll(customDataSources);
        setTargetDataSources(customDS);
        afterPropertiesSet();
    }

}
