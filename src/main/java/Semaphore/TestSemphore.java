package Semaphore;

import java.util.concurrent.Semaphore;
/**
 * 使用信号量作为生产者-消费者数据。这就意味着生产和消费都是并发的。
 * @author xujianxing
 *
 */
public class TestSemphore {
  static 	int flag=0;
	public static void main(String[] args) {
	
		String[]   bag=new String[5];
		Semaphore  p=new Semaphore(5, false);
		Semaphore  c=new Semaphore(5, false);
		
		Runnable producer = () -> {
			try {
				p.acquire();
				bag[flag]=flag+"";
				flag++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				p.release();
			}
		};
		
		
		Runnable customer = () -> {
			try {
				c.acquire();
				flag--;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("over");
		};
		for(int i=0;i<10;i++){
			
			new Thread(producer).start();
		}
		
	}

}
