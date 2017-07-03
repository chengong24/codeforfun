package Spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		// Service2 service2 = context.getBean(Service2.class);
		System.out.println(context.getBeanFactory());
		IDemoService service = context.getBean(IDemoService.class);
		service.add(1, 2);
		if (service instanceof IDemoService) {
			System.out.println("service is  IDemoService Type");
		}
		if (service instanceof BeanFactory) {
			System.out.println("service is  BeanFactory Type");
		}
		if (service instanceof FactoryBean) {
			System.out.println("service is  FactoryBean Type");
		}

	}
}
