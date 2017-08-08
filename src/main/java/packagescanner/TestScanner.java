package packagescanner;

import java.io.IOException;

import com.brandy.test.Test;



public class TestScanner {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
   Class<?> clazz0 = new Test().getClass();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = Class.forName("com.brandy.test.Test");
		Class<?> clazz1 = Class.forName("com.brandy.test.Test");
		Class.forName("com.brandy.test.Test");
		System.out.println(clazz.getClassLoader()==cl);
		System.out.println(clazz0);
		System.out.println(clazz0 == clazz1);
		System.out.println(clazz == clazz1);
		System.out.println(cl);
		System.out.println(clazz.getClassLoader());
		Class<?> clazz2 = cl.loadClass("com.brandy.test.Test");
		System.out.println(clazz == clazz2);
		
		// Enumeration<URL> urls = cl.getResources("");
		// while (urls.hasMoreElements()) {
		// URL u = urls.nextElement();
		// System.out.println(u);
		// System.out.println("文件协议:" + u.getProtocol());
		// System.out.println("路径:" + u.getPath());
		// }

		// Enumeration<URL> testUrls = cl.getResources("com/brandy/test");
		//
		// Class.forName(className)
		// while (testUrls.hasMoreElements()) {
		// URL u = testUrls.nextElement();
		// System.out.println(u);
		// System.out.println("文件协议:" + u.getProtocol());
		// System.out.println("路径:" + u.getPath());
		// }

	}

}
