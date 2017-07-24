package ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadProducer {
	
	private BlockingQueue<AbstractAction> queue;
	
	
	private  ExecutorService  executor;
	
	public  ThreadProducer(BlockingQueue<AbstractAction>   queue){
		
		this.queue=queue;
		 this. executor = Executors.newSingleThreadExecutor();
		
	}

	public  void  addTask(AbstractAction  action){
		
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
			queue.offer(action);
				
			}
		});
	}

}
