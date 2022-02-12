package inflearn;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        char c = stdIn.next().charAt(0);
        System.out.println((Math.min(c - 'A', 'Z' + 1 - c)));
    }
}
