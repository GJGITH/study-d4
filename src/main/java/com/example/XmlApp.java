package com.example;

import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example1.ComplexObject;

public class XmlApp {

	private static final Logger log = LoggerFactory.getLogger(XmlApp.class);
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		context.registerShutdownHook();
		log.debug("学习依赖注入...");
		log.info("Context = {}", context);
		
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
		XmlBean xmlBean = (XmlBean) context.getBean("xmlBean");
		System.out.println(xmlBean);
		XmlBean2 xmlBean2 = (XmlBean2) context.getBean("xmlBean2");
		System.out.println(xmlBean2);
		Locale locale = context.getBean(Locale.class);
		System.out.println(locale);
		
		/*AbstractApplicationContext context = new ClassPathXmlApplicationContext("context2.xml");
		ComplexObject complex = (ComplexObject)context.getBean("ComplexObject");
		System.out.println(complex);*/
		int count =context.getBeanDefinitionCount();
		System.out.println("total bean defined: " + count);
		String[] names = context.getBeanDefinitionNames();
		for (String name: names) {
			System.out.println(context.getBean(name));
		}
	}

}
