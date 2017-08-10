package Spring.customer.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");	
		 IDemoService demoService = context.getBean(IDemoService.class);	
		 System.out.println(demoService.getName());
//		 IDemoService demoService2 = context.getBean(IDemoService.class);	
//		 System.out.println(demoService2);
////		 AsyncAnnotationBeanPostProcessor	 
		demoService.add(1, 2);
//		 AsyncAnnotationAdvisor
	}
}
