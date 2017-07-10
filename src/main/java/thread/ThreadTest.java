package thread;

public class ThreadTest {

	static  int      X = 0;
	public static void main(String[] args) {
		
		Runnable r = () -> {
			while (X == 0) {
				X = 1 - X;
			}
			System.out.println("over");
		};
		new Thread(r).start();
		new Thread(r).start();
	}

}
