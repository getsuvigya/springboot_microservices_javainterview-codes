package java8tutorials;

public class ReviseFunctionalInterfaceImpl{
static ReviseFunctionInterface rff = ()-> System.out.println("functional interface revised");
public static void main(String s[]){
	rff.reviseHelloWorld();
	//rff.reviseHello();
	rff = ()-> System.out.println("functional interface revised1");
	rff.reviseHello();
}
}
