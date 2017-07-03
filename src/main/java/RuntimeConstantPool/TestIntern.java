package RuntimeConstantPool;

import java.util.Random;

public class TestIntern {

	/**
	 * 总结：jdk1,6常量池放在方法区，jdk1.7常量池放在堆内存
	 * ，jdk1.8放在元空间里面，和堆相独立。所以导致string的intern方法因为以上变化在不同版本会有不同表现。
	 * 
	 * @param args
	 */
	static final int MAX = 100000;
	static final String[] arr = new String[MAX];

	public static void main(String[] args) throws Exception {
		// 为长度为10的Integer数组随机赋值
		Integer[] sample = new Integer[10];
		Random random = new Random(1000);
		for (int i = 0; i < sample.length; i++) {
			sample[i] = random.nextInt();
		}
		// 记录程序开始时间
		long t = System.currentTimeMillis();
		// 使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
		for (int i = 0; i < MAX; i++) {
			//arr[i] = new String(String.valueOf(sample[i % sample.length]))这种方式会导致arr持有对String的引用。从而无法回收缓存。但是使用intern()性能会稍稍下降。
			arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
			
		}
		System.out.println((System.currentTimeMillis() - t) + "ms");
		System.gc();
	}
}
