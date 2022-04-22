package exam15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(input.readLine());
    String[] arr = new String[t];
    for (int i = 0; i < t; i++) {
      arr[i] = input.readLine();
    }
    
    for (String s : arr) {
      int sum =  Integer.parseInt(s.split(" ")[0]) + Integer.parseInt(s.split(" ")[1]);
      print.write(sum + "\n");
    }
    print.flush();
    print.close();
  }
}
