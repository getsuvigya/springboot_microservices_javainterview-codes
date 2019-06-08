package corejavatrickyquestions;
/*
 * Runtime exception as IllegalArgumentException is different from ArithmeticException
 * hence it will not be caught.
 */
public class Test02 {
	 public static void m1() {
	  try {
	   throw new IllegalArgumentException("exce");
	  } catch (ArithmeticException e) {
	   e.printStackTrace();
	  }
	 }

	 public static void main(String[] args) {
	  m1();
	 }
	}