package exam10809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public int[] solution(String str) {
    int[] answer = new int['z' - 'a'+1];
    for (int i = 0; i < 26; i++) {
      answer[i] = -1;
    }
    for (char c : str.toCharArray()) {
      answer[c-'a'] = str.indexOf(c);
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = input.readLine();
    for (int i : T.solution(str)) {
      print.write(i + " ");
    }
    print.flush();
    print.close();
  }
}
