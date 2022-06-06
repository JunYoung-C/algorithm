package backjoon.datastructure.ex12891;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public int solution(int len, String dna, HashMap<Character, Integer> requiredCharMap, int passwordLen) {
        int answer = 0;
        int lt = 0, rt = 0;
        HashMap<Character, Integer> currentCharMap = new HashMap<>();
        for (; rt < len; rt++) {
            currentCharMap.put(dna.charAt(rt), currentCharMap.getOrDefault(dna.charAt(rt), 0) + 1);

            if (rt - lt + 1 > passwordLen) {
                currentCharMap.put(dna.charAt(lt), currentCharMap.get(dna.charAt(lt)) - 1);
                lt++;
            }

            if (rt - lt + 1 == passwordLen && isPossiblePassword(requiredCharMap, currentCharMap)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPossiblePassword(HashMap<Character, Integer> requiredCharMap, HashMap<Character, Integer> currentCharMap) {
        boolean isSatisfied = true;
        ArrayList<Character> requiredChars = new ArrayList<>(requiredCharMap.keySet());
        for (char requiredChar : requiredChars) {
            if (requiredCharMap.get(requiredChar) > currentCharMap.getOrDefault(requiredChar, 0)) {
                isSatisfied = false;
            }
        }

        return isSatisfied;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int passwordLen = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        HashMap<Character, Integer> requiredCharMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        requiredCharMap.put('A', Integer.parseInt(st.nextToken()));
        requiredCharMap.put('C', Integer.parseInt(st.nextToken()));
        requiredCharMap.put('G', Integer.parseInt(st.nextToken()));
        requiredCharMap.put('T', Integer.parseInt(st.nextToken()));

        bw.write(T.solution(len, dna, requiredCharMap, passwordLen) + "");
        bw.flush();
        bw.close();
    }
}
