package Spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl implements IDemoService {

	@Override
	@Async
	public int add(int a, int b) {
		System.out.println(Thread.currentThread().getName());
		return  a+b;
	}



}
