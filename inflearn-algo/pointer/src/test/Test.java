package test;

public class Test {
  int n = 10;
  public void print() {
    System.out.println(n);
  }
  public static void main(String[] args) {
    Test t = new Test();
    t.n = 5;
    t.print();

    System.out.println(t.n);
  }
}
