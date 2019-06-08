package java8tutorials.practicalexample;

public class LambdaShapeExpression {
public static void main(String[] args) {
	ShapeInterface s = ()->{
		System.out.println("Draw square");
	};
	s.draw();
	s = ()->{
		System.out.println("draw triangle");
	};
	s.draw();
}
}
