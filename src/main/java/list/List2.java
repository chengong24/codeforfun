package list;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.util.SystemPropertyUtils;

import thread.MyLock;

public class List2 {
	private static final int COUNT_BITS = Integer.SIZE - 3;
	private static final int CAPACITY = (1 << COUNT_BITS) - 1; // << : 左移运算符，num
																// <<
																// 1,相当于num乘以2

	// runState is stored in the high-order bits
	private static final int RUNNING = -1 << COUNT_BITS;
	private static final int SHUTDOWN = 0 << COUNT_BITS;
	private static final int STOP = 1 << COUNT_BITS;
	private static final int TIDYING = 2 << COUNT_BITS;
	private static final int TERMINATED = 3 << COUNT_BITS;

	private static int workerCountOf(int c) {
		return c & CAPACITY;
	}

	private static int ctlOf(int rs, int wc) {
		return rs | wc;
	}

	public static void main(String[] args) {

		// int ctl = ctlOf(RUNNING, 5);
		// System.out.println(RUNNING);
		// System.out.println(workerCountOf(ctl));
		MyLock lock = new MyLock();
		lock.lock();
		System.out.println(lock.tryLock());
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// LockSupport.park(this);
				System.out.println("尝试获取锁");
				lock.lock();
				System.out.println("执行");

			}
		});
		t.start();
		t.interrupt();
	}
}
