package dp.presentn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
  public int solution(int N, int number) {
    int answer = -1;

    ArrayList<Set<Integer>> numbers = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      numbers.add(new HashSet<>());
    }

    for (int i = 1; i < 9; i++) {
      numbers.get(i).add(numberRepeat(N, i));
      
      for (int j = 1; j < i; j++) {
        for (int lt : numbers.get(j)) {
          for (int rt : numbers.get(i - j)) {
            numbers.get(i).add(lt + rt);
            numbers.get(i).add(lt - rt);
            numbers.get(i).add(lt * rt);
            if (rt != 0) {
              numbers.get(i).add(lt / rt);
            }
          }
        }
      }
      
      if (numbers.get(i).contains(number)) {
        return i;
      }
    }
    return answer;
  }

  private int numberRepeat(int N, int cnt) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < cnt; i++) {
      sb.append(N);
    }

    return Integer.parseInt(sb.toString());
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

    int n = 5;
    int number = 12;

    // int n = 2;
    // int number = 11;
    System.out.println(T.solution(n, number));
  }
}
