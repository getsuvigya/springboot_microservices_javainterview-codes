package singleton;

public class SimpleSingletonDemo {
public static void main(String[] args) {
	SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
	simpleSingleton.m1();
}
}
class SimpleSingleton{
	 private SimpleSingleton(){
		 
	 }
	 private static final SimpleSingleton obj=new SimpleSingleton();
	  public static SimpleSingleton getInstance(){
		return obj;
	  }
	  
	  public void m1(){
		  System.out.println("Created Simple Singleton Class");
	  }
}