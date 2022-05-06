package template.tree.segment;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberCount = Integer.parseInt(st.nextToken());
        int changeCount = Integer.parseInt(st.nextToken());
        int sumCount = Integer.parseInt(st.nextToken());

        long[] tree = {};
        int depth = 0;
        for (; depth < 64; depth++) {
            if (Math.pow(2, depth) >= numberCount) {
                break;
            }
        }

        int treeSize = (int) Math.pow(2, depth) * 2;
        tree = new long[treeSize];

        int index = treeSize / 2;
        for (int i = 0; i < numberCount; i++) {
            tree[index++] = Long.parseLong(br.readLine());
        }

        for (int i = (int) Math.pow(2, depth) - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < changeCount + sumCount; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());// 1이면 값 바꾸기, 2면 구간 합
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (oper == 1) {
                int targetIndex = (int) Math.pow(2, depth) - 1 + b;
                long dif = c - tree[targetIndex];
                while (targetIndex > 0) {
                    tree[targetIndex] += dif;
                    targetIndex /= 2;
                }
            } else if (oper == 2) {
                startIndex = (int) Math.pow(2, depth) - 1 + b;
                endIndex = (int) (Math.pow(2, depth) - 1 + c);
                long sum = 0;

                while (startIndex <= endIndex) {
                    if (startIndex % 2 == 1) {
                        sum += tree[startIndex];
                    }

                    if (endIndex % 2 == 0) {
                        sum += tree[endIndex];
                    }

                    startIndex = (startIndex + 1) / 2;
                    endIndex = (endIndex - 1) / 2;
                }

                bw.write(sum + "\n");

            }
        }

        bw.flush();
        bw.close();
    }

}
