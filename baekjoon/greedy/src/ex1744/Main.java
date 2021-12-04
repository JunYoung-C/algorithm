package ex1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  public int solution(int n, ArrayList<Integer> plusArr, ArrayList<Integer> minusArr) {
    int answer = 0;
    Collections.sort(plusArr, Collections.reverseOrder());
    Collections.sort(minusArr);
    boolean isZero = false;
    
    int pLen = plusArr.size();
    for (int i = 0; i < pLen; i += 2) {
      int a = plusArr.get(i);
      if (i == pLen - 1) {
        answer += a;
        break;
      }
      int b = plusArr.get(i+1);
      
      if (a == 1 || b == 1) {
        answer += a + b;
      } else {
        answer += a * b;
      }
    }

    int mLen = minusArr.size();
    for (int i = 0; i < mLen; i+= 2) {
      int a = minusArr.get(i);
      if (i == mLen - 1) {
        answer += a;
        break;
      }
      int b = minusArr.get(i+1);
      
      answer += a * b;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> plusArr = new ArrayList<>();
    ArrayList<Integer> minusArr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num > 0)
        plusArr.add(num);
      else
        minusArr.add(num);
    }
    System.out.println(T.solution(n, plusArr, minusArr));
  }
}

