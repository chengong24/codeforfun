package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;

public class Test {
	static Map<Integer, Thread> threads = new HashMap<>();

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("发令枪响了，跑！");
			
			}
		});

		for (int i = 0; i < 3; i++) {
			MyThread t = new MyThread(barrier, "运动员" + i + "号", i);
			threads.put(i, t);
			t.start();
		}

	}

}
