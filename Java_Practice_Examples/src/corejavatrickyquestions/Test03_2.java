package corejavatrickyquestions;

public class Test03_2 extends Test03 {

	 public Test03_2() {
	  System.out.println(super.num);//not visible due to private modifier compile time exception
	 }

	 public static void main(String[] args) {
	  Test03_2 test03_2 = new Test03_2();
	 }
	}

	// another class in the same package

	 class Test03 {
	 private int num = 25;
	}