package com.noirix.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;

@Component
@Aspect
public class MethodExecutionTimeAspect {

    private LocalTime timeStart;

    //Срез точек наюлюдения(в общем случае шаблон, по которому аспект находит join Point's)
    @Pointcut("execution(* com.noirix.*.*.*.*(..))")
    public void allMethodPointcut() {
    }

    //Advice - набор инструкции среза
    //так же здесь указывается место действия этих инструкций(В аннотации @Around или похожей)
    @Before("allMethodPointcut()")
    public Object logAroundMethods(JoinPoint joinPoint) throws Throwable {
        this.timeStart = LocalTime.now();
        return joinPoint;
    }

    @After("allMethodPointcut()")
    public Object getCallMethodCount(JoinPoint joinPoint) {
        Duration resultTime = Duration.between(timeStart, LocalTime.now());
        System.out.println("Method {" + joinPoint.getSignature().getDeclaringType().getName() + "."
                + joinPoint.getSignature().getName() + "()"
                + "} working time: {" + resultTime.toMillis() + "}ms");
        return joinPoint;
    }

}