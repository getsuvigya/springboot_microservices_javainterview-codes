package java8tutorials;
@FunctionalInterface
public interface FirstFunctionalInterface {
	void sayHello();
	default void helloWorld(){
		System.out.println("Hello world default method");
	}
}
