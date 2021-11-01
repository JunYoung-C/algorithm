package exam1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String str = input.readLine();
    if (str.equals(" ") || str.equals("")) {
      System.out.print("0");
      return;
    }

    System.out.println(str.trim().split(" ").length);
  }
}
