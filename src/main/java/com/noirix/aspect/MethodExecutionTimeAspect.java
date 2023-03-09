package com.noirix.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class MethodExecutionTimeAspect {

    //Срез точек наюлюдения(в общем случае шаблон, по которому аспект находит join Point's)
    @Pointcut("execution(* com.noirix.*.*.*.*(..))")
    public void allMethodPointcut() {
    }

    //Advice - набор инструкции среза
    //так же здесь указывается место действия этих инструкций(В аннотации @Around или похожей)
    @Around("allMethodPointcut()")
    public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object object = joinPoint.proceed();

        stopWatch.stop();

        System.out.println("Method {" + joinPoint.getSignature().getDeclaringType().getName() + "."
                + joinPoint.getSignature().getName() + "()"
                + "} working time: {" + stopWatch.getTotalTimeMillis() + "}ms");
        return object;
    }

}