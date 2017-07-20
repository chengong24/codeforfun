package ProducerAndCustomer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleMain {
	
	
	public static void main(String[] args) {
		
		
		
		ThreadPoolExecutor
		
		BlockingQueue<Action> queue=new ArrayBlockingQueue<>(5);
		SimpleProducer  simpleProducer=new SimpleProducer(queue);
		int  flag=0;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(;;){
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					simpleProducer.addTask(new Action() {
						
						@Override
						public void operation() {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
							System.out.println("运动起来:"+ System.currentTimeMillis());
						}
					});
				}
				
			}
		}).start();
		
		
		
		for(int i=0;i<4;i++){
			new SimplCustomer(queue).cumstom();
		}
	}

}
