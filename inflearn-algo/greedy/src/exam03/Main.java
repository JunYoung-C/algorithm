package exam03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
  public int time;
  public char state;
  Time(int time, char state) {
    this.time = time;
    this.state = state;
  }
  @Override
  public int compareTo(Time o) {
    if (this.time == o.time) return this.state - o.state;
    else return this.time - o.time;
  }
}
public class Main {
public int solution(ArrayList<Time> arr) {
  int answer = Integer.MIN_VALUE;
  Collections.sort(arr);
  int cnt = 0;
  for (Time ob : arr) {
    if (ob.state == 's') cnt++;
    else cnt--;
    answer = Math.max(answer, cnt);
  }
  return answer;
}
//  public int solution(int n, int[] in, int[] out) {
//    int answer = 0;
//    int[] ch = new int[72];
//    for (int i = 0; i < n; i++) {
//      for (int s = in[i]; s < out[i]; s++) {
//        ch[s] +=1;
//      }
//    }
//    
//    answer = Arrays.stream(ch).max().getAsInt();
//    return answer;
//  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
//    int[] in = new int[n];
//    int[] out = new int[n];
//    for (int i = 0; i < n; i++) {
//      in[i] = stdIn.nextInt();
//      out[i] = stdIn.nextInt();
//    }
    
//    System.out.println(T.solution(n, in, out));
    ArrayList<Time> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int sT = stdIn.nextInt();
      int eT = stdIn.nextInt();
      arr.add(new Time(sT, 's'));
      arr.add(new Time(eT, 'e'));
    }
    System.out.println(T.solution(arr));
  }
}
