package backjoon.greedy.ex1541;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(String formula) {
        int answer = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        setLists(formula, numbers, operators);

        answer = numbers.get(0);
        boolean isAppliedBracket = false;
        int lt = 0;
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                if (isAppliedBracket) {
                    lt += numbers.get(i + 1);
                } else {
                    answer += numbers.get(i + 1);
                }
            } else {
                if (isAppliedBracket) {
                    answer -= lt;
                } else {
                    isAppliedBracket = true;
                }
                lt = numbers.get(i + 1);
            }
        }
        if (lt != 0) {
            answer -= lt;
        }

        return answer;
    }

    private void setLists(String formula, ArrayList<Integer> numbers, ArrayList<Character> operators) {
        int number = 0;
        for (int i = 0; i < formula.length(); i++) {
            char now = formula.charAt(i);
            if (Character.isDigit(now)) {
                number = number * 10 + (now - '0');
            } else {
                numbers.add(number);
                number = 0;
                operators.add(now);
            }
        }
        numbers.add(number);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        String formula = stdIn.nextLine();

        System.out.println(T.solution(formula));
    }
}