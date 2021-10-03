package com.prsnl.AOP_concept.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	@Before("execution(* com.prsnl.AOP_concept.service.PaymentServiceImpl.makePayment())")
	public void printBefore() 
	{
		System.out.println("payment started...... Before");
	}
	
	
}
