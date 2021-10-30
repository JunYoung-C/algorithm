package dfsbfs.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public ArrayList<Integer> bfs(int cachesSize, int n, int[] arr) {
    ArrayList<Integer> caches = new ArrayList<>();
    for (int work : arr) {
      if (caches.contains(work)) {
        // caches에서 work를 찾아서 제거한 후 맨 앞에 추가
        caches.remove(caches.indexOf(work));
      } else if (caches.size() >= cachesSize) {
        caches.remove(cachesSize - 1);
      }
      caches.add(0, work);
    }
    return caches;
  }

  public static void main(String[] args) {
    Main T = new Main();
    Scanner stdIn = new Scanner(System.in);
    int cachesSize = stdIn.nextInt();
    int n = stdIn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = stdIn.nextInt();
    }
    for (int i :T.bfs(cachesSize, n, arr)) {
      System.out.print(i + " ");
    }
  }
}
