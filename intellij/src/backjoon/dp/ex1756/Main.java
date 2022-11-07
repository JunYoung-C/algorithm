package backjoon.dp.ex1756;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int solution(int depth, int pizzaCount, int[] ovenDiameter, int[] pizzaDiameters) {
        initOvenDiameter(depth, ovenDiameter);
        int lt = 0, rt = depth - 1;

        for (int i = 0; i < pizzaCount - 1; i++) {
            int index = getTargetIndex(pizzaDiameters[i], ovenDiameter, lt, rt);
            if (index == -1) {
                return 0;
            }
            lt = index + 1;
//            System.out.println(lt + "-");
        }

        int index = getTargetIndex(pizzaDiameters[pizzaCount - 1], ovenDiameter, lt, rt);
        if (index == -1) {
            return 0;
        } else {
            return rt - index + 1;
        }
    }

    private int getTargetIndex(int target, int[] arr, int lt, int rt) {
        if (lt > rt) {
            return -1;
        } else if (arr[lt] >= target) {
            return lt;
        }

        int index = -1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (arr[mid] < target) {
                lt = mid + 1;
            } else {
                index = mid;
                rt = mid - 1;
            }
        }

        return index;
    }

    private static void initOvenDiameter(int depth, int[] ovenDiameter) {
        for (int i = 0; i < depth - 1; i++) {
            if (ovenDiameter[i] < ovenDiameter[i + 1]) {
                ovenDiameter[i + 1] = ovenDiameter[i];
            }
        }

        Arrays.sort(ovenDiameter);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int depth = Integer.parseInt(st.nextToken());
        int pizzaCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] oven = new int[depth];
        for (int i = 0; i < depth; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] pizzas = new int[pizzaCount];
        for (int i = 0; i < pizzaCount; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(T.solution(depth, pizzaCount, oven, pizzas)+ "");
        bw.flush();
        bw.close();
    }
}
