package inflearn.review.greedy.ex01;

import java.util.Arrays;
import java.util.Scanner;

class Person implements Comparable<Person> {
    int h;
    int w;

    public Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person o) {
        if (this.h == o.h) {
            return o.w - this.w;
        }
        return o.h - this.h;
    }
}

public class Main {
    public int solution(int n, Person[] people) {
        int answer = 0;
        Arrays.sort(people);
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            if (people[i].w > maxWeight) {
                answer++;
                maxWeight = people[i].w;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            int h = stdIn.nextInt();
            int w = stdIn.nextInt();
            people[i] = new Person(h, w);
        }
        System.out.println(T.solution(n, people));
    }
}
