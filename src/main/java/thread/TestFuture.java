package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> future = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.currentThread().sleep(3000);
				return "hello future";
			}

		});
		System.out.println(future.get());
	}

}
