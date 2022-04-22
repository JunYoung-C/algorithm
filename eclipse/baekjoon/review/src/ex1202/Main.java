package ex1202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Gem implements Comparable<Gem>{
  int m;
  int v;

  public Gem(int m, int v) {
    super();
    this.m = m;
    this.v = v;
  }

  @Override
  public int compareTo(Gem o) {
    return this.m - o.m;
  }

}


public class Main {
  public long solution(int gemCnt, int bagCnt, ArrayList<Gem> gems, int[] bags) {
    long answer = 0;
    PriorityQueue<Integer> valuePq = new PriorityQueue<>(Collections.reverseOrder()); // 가격에 대한 우선순위 큐
    Arrays.sort(bags); // 오름차순 정렬
    Collections.sort(gems); // 무게를 기준으로 오름차순 정렬
    
    int gemsIdx = 0;
    for (int bag : bags) {
      // 가방에 들어갈 수 있는 무게의 보석까지 우선순위큐에 삽입
      for (; gemsIdx < gemCnt; gemsIdx++) {
        int gemM = gems.get(gemsIdx).m;
        int gemV = gems.get(gemsIdx).v;
        
        if (gemM <= bag) {
          valuePq.offer(gemV);
        } else {
          break;
        }
      }
      
      int v = 0;
      if (!valuePq.isEmpty()) {
        v = valuePq.poll();
      }
      
      answer += (int)v;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    ArrayList<Gem> gems = new ArrayList<>();
    int[] bags = new int[k];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      gems.add(new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    for (int i = 0; i < k; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }
    
    bw.write(T.solution(n, k, gems, bags) + "");
    bw.flush();
    bw.close();
  }
}
