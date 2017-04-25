package com.myboot.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeCountAspect {

	private static final Logger log = LoggerFactory.getLogger(TimeCountAspect.class);
	
	//@Pointcut("execution(* com.myboot..*.*(..))")
	@Pointcut("@annotation(com.myboot.aspect.TimeCount)")
	public void timeCountPointCut(){}
	
	@Around("timeCountPointCut()")
	public Object doTimeCount(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		long end = 0L;
		boolean isProceedWithException = false;
		try {
			Object result = joinPoint.proceed();
			end = System.currentTimeMillis();
			return result;
		} catch (Throwable t) {
			end = System.currentTimeMillis();
			throw t;
		}finally{
			String msg = String.format("execute: %s with args: %s [costing %dms]", joinPoint.getSignature(), Arrays.asList(joinPoint.getArgs()), end-start );
			log.debug("@@@@@@@@@@@@@@@@@@" + msg);
		}
	}
}
