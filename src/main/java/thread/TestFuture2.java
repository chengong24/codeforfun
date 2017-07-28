package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * http://blog.csdn.net/xzplayboy/article/details/71404656 CompletableFuture
 * 抛弃了基于线程池的异步任务，直接在CompletableFuture一个类中完成，功能异乎寻常的强大，简直是吊打原有的Future/Callable模型。再配合流操作，简直要逆天，非常值得学习。
 * 值得注意的是，CompletableFuture不再使用Callable作为可返回的任务接口，而是Supplier
 * 
 * @author xujianxing
 *
 */
public class TestFuture2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Void> cf1 = CompletableFuture.runAsync(new Runnable() {

			@Override
			public void run() {

				try {
					Thread.sleep(2000);
					System.out.println("hello CompletableFuture! ");
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}, Executors.newSingleThreadScheduledExecutor());

		cf1.thenRun(new Runnable() {
			@Override
			public void run() {
				System.out.println("异步执行完了，就执行这里！");

			}
		});
		System.out.println("主线程执行完毕");

		CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "async CompletableFuture! ";

		}, Executors.newSingleThreadScheduledExecutor());

		result.thenAccept((str) -> {
			System.out.println("thenAccept");
			System.out.println(str);
		});

		System.out.println("主线程执行完毕");
	}

}
