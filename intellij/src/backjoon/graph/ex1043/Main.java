package backjoon.graph.ex1043;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public void unite(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            parent[fb] = fa;
        }
    }

    public int solution(int peopleCount, int partyCount, ArrayList<ArrayList<Integer>> partyList) {
        int answer = 0;

        for (ArrayList<Integer> party : partyList) {
            for (int i = 1; i < party.size(); i++) {
                unite(party.get(0), party.get(i));
            }
        }

        for (ArrayList<Integer> party : partyList) {
            if (find(party.get(0)) != find(0)) {
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

        int peopleCount = Integer.parseInt(st.nextToken());
        int partyCount = Integer.parseInt(st.nextToken());

        parent = new int[peopleCount + 1]; // 0은 지민
        for (int i = 1; i <= peopleCount; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int friendCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < friendCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            T.unite(0, person);
        }

        ArrayList<ArrayList<Integer>> partyList = new ArrayList<>();
        for (int i = 0; i < partyCount; i++) {
            partyList.add(new ArrayList<>());
        }
        for (int i = 0; i < partyCount; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                partyList.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        br.close();
        bw.write(T.solution(peopleCount, partyCount, partyList) + "");
        bw.flush();
        bw.close();
    }
}
