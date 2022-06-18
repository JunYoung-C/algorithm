package backjoon.graph.ex1516;

import java.io.*;
import java.util.*;

class Building implements Comparable<Building> {
    int index;
    int buildTime;

    public Building(int index, int buildTime) {
        this.index = index;
        this.buildTime = buildTime;
    }

    @Override
    public int compareTo(Building o) {
        return this.buildTime - o.buildTime;
    }
}

public class Main {
    public int[] solution(int buildingType, int[] inDegree, int[] buildTime, ArrayList<ArrayList<Integer>> graph) {
        int[] answer = new int[buildingType + 1];
        PriorityQueue<Building> pQ = new PriorityQueue<>();

        for (int i = 1; i <= buildingType; i++) {
            if (inDegree[i] == 0) {
                pQ.offer(new Building(i, buildTime[i]));
            }
        }

        while (!pQ.isEmpty()) {
            Building currentBuilding = pQ.poll();

            answer[currentBuilding.index] = currentBuilding.buildTime;

            for (int next : graph.get(currentBuilding.index)) {
                if (--inDegree[next] == 0) {
                    pQ.offer(new Building(next, currentBuilding.buildTime + buildTime[next]));
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int buildingType = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[buildingType + 1];
        int[] buildTime = new int[buildingType + 1];
        for (int i = 0; i <= buildingType; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= buildingType; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            while (prev != -1) {
                graph.get(prev).add(i);
                inDegree[i]++;
                prev = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        int[] result = T.solution(buildingType, inDegree, buildTime, graph);

        for (int i = 1; i <= buildingType; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
