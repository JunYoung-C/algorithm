package test;

public class Test {
  public static void main(String[] args) {
    String str = "found7, time: study; Yduts; emit, 7Dnuof";
    str = str.toUpperCase();
    str = str.replaceAll("[^A-Z]", "");
    System.out.print(str);
  }
}
