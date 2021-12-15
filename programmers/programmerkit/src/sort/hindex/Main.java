package sort.hindex;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int solution(int[] citations) {
    int answer = 0;
    int len = citations.length;
    Arrays.sort(citations);
    
    for (int i = 0; i < len; i++) {
      int cnt = len - i;
      if (citations[i] >= cnt) {
        answer = cnt;
        break;
      }
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

//    int[] citations = new int[] {3, 0, 6, 1, 5};
    int[] citations = new int[] {0, 0, 4, 4, 4};
    System.out.println(T.solution(citations));
  }
}

