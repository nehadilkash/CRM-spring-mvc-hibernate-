package com.neha.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class LoggingAspect {
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.cognizant.springdemo.controller.*.*(..))")
	public void controllerPointcut(){
		
	}

	@Pointcut("execution(* com.cognizant.springdemo.service.*.*(..))")
	public void servicePointcut(){
		
	}
	
	@Pointcut("execution(* com.cognizant.springdemo.DAO.*.*(..))")
	public void DAOPointcut(){
		
	}
	
	@Pointcut("controllerPointcut()||servicePointcut()||DAOPointcut()")
	public void myAppPointcut() {}
	
	@Before("myAppPointcut()")
	public void beforeLoggingAspectAdvice(JoinPoint joinPoint)
	{
		Signature method=joinPoint.getSignature();
		myLogger.info("**********executing @before advice !!!! hurray************");
		myLogger.info("===============>executing  "+method +"************");
		
		Object[] args=joinPoint.getArgs();
		for (Object object : args) {
			myLogger.info("argument is-----------"+ object);
		}
	}
	
	@AfterReturning(pointcut="myAppPointcut()",returning="result")
	public void afterReturningLoggingAspectAdvice(JoinPoint joinPoint,Object result)
	{
		Signature method=joinPoint.getSignature();
		myLogger.info("**********executing @AfterReturning advice !!!! hurray************");
		myLogger.info("===============>executing  "+method +"************");
		myLogger.info("result is =========="+result.toString());
		
	}
}
