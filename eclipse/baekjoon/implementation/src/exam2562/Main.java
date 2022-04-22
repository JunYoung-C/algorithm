package exam2562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int max = Integer.MIN_VALUE;
    int index = -1;
    for (int i = 1; i <= 9; i++) {
      int n = Integer.parseInt(input.readLine());
      if (n > max) {
        max = n;
        index = i;
      }
    }
    print.write(max + "\n");
    print.write(index + "");
    print.flush();
    print.close();
  }
}
