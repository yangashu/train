package com.trkj.train.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut(value = "execution(* com.trkj.train.config.dto.service..*.*(..)) || execution(* com.trkj.train.service..*.*(..)) || execution(* com.trkj.train.config.dto.mapper..*.*(..)) || execution(* com.trkj.train.mapper..*.*(..))")
    public void logPointCut(){
    }
    @Before(value = "logPointCut()")
    public void beforeAdivce(JoinPoint joinPoint){
        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>进入{}类的{}方法！",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature());
    }
    @After(value ="logPointCut()")
    public void afterAdivce(JoinPoint joinPoint){
        log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<完成{}类的{}方法的调用！",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature());
    }

    @Pointcut(value = "execution(* com.trkj.train.config.dto.service..*.*(..)) || execution(* com.trkj.train.service..*.*(..)) || execution(* com.trkj.train.config.dto.mapper..*.*(..)) || execution(* com.trkj.train.mapper..*.*(..))")
    public void matchAll() {}

    @Around("matchAll()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        for (int i=0;i<joinPoint.getArgs().length;i++) {
            System.out.println(joinPoint.getArgs()[i]);
        }
        try{
            result = joinPoint.proceed(joinPoint.getArgs());//获取参数
            System.out.println("after 在切入点执行后运行,result = " + result);
        } catch (Throwable e) {
            System.out.println("after 在切入点执行后抛出exception运行="+result);
            e.printStackTrace();
        } finally {
            System.out.println("finally......");
        }

        return result;
    }
}