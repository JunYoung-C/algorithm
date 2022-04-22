package hash.ex03;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public int[] solution(int n, int m, int[] arr) {
    int[] answer = new int[n - m + 1];
    int lt = 0, rt = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for (; rt < m; rt++) {
      map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
    }
    answer[lt] = map.size();

    for (; rt < n; rt++) {
      map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
      map.put(arr[lt], map.get(arr[lt]) - 1);
      
      if (map.get(arr[lt]) == 0) {
        map.remove(arr[lt]);
      }
      
//      for (int key : map.keySet()) {
//        System.out.println(key + " " + map.get(key));
//      }
//      System.out.println();
      answer[++lt] = map.size();
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);

    int n = stdIn.nextInt();
    int m = stdIn.nextInt();
    int[] arr = new int[n];
    
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    
    for (int i : T.solution(n, m, arr)) {
      System.out.print(i + " ");
    }
  }
}
