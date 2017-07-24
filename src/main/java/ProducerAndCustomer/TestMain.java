package ProducerAndCustomer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestMain {
	
	
	public static void main(String[] args) {
		BlockingQueue<AbstractAction> queue=new ArrayBlockingQueue<>(5);
	
	
		for(int i=0;i<4;i++){
			new SimplCustomer(queue).cumstom();
		}
		
		
		ThreadProducer producer=new ThreadProducer(queue);
		for(;;){
			producer.addTask(new AbstractAction(){

				@Override
				public void operation() {
				
					
					
					System.out.println("执行任务！！");
					
				}
			}
					);
			
			
			
			
		}
	}

}
