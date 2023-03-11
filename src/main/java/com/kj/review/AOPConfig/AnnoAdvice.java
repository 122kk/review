package com.kj.review.AOPConfig;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author kj
 * @date 2023/3/8
 * @apiNote
 */

@Aspect
@Slf4j
@Component
public class AnnoAdvice {
    @Pointcut("execution(* com.kj.review.controller.UserController.*(..))")
    public void poincut(){}

    @Around("poincut()")
    public Object AroundLog(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object proceed = point.proceed();
        long runtimes= System.currentTimeMillis() - beginTime;
        recordLog(point,runtimes);
        return proceed;
    }

    @AfterThrowing("poincut()")
    public void AfterExpration(JoinPoint point){
        recordLog(point);
    }

    private void recordLog(ProceedingJoinPoint joinPoint,long time){
        log.info("+++++++++++++++++++++++log start++++++++++++++++++++++");
        String methodName = joinPoint.getSignature().getName();
        log.info("method:{}",methodName);
        Object[] args = joinPoint.getArgs();
        String s = JSON.toJSONString(args);
        log.info("s:{}",s);

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature= (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        log.info("method:{}",method);
        Object target = joinPoint.getTarget();
        log.info("target:{}",target);
        String className = joinPoint.getTarget().getClass().getName();
        log.info("className:{}",className);
        log.info("runTime:{}",time);
        log.info("+++++++++++++++++++++++++log end++++++++++++++++++++++");
    }

    private void recordLog(JoinPoint joinPoint){
        log.info("+++++++++++++++++++++++log start++++++++++++++++++++++");
        String methodName = joinPoint.getSignature().getName();
        log.info("method:{}",methodName);
        Object[] args = joinPoint.getArgs();
        String s = JSON.toJSONString(args);
        log.info("s:{}",s);

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature= (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        log.info("method:{}",method);
        Object target = joinPoint.getTarget();
        log.info("target:{}",target);
        String className = joinPoint.getTarget().getClass().getName();
        log.info("className:{}",className);
        log.info("+++++++++++++++++++++++++log end++++++++++++++++++++++");
    }
}
