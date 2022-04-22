package exam05;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public String solution(int n, int[] arr) {
    String answer = "U";
    // 내가 짠 코드. 맞았지만 n^2이기 때문에 틀린 것으로 간주하자
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // if (arr[i] == arr[j]) {
    // return "D";
    // }
    // }
    // }

    // sort사용, nlogn
//    Arrays.sort(arr);
//    for (int i = 0; i < n - 1; i++) {
//      if (arr[i] == arr[i + 1]) return "D";
//    }
    
    // 해시맵 사용, n
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int key : arr) {
      map.put(key, map.getOrDefault(key, 0) + 1);
      if (map.get(key) > 1) {
        return "D";
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    System.out.println(T.solution(n, arr));
  }
}
