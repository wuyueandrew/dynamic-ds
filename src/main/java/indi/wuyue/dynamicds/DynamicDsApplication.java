package indi.wuyue.dynamicds;

import indi.wuyue.dynamicds.ds.DruidDynamicDatasources;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DruidDynamicDatasources.class)
@MapperScan("indi.wuyue.dynamicds.test.dao")
public class DynamicDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDsApplication.class, args);
    }

}
