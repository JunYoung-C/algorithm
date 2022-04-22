package ex1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Gem implements Comparable<Gem> {
  int m;
  int v;

  public Gem(int m, int v) {
    this.m = m;
    this.v = v;
  }

//  @Override
//  public int compareTo(Gem o) {
//    if (this.v == o.v)
//      return this.m - o.m;
//    return o.v - this.v;
//  }
  
  @Override
  public int compareTo(Gem o) {
    if (this.m == o.m)
      return o.v - this.v;
    return this.m - o.m;
  }
}


public class Main {
  // ³»°¡ Â§ ÄÚµå
//  public long solution(int n, ArrayList<Gem> gems, int k, ArrayList<Integer> bags) {
//    long answer = 0;
//    int cnt = 0;
//    Collections.sort(gems);
//    Collections.sort(bags);
//    int lt, rt, tmp;
//    for (Gem gem : gems) {
//      if (gem.m > bags.get(bags.size() - 1)) {
//        continue;
//      }
//
//      lt = 0;
//      rt = bags.size() - 1;
//      tmp = -1;
//      while (lt <= rt) {
//        int mid = (lt + rt) / 2;
//        if (gem.m <= bags.get(mid)) {
//          tmp = mid;
//          rt = mid - 1;
//        } else {
//          lt = mid + 1;
//        }
//      }
//
//      if (tmp != -1) {
//        cnt++;
//        answer += gem.v;
//        bags.remove(tmp);
//      }
//      
//      if (cnt == k) break;
//      
//    }
//    return answer;
//  }

  public long solution(int n, ArrayList<Gem> gems, int k, ArrayList<Integer> bags) {
    long answer = 0;
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    Collections.sort(gems);
    Collections.sort(bags);
    
    for (int i = 0, j = 0; i < k; i++) {
      for (; j < n; j++) {
        Gem gem = gems.get(j);
        if (gem.m > bags.get(i)) break;
        pQ.offer(gem.v);
      }
      
      if (!pQ.isEmpty()) {
        answer += pQ.poll();
      }
    }
    return answer;
    
  }
  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    ArrayList<Gem> gems = new ArrayList<>();
    ArrayList<Integer> bags = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      gems.add(new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    for (int i = 0; i < k; i++) {
      bags.add(Integer.parseInt(br.readLine()));
    }
    
//    n = 300000;
//    k = 300000;
//    for (int i = 0; i < n; i++) {
//      gems.add(new Gem(i, i));
//    }
//    for (int i = 0; i < k; i++) {
//      bags.add(i);
//    }
   
    System.out.println(T.solution(n, gems, k, bags));
  }
}

