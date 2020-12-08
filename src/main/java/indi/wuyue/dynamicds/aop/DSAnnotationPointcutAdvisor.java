package indi.wuyue.dynamicds.aop;

import indi.wuyue.dynamicds.annotation.DS;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * 注解aop拦截 切点是注解DS advice是DynamicDSInterceptor
 */
public class DSAnnotationPointcutAdvisor extends AbstractPointcutAdvisor {

    private Advice advice;

    private Pointcut pointcut;

    public DSAnnotationPointcutAdvisor(DynamicDSInterceptor advice) {
        this.advice = advice;
        createPointCut();
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    private void createPointCut() {
        ComposablePointcut composablePointcut = new ComposablePointcut(new AnnotationMatchingPointcut(DS.class, true));
//        Pointcut classPointCut = ;
        Pointcut methodPointCut = AnnotationMatchingPointcut.forMethodAnnotation(DS.class);
        composablePointcut
//                .union(classPointCut)
                .union(methodPointCut);
        pointcut = composablePointcut;
    }

}
