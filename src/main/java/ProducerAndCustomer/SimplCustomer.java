package ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;

public class SimplCustomer implements Runnable {

	private BlockingQueue<AbstractAction> queue;
	private Thread t;

	public SimplCustomer(BlockingQueue<AbstractAction> queue) {
		this.queue = queue;

		t = new Thread(this);

	}

	@Override
	public void run() {

		AbstractAction task = null;
		try {
			while ((task = queue.take()) != null) {

				task.operation();
				System.out.println("执行完成一个任务");

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void cumstom() {
		t.start();
	}

}