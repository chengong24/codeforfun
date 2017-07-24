package ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

public class SimpleProducer {

	private BlockingQueue<AbstractAction> queue;


	public SimpleProducer( BlockingQueue<AbstractAction> queue) {
		this.queue = queue;

	}


	public void addTask(AbstractAction action) {

		if(!this.queue.offer(action)){
		
		System.out.println("任务队列已经满了");
		}
		
	}

	
}
