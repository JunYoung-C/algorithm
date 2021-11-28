package ex1026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public int solution(int n, int[] arrA, int[] arrB) {
    int answer = 0;
    boolean[] visited = new boolean[n];
    Arrays.sort(arrA);
    for (int i = 0; i < n; i++) {
      int idx = 0;
      for (int j = 0; j < n; j++) {
        if (arrB[i] < arrB[j]) idx++;
      }
//      System.out.print(idx + " ");
      
      while (visited[idx]) {
        idx++;
      }
      
      answer += arrA[idx] * arrB[i];
      visited[idx] = true;
//      System.out.print(idx + " ");
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arrA = new int[n];
    int[] arrB = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arrA[i] = Integer.parseInt(st.nextToken());
    }
    
    st = new StringTokenizer(br.readLine());;
    for (int i = 0; i < n; i++) {
      arrB[i] = Integer.parseInt(st.nextToken());
    }
    
    System.out.println(T.solution(n, arrA, arrB));
  }
}

