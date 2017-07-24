package Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Service2 instance = context.getBean(Service2.class);
		instance.sayHello();

	}
}
