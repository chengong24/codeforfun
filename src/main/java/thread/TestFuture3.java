package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.security.auth.Subject;

import java8.Order;

/**
 * http://blog.csdn.net/xzplayboy/article/details/71404656 CompletableFuture
 * 抛弃了基于线程池的异步任务，直接在CompletableFuture一个类中完成，功能异乎寻常的强大，简直是吊打原有的Future/Callable模型。再配合流操作，简直要逆天，非常值得学习。
 * 值得注意的是，CompletableFuture不再使用Callable作为可返回的任务接口，而是Supplier
 * 
 * @author xujianxing
 *
 */
public class TestFuture3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(Thread.currentThread().getName());
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		Supplier<List<String>> task = () -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("执行得到订单ID");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			List<String> list = new ArrayList<>();
			list.add("1");
			list.add("2");
			list.add("3");
			list.add("4");
			return list;

		};

		// Function<List<String>, List<Order>> fn = new Function<List<String>,
		// List<Order>>() {
		// @Override
		// public List<Order> apply(List<String> t) {
		// List<Order> orders = new ArrayList<>();
		// for (String string : args) {
		// try {
		// Thread.sleep(100);
		// Order order = new Order();
		// order.setOrderId(string);
		// orders.add(order);
		// } catch (InterruptedException e) {
		//
		// e.printStackTrace();
		// }
		//
		// }
		//
		// return orders;
		// }
		// };

		/**
		 * Lambda方法的参数是apply方法的参数。不是类的参数
		 */
		Function<List<String>, List<Order>> fn = (orderIds) -> {
			System.out.println("开始执行得到订单，订单数：" + orderIds.size());
			List<Order> orders = new ArrayList<>();
			for (String string : orderIds) {
				try {
					Thread.sleep(100);
					Order order = new Order();
					order.setOrderId(string);
					orders.add(order);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println("完成执行得到订单，订单数：" + orders.size());
			return orders;
		};
		CompletableFuture<List<String>> cf = CompletableFuture.supplyAsync(task, threadPool);
		cf.thenApply(fn).thenApply(orders -> {
			System.out.println("执行输出订单,订单数：" + orders.size());
			for (Order order : orders) {
				System.out.println(order.getOrderId());
			}
			return null;
		});

	}
}
