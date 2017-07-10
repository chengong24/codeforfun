package nio;

public class TimeMonitor {
	private static long start = 0;

	private static long end = 0;

	public static void start() {

		start = System.currentTimeMillis();
		end = 0;

	}

	public static void end(String  tag) {
		end = System.currentTimeMillis();
		System.out.println("time  coast:"+tag+"---------->" + (end - start));
		end = 0;
		start = 0;
	}

}
