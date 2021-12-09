package ex1700;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public int solution(int holeCnt, int usingCnt, int[] sequence) {
    int answer = 0;
    boolean[] isUsed = new boolean[101];
    int usedCnt = 0;
    
    for (int i = 0; i < usingCnt; i++) {
      int now = sequence[i];
      if (isUsed[now])
        continue;
      
      // 1. 비어있는 콘센트에 전기 기구 꽂기
      if (usedCnt < holeCnt) {
        isUsed[now] = true;
        usedCnt++;
      } else {
        // 2.1 if 전기기구가 사용중, 그대로 스킵 - 먼저 처리해야 에러 안남
        // 2.2 else 사용중인 콘센트가 이후에도 사용되면 배열에 넣기
        ArrayList<Integer> using = new ArrayList<>();

        for (int j = i + 1; j < usingCnt; j++) {
          if (isUsed[sequence[j]] && !using.contains(sequence[j])) {
            using.add(sequence[j]);
            // System.out.print(sequence[j] + " ");
          }
        }
        // System.out.println();
        // 2.2.1 if 사용중인 콘센트가 이후에도 모두 사용, 맨 뒤의 요소를 뽑고 cnt++
        if (using.size() >= holeCnt) {
          isUsed[using.get(using.size() - 1)] = false;
        }
        // 2.2.2 else 이후에 사용하지 않는 콘센트를 뽑고 cnt++
        else {
          for (int j = 1; j < isUsed.length; j++) {
            if (isUsed[j] && !using.contains(j)) {
              isUsed[j] = false;
              break;
            }
          }
        }
        // 현재의 전기기구를 사용중으로 변환
        answer++;
        isUsed[now] = true;
      }

    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int holeCnt = Integer.parseInt(st.nextToken());
    int usingCnt = Integer.parseInt(st.nextToken());

    int[] sequence = new int[usingCnt];
    st = new StringTokenizer(br.readLine());
    int len = st.countTokens();
    for (int i = 0; i < len; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    bw.write(T.solution(holeCnt, usingCnt, sequence) + "");
    bw.flush();
    bw.close();
  }
}

