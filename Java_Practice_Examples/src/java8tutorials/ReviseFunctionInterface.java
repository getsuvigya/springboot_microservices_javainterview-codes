package java8tutorials;

@FunctionalInterface
public interface ReviseFunctionInterface {
	void reviseHello();
	default void reviseHelloWorld(){
		System.out.println("revise default hello world");
	}
}
