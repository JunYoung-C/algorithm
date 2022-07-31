package programmers.kakao.lv2.수식최대화;

import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> originNumbers = new ArrayList<>();
        ArrayList<Character> originOperations = new ArrayList<>();
        List<String> orders = List.of("+-*", "+*-", "-+*", "-*+", "*+-", "*-+");
        convertExpression(originNumbers, originOperations, expression);

        ArrayList<Long> numbers = new ArrayList(originNumbers);
        ArrayList<Character> operations = new ArrayList(originOperations);
        for (String order : orders) {
            numbers = new ArrayList(originNumbers);
            operations = new ArrayList(originOperations);
            int index = -1;
            for (char currentOper : order.toCharArray()) {
                while (true) {
                    index = operations.indexOf(currentOper);
                    if (index == -1) {
                        break;
                    }

                    long num = calculate(numbers.remove(index), numbers.remove(index),
                            operations.remove(index));
                    numbers.add(index, num);
                }
            }

            answer = Math.max(answer, Math.abs(numbers.get(0)));
        }

        for (long n : numbers) {
            System.out.print(n + " ");
        }

        for (char c : originOperations) {
            System.out.print(c + " ");
        }

        return answer;
    }

    private long calculate(long num1, long num2, char oper) {
        long result = 0;
        if (oper == '+') {
            result = num1 + num2;
        } else if (oper == '*') {
            result = num1 * num2;
        } else {
            result = num1 - num2;
        }
        return result;
    }

    private void convertExpression(ArrayList<Long> numbers, ArrayList<Character> operations, String expression) {
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(sb.toString()));
                operations.add(c);
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        numbers.add(Long.parseLong(sb.toString()));
    }
}