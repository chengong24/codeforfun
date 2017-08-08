package RuntimeConstantPool;

import java.util.Random;

public class TestIntern2 {

	/**
	 * 总结：jdk1,6常量池放在方法区，jdk1.7常量池放在堆内存
	 * ，jdk1.8放在元空间里面，和堆相独立。所以导致string的intern方法因为以上变化在不同版本会有不同表现。
	 * 
	 * @param args
	 */
	static final int MAX = 10737410;
	static final String[] arr = new String[MAX];

	public static void main(String[] args) throws Exception {
		Thread.sleep(10000);
		Integer[] sample = new Integer[10];
		Random random = new Random(1000);
		for (int i = 0; i < sample.length; i++) {
			sample[i] = random.nextInt();
		}
		// 记录程序开始时间
		long t = System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();	
		}
		System.out.println((System.currentTimeMillis() - t) + "ms");
		
		
	}
}
