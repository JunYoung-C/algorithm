package inflearn.review.dfsbfs.ex14;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static ArrayList<Point> pizzaHomes = new ArrayList<>();
    static ArrayList<Point> homes = new ArrayList<>();
    Point[] selectedPizzaHomes;
    boolean[] isSelectedPizzaHomeIdx;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int limitPizzaHomeCnt, int[][] map) {
        selectedPizzaHomes = new Point[limitPizzaHomeCnt];
        isSelectedPizzaHomeIdx = new boolean[pizzaHomes.size()];

        dfs(0, -1, n, limitPizzaHomeCnt, map);
        return answer;
    }

    void dfs(int L, int start, int n, int limitPizzaHomeCnt, int[][] map) {
        if (L >= limitPizzaHomeCnt) {
            int cityMinLen = 0;
            for (Point home : homes) {
                // 가장 가까운 피자집을 찾고 거리를 구하기
                cityMinLen += calculateMinLen(home);
            }


            answer = Math.min(answer, cityMinLen);
        } else {
            for (int i = start + 1, len = pizzaHomes.size(); i < len; i++) {
                if (!isSelectedPizzaHomeIdx[i]) {
                    isSelectedPizzaHomeIdx[i] = true;
                    selectedPizzaHomes[L] = pizzaHomes.get(i);
                    dfs(L + 1, i, n, limitPizzaHomeCnt, map);
                    isSelectedPizzaHomeIdx[i] = false;
                }
//                selectedPizzaHomes[L] = pizzaHomes.get(i);
//                dfs(L + 1, i, n, limitPizzaHomeCnt, map);
            }
        }
    }

    int calculateMinLen(Point home) {
        int minLen = Integer.MAX_VALUE;

        for (Point pizzaHome : selectedPizzaHomes) {
            int tmpLen = Math.abs(home.x - pizzaHome.x) + Math.abs(home.y - pizzaHome.y);
            minLen = Math.min(minLen, tmpLen);
        }

        return minLen;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int limitPizzaHomeCnt = stdIn.nextInt();
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = stdIn.nextInt();
                if (map[i][j] == 1) {
                    homes.add(new Point(j, i));
                } else if (map[i][j] == 2) {
                    pizzaHomes.add(new Point(j, i));
                }
            }
        }

        System.out.println(T.solution(n, limitPizzaHomeCnt, map));
    }
}
