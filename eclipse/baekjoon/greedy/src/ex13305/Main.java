package ex13305;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public long solution(int n, long[] lengths, long[] prices) {
    long answer = 0;

    int i = 0;
    while (i < n - 1) {
      long minPri = prices[i];
      long lenSum = lengths[i];
      
      int j = i + 1;
      for (; j < n - 1; j++) {
        if (minPri < prices[j]) {
          lenSum += lengths[j];
        } else {
          break;
        }
      }
      i = j;
//      System.out.println(i + " " + j);
      answer += minPri * lenSum;
    }
    return answer;

  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    long[] lengths = new long[n - 1];
    long[] prices = new long[n];
    StringTokenizer stLen = new StringTokenizer(br.readLine());
    StringTokenizer stPri = new StringTokenizer(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      lengths[i] = Long.parseLong(stLen.nextToken());
      prices[i] = Long.parseLong(stPri.nextToken());
    }
    prices[n - 1] = Long.parseLong(stPri.nextToken());
    System.out.println(T.solution(n, lengths, prices));
  }
}

