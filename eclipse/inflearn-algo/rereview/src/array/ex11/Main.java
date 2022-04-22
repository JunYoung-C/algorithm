package array.ex11;

import java.util.Scanner;

public class Main {

  public int solution(int n, int[][] map) {
    int answer = 1;
    int[] cnts = new int[n + 1];
    
    for (int me = 1; me <= n; me++) {
      boolean[] isMyFriend = new boolean[n + 1];
      
      for (int cla = 1; cla <= 5; cla++) {
         int myClass = map[me][cla];
         
         for (int you = 1; you <= n; you++) {
           if (me == you) {
             continue;
           }
           
           int yourClass = map[you][cla];
           if(myClass == yourClass) {
             isMyFriend[you] = true;
           }
         }
      }
      
      int cnt = 0;
      for (int i = 1; i <= n; i++) {
        if (isMyFriend[i]) {
          cnt++;
        }
      }
      cnts[me] = cnt;
    }
    
    int max = 0;
    for (int i = 1; i <= n; i++) {
      if (cnts[i] > max) {
        max = cnts[i];
        answer = i;
      }
    }
    

    return answer;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    
    int n = stdIn.nextInt();
    int[][] map = new int[n + 1][6];
    
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 5; j++) {
        map[i][j] = stdIn.nextInt();
      }
    }
    
    System.out.println(T.solution(n, map));
  }
}
