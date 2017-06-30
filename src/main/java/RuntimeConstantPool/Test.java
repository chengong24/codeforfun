package RuntimeConstantPool;

/**
 * 
 * JVM Runtime: Last login: Fri Jun 30 10:54:46 on ttys000 localhost:~ jesse$
 * java -version java version "1.8.0_131" Java(TM) SE Runtime Environment (build
 * 1.8.0_131-b11) Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed
 * mode) localhost:~ jesse$
 * 
 * @author jesse
 *         http://tech.meituan.com/in_depth_understanding_string_intern.html
 *         http://tech.meituan.com/mt-trip-springmvc-service-annotation-problem-research.html
 *         ![Markdown](http://i2.kiimg.com/1949/d81d7c120c9388d8.png) jmap
 *         -dump:format=b,file=/Users/jesse/Desktop/heap.bin 33630
 */
public class Test {
	public static void main(String[] args) {

		/**
		 * 在堆内部，等价于 String a=new String("myStrAAA") // 然后同时引用了
		 * "myStrAAA"。可以看出来，String 中的赋值操作 相当于是重新new
		 * 了一个对象操作符重载。这样才不会引起原来被引用的字符串变化。（JDK8是这样）
		 */
		String a = "myStrAAA";
		String myStr = new String("myStrAAA");
		while (true) {

		}

	}

}
