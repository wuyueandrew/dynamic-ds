package indi.wuyue.dynamicds.ds;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicRouterDatasource extends AbstractRoutingDataSource {

    private final static Logger LOGGER = LoggerFactory.getLogger(DynamicRouterDatasource.class);

    @Setter
    private DruidDynamicDatasources druidDynamicDatasources;

    @Override
    protected Object determineCurrentLookupKey() {
        if (DSThreadLocal.getCur() == null) {
            return "master";
        }
        return DSThreadLocal.getCur();
    }

    public void init() {
        Map<Object, Object> target = new HashMap<>();
        DruidDynamicDataSource master = druidDynamicDatasources.getMaster();
        initDS(master);
        List<DruidDynamicDataSource> slaves = druidDynamicDatasources.getSlaves();
        slaves.forEach(slave -> {
            initDS(slave);
            target.put(slave.getName(), slave);
        });
        target.put("master", master);
        setTargetDataSources(target);
    }

    private void initDS(DruidDynamicDataSource druidDS) {
        try {
            druidDS.init();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
