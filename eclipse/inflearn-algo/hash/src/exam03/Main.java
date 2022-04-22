package exam03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> solution(int n, int k, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int lt = 0, rt;
    
    for (rt = 0; rt<k; rt++) {
      map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
    }
    answer.add(map.size());
    

    while (rt < n) {
      map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
      if (map.get(arr[lt]) == 1) {
        map.remove(arr[lt]);
      } else {
        map.put(arr[lt], map.get(arr[lt]) - 1);
      }
      answer.add(map.size());
      rt++;
      lt++;
    }
    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int k = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    for (int i: T.solution(n, k, arr)) {
      System.out.print(i + " ");
    }
  }
}
