package bruteforce.ex4678;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
  public String solution() throws IOException {
    String answer = "";
    boolean[] isNotSelfNum = new boolean[10001];
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = 1;
    while (true) {
      int num = calcNum(n++);
      if (num <= 10000) {
        isNotSelfNum[num] = true;
      } 
      
      if (n > 10000) {
        break;
      }
    }
    for (int i = 1; i <= 10000; i++) {
      if (!isNotSelfNum[i]) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
    bw.close();
    return answer;
  }

  int calcNum(int num) {
    int n = num;
    while (n > 0) {
      num += n % 10;
      n /= 10;
    }
    return num;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();

    try {
      T.solution();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

