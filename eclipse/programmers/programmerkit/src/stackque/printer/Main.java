package stackque.printer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class WaitList{
  int priority;
  int location;
  
  public WaitList(int priority, int location) {
    super();
    this.priority = priority;
    this.location = location;
  }
}
class Solution {
  public int solution(int[] priorities, int location) {
      int answer = 1;
      int[] order = priorities.clone();
      int len = order.length;
      Queue<WaitList> WaitListQ = new LinkedList<>();
      
      Arrays.sort(order); // 오름차순이라 역순으로 해야함
      
      for (int i = 0; i < len; i++) {
        WaitListQ.add(new WaitList(priorities[i], i));
      }
      
      for (int i = len - 1; i >= 0; i--) {
        while (WaitListQ.peek().priority != order[i]) {
          WaitListQ.add(WaitListQ.poll());
        }
        
        if (WaitListQ.poll().location == location) {
          break;
        } else {
          answer++;
        }
      }
      return answer;
  }
}


public class Main {
  public static void main(String[] args) {
    Solution T = new Solution();
    Scanner stdIn = new Scanner(System.in);
    
//    int[] priorities = {2, 1, 3, 2};
//    int location = 2;
    
    int[] priorities = {1, 1, 9, 1, 1, 1};
    int location = 0;
    System.out.println(T.solution(priorities, location));
  }
}
