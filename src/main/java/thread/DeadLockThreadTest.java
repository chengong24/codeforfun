package thread;

public class DeadLockThreadTest {

	public static String A = "A";
	public static String B = "B";

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {

				synchronized (A) {
					//必须停顿一段时间才能出现死锁。不然线程A有可能立即获得B。
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					synchronized (B) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						System.out.println('A');
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (B) {
					synchronized (A) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println('B');
					}
				}
			}
		}).start();

	}

}
