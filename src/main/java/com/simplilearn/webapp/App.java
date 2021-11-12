package com.simplilearn.webapp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.simplilearn.webapp.bean.Employee;

public class App {
	
	public static void main(String[] args) {
		
		// Tightly coupled object /class
//		Employee employee = new Employee();
//		employee.setId(1100116);
//		employee.setName("John Smith");
//		employee.setSalary(456567.6879);
//		employee.setDept("Engineering");		
//		System.out.println(employee);
		
		// IOC : Inversion of control => Provide loose coupling : (DI) dependency Injection.
		// 1. Application Context container type
		ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean.xml");
		Employee employee1 = (Employee) context.getBean("employee1");
		Employee employee2 = context.getBean("employee2", Employee.class);
		
		System.out.println(employee1);
		System.out.println(employee2);
		
		System.out.println("--------------------------");
		
		// 2. Bean Factory Container
		Resource resource = new ClassPathResource("employee-bean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
//		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("employee-bean.xml"));
		Employee emp1 = (Employee) factory.getBean("employee1");
		Employee emp2 = factory.getBean("employee2", Employee.class);
		System.out.println(emp1);
		System.out.println(emp2);
	}
}
