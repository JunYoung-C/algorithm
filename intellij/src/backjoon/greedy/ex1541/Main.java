package backjoon.greedy.ex1541;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(String str) {
        int answer = 0;
        boolean isInBrace = false;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operations = new ArrayList<>();
        seperateNumberAndOperation(str, numbers, operations);

        // 괄호 안(이전에 -를 만났었다는 뜻)
          // 현재 부호가 +면 괄호 유지. -면 괄호 닫은 후 새로 괄호 열기
        // 괄호 밖(첫번째 수 or 이전에 +부호)
          // 현재 부호가 +면 그냥 더하기. -면 괄호 열기

        int tmp = 0;
        for (int i = 0; i < operations.size(); i++) {
            if (isInBrace) {
                tmp += numbers.get(i);

                if (operations.get(i) == '-') {
                    answer -= tmp;
                    tmp = 0;
                }
            } else {
                answer += numbers.get(i);
                if (operations.get(i) == '-') {
                    isInBrace = true;
                }
            }
        }

        if (isInBrace) {
            if (tmp == 0) {
                answer -= numbers.get(numbers.size() - 1);
            } else {
                tmp += numbers.get(numbers.size() - 1);
                answer -= tmp;
            }
        } else {
            answer += numbers.get(numbers.size() - 1);
        }



        return answer;
    }

    private void seperateNumberAndOperation(String str, ArrayList<Integer> numbers, ArrayList<Character> operations) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                numbers.add(Integer.parseInt(sb.toString()));
                operations.add(c);
                sb.setLength(0);
            }
        }
        numbers.add(Integer.parseInt(sb.toString()));
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        String str = stdIn.next();

        System.out.println(T.solution(str));
    }
}
