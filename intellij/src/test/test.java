package test;

import java.awt.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class test {
    static String getNumber(int k, int num) {
        StringBuilder sb = new StringBuilder();
        int n = num;
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        "111".split("0");
    }
}
