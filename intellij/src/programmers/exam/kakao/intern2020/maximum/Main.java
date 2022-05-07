package programmers.exam.kakao.intern2020.maximum;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[] orders = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        initLists(expression, numbers, operators);

        for (String order : orders) {
            ArrayList<Long> cNumbers = new ArrayList<>(numbers);
            ArrayList<Character> cOperators = new ArrayList<>(operators);
            for (char operator : order.toCharArray()) {
                for (int i = 0; i < cOperators.size(); i++) {
                    if (cOperators.get(i) == operator) {
                        long result = calculate(cNumbers.get(i), cNumbers.get(i + 1), operator);
                        cNumbers.remove(i);
                        cNumbers.remove(i);
                        cOperators.remove(i);
                        cNumbers.add(i, result);
                        i--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNumbers.get(0)));
        }
        return answer;
    }

    private void initLists(String expression, ArrayList<Long> numbers, ArrayList<Character> operators) {
        String numStr = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                numStr += c;
            } else { // 연산자인 경우
                numbers.add(Long.parseLong(numStr));
                numStr = "";
                operators.add(c);
            }
        }
        numbers.add(Long.parseLong(numStr));
    }

    private long calculate(long num1, long num2, char operator) {
        long result = 0;
        switch (operator) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

        String expression = "100-200*300-500+20";

//        String expression = "50*6-3*2";

        System.out.println(T.solution(expression));
    }
}
