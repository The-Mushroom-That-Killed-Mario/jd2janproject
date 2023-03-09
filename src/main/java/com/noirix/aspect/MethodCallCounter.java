package com.noirix.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
@Aspect
public class MethodCallCounter {
    private static final Map<String, Integer> methodCallCounter = new TreeMap<>();

    //Срез точек наюлюдения(в общем случае шаблон, по которому аспект находит join Point's)
    @Pointcut("execution(* com.noirix.*.*.*.*(..))")
    public void beforeMethodPointcut() {
    }

    //Advice - набор инструкции среза
    //так же здесь указывается место действия этих инструкций(В аннотации @Around или похожей)
    //так же в зависим
    @Before("beforeMethodPointcut()")
    public Object logAroundMethods(JoinPoint joinPoint) throws Throwable {
        String methodPath = joinPoint.getSignature().getDeclaringType().getName() +":"+ joinPoint.getSignature().getName()+"()";

        if (methodCallCounter.containsKey(methodPath)) {
            methodCallCounter.put(methodPath, methodCallCounter.get(methodPath) + 1);
        } else {
            methodCallCounter.put(methodPath, 1);
        }

        return joinPoint;
    }

    public static void getCallMethodCount() {
        System.out.println("=================================");
        System.out.println("Количество вызовов разных методов");
        methodCallCounter.forEach((key, value) -> System.out.println("Method : " + key + " callCount: " + value));
    }
}
