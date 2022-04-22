package ex1700;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public int solution(int holeCnt, int thingsLen, int[] things) {
    int answer = 0;
    boolean[] isPlugged = new boolean[101];
    int usingHoleCnt = 0;

    for (int i = 0; i < thingsLen; i++) {
      int thing = things[i];
      // 비어있는 콘센트에 꽂기
      if (usingHoleCnt < holeCnt) {
        if (!isPlugged[thing]) {
          isPlugged[thing] = true;
          usingHoleCnt++;
          continue;
        }
      }

      if (isPlugged[thing]) {
        continue;
      } else { // 현재 thing이 안꽂혀있는 경우
        // 사용중인 thing들이 나중에도 사용되는지 확인
        ArrayList<Integer> reuseArr = new ArrayList<>();
        for (int j = i + 1; j < thingsLen; j++) {
          if (isPlugged[things[j]] && !reuseArr.contains(things[j])) {
            reuseArr.add(things[j]);
          }
        }
        
        // 사용중인 thing들이 전부 나중에도 사용된다면 마지막에 사용되는 thing을 제거
        if (reuseArr.size() == holeCnt) {
          isPlugged[reuseArr.get(holeCnt - 1)] = false;
        } else { // 전부 사용되는 것이 아니라면 사용하지 않는 thing을 제거
          for (int th = 1; th <= 100; th++) {
            if (isPlugged[th] && !reuseArr.contains(th)) {
              isPlugged[th] = false;
            }
          }
        }
        isPlugged[thing] = true;
        answer++;
      }
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
    int[] things = new int[k];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      things[i] = Integer.parseInt(st.nextToken());
    }
    bw.write(T.solution(n, k, things) + "");
    bw.flush();
    bw.close();
  }
}
