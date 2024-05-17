package org.example.aopexam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Pointcut("execution(* org.example.aopexam.SimpleService.*(..))")
    public void pc(){

    }

    @Pointcut("execution(* hello())")
    public void pc2(){

    }

    @Before("execution(* org.example.aopexam.SimpleService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before ::::::::  " + joinPoint.getSignature().getName());
    }

    @After("execution(* org.example.aopexam.SimpleService.*(..))")
    public void after() {
        System.out.println("After ::::::::  ");
    }

    @AfterReturning(pointcut = "execution(String org.example.aopexam.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("!! After method : " + joinPoint.getSignature().getName() + ", return value : " + result);
    }

    @Before("execution(* setName(..))")
    public void beforeName(JoinPoint joinPoint){
        System.out.println("BeforeName ::::::  " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        for(Object arg : args){
            System.out.println("::::::::: args ==> " + arg);
        }
    }

    @AfterThrowing(value = "pc2()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("!!! AfterThrowing ::::::  " + joinPoint.getSignature().getName());
        System.out.println("!!! Exception ::::::: " + ex);
    }

    @Around("pc()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around run ::::::::::::::::::::: 실제 호출된 메소드가 실행되기 전에 할 일 구현");

        String value = (String) joinPoint.proceed();    // 실제 target 메소드 호출

        System.out.println("Around run ::::::::::::::::::::: 실제 호출된 메소드가 실행 된 후 할 일 구현");
        value += "kim aop run @@";

        return value;
    }

}
