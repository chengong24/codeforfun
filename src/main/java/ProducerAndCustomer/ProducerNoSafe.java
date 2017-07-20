package ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

/**
 * 线程不安全的版本。如果外部多个线程操作addTask将会导致任务丢失。
 * 
 * threadPool中间，execute方法本身的执行是同步的。只是Runable中的run方法是异步的。要实现全异步还是比较困难。
 * @author xujianxing
 *
 */
public class ProducerNoSafe implements Runnable {

	private Thread t;
	private BlockingQueue<Action> queue;

	private Action temp;

	public ProducerNoSafe(ThreadFactory threadFactory, BlockingQueue<Action> queue) {
		t = threadFactory.newThread(this);
		this.queue = queue;

	}

	@Override
	public void run() {
		while (true) {
			if (temp != null) {
				this.queue.offer(temp);
			}
		}

	}

	public void addTask(Action action) {

		this.temp = action;
		
	}

	public void start() {
		this.t.start();
	}
}
