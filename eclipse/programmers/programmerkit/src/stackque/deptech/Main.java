package stackque.deptech;

import java.util.ArrayList;
import java.util.Scanner;

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = {};
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Integer> cntArr = new ArrayList<>();
    int len = speeds.length;

    for (int i = 0; i < len; i++) {
      int num = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
      arr.add(num);
    }

    int max = arr.get(0);
    int cnt = 1;
    for (int i = 1; i < len; i++) {
      if (max < arr.get(i)) {
        max = arr.get(i);
        cntArr.add(cnt);
        cnt = 1;
      } else {
        cnt++;
      }
    }
    cntArr.add(cnt);
    
    answer = new int[cntArr.size()];
    int i = 0;
    for (int n : cntArr) {
      answer[i++] = n;
    }
    return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);

//    int[] progresses = new int[] {93, 30, 55};
//    int[] speeds = new int[] {1, 30, 5};

     int[] progresses = new int[] {95, 90, 99, 99, 80, 99};
     int[] speeds = new int[] {1, 1, 1, 1, 1, 1};
    for (int i : T.solution(progresses, speeds)) {
      System.out.print(i + " ");
    }
  }
}
