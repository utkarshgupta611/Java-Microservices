package com.prsnl.AOP_concept;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prsnl.AOP_concept.service.PaymentService;

public class App 
{
    public static void main( String[] args )
    {       
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/prsnl/AOP_concept/config.xml");
    	PaymentService payObj = ctx.getBean("payment", PaymentService.class);
    	payObj.makePayment();
    }
}