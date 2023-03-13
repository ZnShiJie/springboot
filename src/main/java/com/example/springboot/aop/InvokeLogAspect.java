package com.example.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

// 标识切面
@Aspect
@Component
public class InvokeLogAspect {

    // 定义切点方法
    @Pointcut("@annotation(com.example.springboot.aop.InvokeLog)")
    public void pt() {

    }

    @Around("pt()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        MethodSignature signature =  (MethodSignature)joinPoint.getSignature();
        String name = signature.getMethod().getName();

        System.out.println(name + "方法调用前");

        try {
            // 目标方法调用后
            proceed = joinPoint.proceed();
            System.out.println(name + "方法调用后");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return proceed;
    }

}
