package exam01;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public char solution(int n, String str) {
    // // 내가 짠 코드
    // char answer;
    // int[] voteArr = new int[5];
    //
    // for (char c: str.toCharArray()) {
    // voteArr[c-'A']++;
    // }
    //
    // int max = voteArr[0];
    // int index = 0;
    // for (int i = 1; i < 5; i++) {
    // if (max < voteArr[i]) {
    // max = voteArr[i];
    // index = i;
    // }
    // }
    //
    // answer = (char)(index + 'A');

    // 해시맵 이용
    char answer = ' ';
    HashMap<Character, Integer> map = new HashMap<>();
    for (char x : str.toCharArray()) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    int max = Integer.MIN_VALUE;
    for (char key : map.keySet()) {
      if (map.get(key) > max) {
        max = map.get(key);
        answer = key;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    String str = stdIn.next();
    System.out.println(T.solution(n, str));
  }
}
