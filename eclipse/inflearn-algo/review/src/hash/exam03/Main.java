package hash.exam03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> solution(int n, int k, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0;
    
    for(; i < k; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    answer.add(map.size());
    
    for (; i < n; i++) {
      int key = arr[i];
      int prevKey = arr[i-k];
      map.put(key, map.getOrDefault(key, 0) + 1);
      if (map.get(prevKey) == 1) {
        map.remove(prevKey);
      } else {
        map.put(prevKey, map.get(prevKey) - 1);
      }
      answer.add(map.size());
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
