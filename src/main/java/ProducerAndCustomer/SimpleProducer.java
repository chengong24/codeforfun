package ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

public class SimpleProducer {

	private BlockingQueue<Action> queue;


	public SimpleProducer( BlockingQueue<Action> queue) {
		this.queue = queue;

	}


	public void addTask(Action action) {

		if(!this.queue.offer(action)){
		
		System.out.println("任务队列已经满了");
		}
		
	}

	
}
