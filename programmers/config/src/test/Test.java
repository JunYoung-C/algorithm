package test;

import java.io.IOException;
import java.util.Arrays;

public class Test {
  static public int s() {
    String o1 = "300";
    String o2 = "30";
    int L = Math.min(o1.length(), o2.length());
    System.out.println(o1.substring(o1.length() - L) + " " + o2.substring(o2.length() - L));

    if (o1.substring(0, L).compareTo(o2.substring(0, L)) == -1) {
      return 1;
    } else if (o1.substring(0, L).compareTo(o2.substring(0, L)) == 1) {
      return -1;
    } else {
      int a = Integer.parseInt(o1.substring(o1.length() - L));
      int b = Integer.parseInt(o2.substring(o2.length() - L));
      return b - a;
    }
  }
  public static void main(String[] args) throws IOException {

    System.out.println(s());
  }
}
