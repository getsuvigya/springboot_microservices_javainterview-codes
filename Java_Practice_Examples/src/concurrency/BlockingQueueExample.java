package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
public static void main(String[] args) throws InterruptedException {
	BlockingQueue<String> blockingQueue= new LinkedBlockingQueue<>();
	BlockingQueueProducer producer = new BlockingQueueProducer(blockingQueue);
	BlockingQueueConsumer consumer = new BlockingQueueConsumer(blockingQueue);
	Thread producerThread = new Thread(producer);
	Thread consumerThread = new Thread(consumer);
	producerThread.start();
	consumerThread.start();
	producerThread.join();
	consumerThread.join();
	System.out.println("Producer Consumer problem completed");
}
}
class BlockingQueueProducer implements Runnable{
	BlockingQueue<String> queue;
	String msg;
	public BlockingQueueProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			String msg = ""+i;
			System.out.println("Msg produced "+msg);
			try {
				queue.put(msg);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String exitMsg = "Exit";
		try {
			System.out.println("This is terminating msg");
			queue.put(exitMsg);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

class BlockingQueueConsumer implements Runnable{
	BlockingQueue<String> queue;
	public BlockingQueueConsumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		String msg;
		try {
			while(!(msg=queue.take()).equals("Exit")){
				System.out.println("Consumed Message "+msg);
				Thread.sleep(1000);
			}
			System.out.println("All messages consumed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}