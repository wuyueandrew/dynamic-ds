package indi.wuyue.dynamicds.ds;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Setter
@Getter
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidDynamicDatasources {

    private DruidDynamicDataSource master;

    private List<DruidDynamicDataSource> slaves;

}
