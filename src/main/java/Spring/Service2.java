package Spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Service2 {

	@Async
	public void sayHello() {
		
		
		
		System.out.println("hello!!!!!Service2");

	}

}
