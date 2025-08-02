package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
public static void main(String args[]) {
	ApplicationContext ioc= new AnnotationConfigApplicationContext(Configration.class);
	ProductDAO dao= ioc.getBean(ProductDAO.class);
	Product p=new Product();
//	p.setId(1);
//	p.setName("Ball");
//	p.setPrice(100);
//	dao.save(p);  // Save product to DB
//     System.out.println("Product saved!");
	
}
}
