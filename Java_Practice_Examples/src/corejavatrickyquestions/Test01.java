package corejavatrickyquestions;

/*
 * num is static so null does not matter.Num is internally refered by class
 */
public class Test01 {
 public static int num = 20;

 public static void main(String[] args) {
  Test01 test01 = null;
  System.out.println(test01.num);
 }
}