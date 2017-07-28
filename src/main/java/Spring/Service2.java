package Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Service2 {
	@Autowired
	private  BeanTest  bean;

	@Async
	public void sayHello() {
		
		
		
		System.out.println(bean);

	}
	
	
	
	
	
	

}
