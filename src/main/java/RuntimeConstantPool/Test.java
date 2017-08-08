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
 *         ![Markdown](http://i2.kiimg.com/1949/d81d7c120c9388d8.png) jmap jmap
 *         -dump:format=b,file=/Users/jesse/Desktop/heap.bin 33630
 */
public class Test {
	public static void main(String[] args) {
		// String a = "myStrAAA";
		// String myStr = new String("myStrAAA");
		// String myStr1 =new String(myStr).intern();
		// System.out.println(a==myStr);
		// System.out.println(a==myStr1);
		// while(true){
		//
		// }
		String str1 = "str01";
		String str2 = new String("str") + new String("01");
		str2.intern();
		System.out.println(str2 == str1);
	}

}
