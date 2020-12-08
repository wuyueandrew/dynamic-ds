package indi.wuyue.dynamicds.aop;

import indi.wuyue.dynamicds.annotation.DS;
import indi.wuyue.dynamicds.ds.DSThreadLocal;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDSInterceptor implements MethodInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(DynamicDSInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            parseDS(invocation);
            //切换
            LOGGER.info("method:{}, ds:{}", invocation.getMethod().getName(), DSThreadLocal.getCur());
            return invocation.proceed();
        } finally {
            //清空
            DSThreadLocal.clearCur();
            LOGGER.info("清空");
        }
    }

    private void parseDS(MethodInvocation invocation) {
        DS dsm = invocation.getMethod().getAnnotation(DS.class);
        DS dsc = invocation.getClass().getAnnotation(DS.class);
        DS ds = dsm != null ? dsm : dsc;
        DSThreadLocal.setCur(ds == null ? "master" : ds.value());
    }

}
