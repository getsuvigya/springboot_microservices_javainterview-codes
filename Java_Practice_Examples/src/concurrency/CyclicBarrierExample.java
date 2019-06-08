package concurrency;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	public static void main(String[] args) {
		Person person = new Person();
		CyclicBarrier barrier = new CyclicBarrier(3);
		Thread nameThread = new Thread(new NameThread(person, barrier));
		Thread addressThread = new Thread(new AddressThread(person, barrier));
		nameThread.start();
		addressThread.start();
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("In main thread----------------->>>>> Person name is "+person.getName()+" and his address is "+person.getAddress());
	}
}
class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3306642613185492048L;
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

class NameThread implements Runnable{
	private Person person;
	private CyclicBarrier barrier;
	public NameThread(Person person, CyclicBarrier barrier) {
		this.barrier = barrier;
		this.person = person;
	}
	@Override
	public void run() {
		File nameFile = new File("nameFile.txt");
		String name = "Cyclic Barrier Person";
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(name);
		objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(nameFile);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		String nameFromFile = (String) inputStream.readObject();
		inputStream.close();
		person.setName(nameFromFile);
		barrier.await();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("In name Thread---------------->>>>> Person name is "+person.getName()+" and his address is "+person.getAddress());
	}
	
}

class AddressThread implements Runnable{
	private Person person;
	private CyclicBarrier barrier;
	
	public AddressThread(Person person, CyclicBarrier barrier) {
		this.barrier = barrier;
		this.person = person;
	}
	@Override
	public void run() {
		File addressFile = new File("addressFile.txt");
		String address = "Noida";
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(addressFile);
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(address);
		objectOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(addressFile);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		String addressFromFile = (String) inputStream.readObject();
		inputStream.close();
		
		person.setAddress(addressFromFile);
		barrier.await();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("In address thread ----------->>>>>> Person name is "+person.getName()+" and his address is "+person.getAddress());
}
}