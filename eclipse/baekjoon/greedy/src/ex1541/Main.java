package ex1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public int solution(String str) {
    int answer = 0;
    // -를 기준으로 1차 분리
    String[] noMinus = str.split("-");
    ArrayList<Integer> arr = new ArrayList<>();
    for (String s : noMinus) {
      // +를 기준으로 분리 후 계산, 처음부터 숫자면 바로 더하기
      if (s.contains("+")) {
        int sum = 0;
        for (String strNum : s.split("\\+")) {
          sum += Integer.parseInt(strNum);
        }
        arr.add(sum);
      } else {
        arr.add(Integer.parseInt(s));
      }

    }

    answer = arr.get(0);
    for (int i = 1; i < arr.size(); i++) {
      answer -= arr.get(i);
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(T.solution(str));
  }
}

