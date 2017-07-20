package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyThread extends Thread {
	private CyclicBarrier cyclicBarrier;
	private String name;
	private int ID;

	public MyThread(CyclicBarrier cyclicBarrier, String name, int ID) {
		super();
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
		this.ID = ID;

	}

	@Override
	public void run() {
		System.out.println(name + "开始准备");
		try {
			Thread.sleep(ID * 1000);
			System.out.println(name + "准备完毕！在起跑线等待发令枪");
			try {
				
//					cyclicBarrier.await((ID + 1) * 1000, TimeUnit.MILLISECONDS);
					cyclicBarrier.await();
				
				System.out.println(name + "跑完了路程！");
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
				System.out.println(name + "看不见起跑线了");
			}
			System.out.println(name + "退场！");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
