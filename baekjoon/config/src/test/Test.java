package test;

public class Test {
  public static void main(String[] args) {
    System.out.println("1+".contains("+"));
//    for (String s : "1+2".split("+")) {
//      System.out.print(s + " ");
//    }
    String str = "1+2-1 1";
    String[] arr = str.split("\\+");
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
