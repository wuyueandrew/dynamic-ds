package indi.wuyue.dynamicds.conf;

import indi.wuyue.dynamicds.aop.DSAnnotationPointcutAdvisor;
import indi.wuyue.dynamicds.aop.DynamicDSInterceptor;
import indi.wuyue.dynamicds.ds.DruidDynamicDatasources;
import indi.wuyue.dynamicds.ds.DynamicRouterDatasource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DynamicDSConf {

    @Resource
    private DruidDynamicDatasources druidDynamicDatasources;

    @Bean
    public DataSource dynamicDataSource() {
        DynamicRouterDatasource dynamicDataSource = new DynamicRouterDatasource();
        dynamicDataSource.setDruidDynamicDatasources(druidDynamicDatasources);
        dynamicDataSource.init();
        return dynamicDataSource;
    }

    @Bean
    public DSAnnotationPointcutAdvisor dsAnnotationPointcutAdvisor() {
        return new DSAnnotationPointcutAdvisor(new DynamicDSInterceptor());
    }

}
