package com.niit.onlineshop.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Testcategory {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.onlineshop.model");
		context.refresh();
		context.getBean("category");
		System.out.println("category created successfully");

	}

}
