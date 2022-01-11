package dp.ex1932;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, ArrayList<ArrayList<Integer>> triangle) {
    int answer = 0;
    ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      dp.add(new ArrayList<>());
    }
    dp.get(0).add(triangle.get(0).get(0));
    
    for (int L = 1; L < n; L++) {
      ArrayList<Integer> prevLayer = dp.get(L - 1);
      for (int i = 0; i < L + 1; i++) {
        int lt = 0;
        if (i - 1 >= 0) {
          lt = prevLayer.get(i - 1);
        }
        
        int rt = 0;
        if (i < prevLayer.size()) {
          rt = prevLayer.get(i);
        }
        
        int max = triangle.get(L).get(i) + Math.max(lt, rt);
        dp.get(L).add(max);
      }
    }

    for (int num : dp.get(n - 1)) {
      answer = Math.max(answer, num);
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      triangle.add(new ArrayList<>());
    }

    for (int L = 0; L < n; L++) {
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < L + 1; i++) {
        triangle.get(L).add(Integer.parseInt(st.nextToken()));
      }
    }

    bw.write(T.solution(n, triangle) + "");
    bw.flush();
    bw.close();
  }
}
