package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchDemo {
public static void main(String[] args) {
	Person p1 = new Person();
	CountDownLatch countDownLatch = new CountDownLatch(2);
	NameThread1 nameThread = new NameThread1(countDownLatch);
	AddressThread1 addressThread1 = new AddressThread1(countDownLatch);
	ExecutorService executorService = Executors.newFixedThreadPool(2);
	Future<String> futureNameObj = executorService.submit(nameThread);
	Future<String> futureAddObj = executorService.submit(addressThread1);
	
	try {
		p1.setAddress(futureAddObj.get());
		p1.setName(futureNameObj.get());
		countDownLatch.await();
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Name: "+p1.getName()+" address: "+p1.getAddress());
	executorService.shutdown();
	while(!executorService.isTerminated());
	System.out.println("Count down latch completed");
	
}
}
class Person1{
	private String name;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

class NameThread1 implements Callable<String>{
	CountDownLatch countDownLatch;
	public NameThread1(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.countDownLatch = latch;
	}
	@Override
	public String call() throws Exception {
		String s= "Ravi";
		Thread.sleep(10000);
		countDownLatch.countDown();
		return s;
	}
	
}

class AddressThread1 implements Callable<String>{
	CountDownLatch countDownLatch;
	public AddressThread1(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.countDownLatch = latch;
	}
	@Override
	public String call() throws Exception {
		String s= "Noida";
		Thread.sleep(10000);
		countDownLatch.countDown();
		return s;
	}
	
}