package com.mubai.sync.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author leitengfei
 */
@Aspect
@Configuration
public class Pointcuts {

    @Pointcut("execution(* com.mubai.sync.service..*.*.*(..))")
    public void serviceCall() { }

    @Pointcut("execution(* com.mubai.sync.controller..*.*.*(..))")
    public void actionCall() { }
}
