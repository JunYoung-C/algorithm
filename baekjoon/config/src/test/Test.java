package test;

public class Test {
  public static void main(String[] args) {
    long a = 0L;
    a += Integer.MAX_VALUE;
    a += Integer.MAX_VALUE;
    System.out.println(a);
  }
}
