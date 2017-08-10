package Spring.customer.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements  IDemoService {

	
	
	public void add(int a, int b) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(a + b);

	}

	@Override
	@Log
	public String getName() {
		System.out.println("DemoServiceImpl.getName");
		return "DemoServiceImpl";
	}

}
