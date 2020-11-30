package com.romanticlei.study.interview;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(public int com.romanticlei.study.interview.CalcServiceImpl.*(..))")
    public void beforeNotify(){
        System.out.println("*********@Before 我是前置通知MyAspect");
    }

    @After("execution(public int com.romanticlei.study.interview.CalcServiceImpl.*(..))")
    public void afterNotify(){
        System.out.println("*********@After 我是后置通知MyAspect");
    }

    @AfterReturning("execution(public int com.romanticlei.study.interview.CalcServiceImpl.*(..))")
    public void afterReturningNotify(){
        System.out.println("*********@AfterReturning 我是返回后通知MyAspect");
    }

    @AfterThrowing("execution(public int com.romanticlei.study.interview.CalcServiceImpl.*(..))")
    public void afterThrowingNotify(){
        System.out.println("*********@AfterThrowing 我是异常通知MyAspect");
    }

    @Around("execution(public int com.romanticlei.study.interview.CalcServiceImpl.*(..))")
    public Object aroundNotify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;
        System.out.println("我是环绕通知之前 AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知之后 BBB");
        return retValue;
    }

}
