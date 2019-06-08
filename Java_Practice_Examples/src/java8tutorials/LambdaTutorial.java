package java8tutorials;

public class LambdaTutorial {
public static void main(String[] args) {
	FirstFunctionalInterface firstFunctionalInterface = () -> System.out.println("Hello");
	firstFunctionalInterface.sayHello();
	firstFunctionalInterface.helloWorld();
}

}
