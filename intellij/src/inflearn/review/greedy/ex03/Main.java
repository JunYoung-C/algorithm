package inflearn.review.greedy.ex03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person> {
    char status;
    int time;

    public Person(char status, int time) {
        this.status = status;
        this.time = time;
    }

    @Override
    public int compareTo(Person o) {
        if (this.time == o.time) {
            return this.status - o.status;
        }
        return this.time - o.time;
    }
}
public class Main {
    public int solution(int n, ArrayList<Person> people) {
        int answer = 0;
        Collections.sort(people);
        int cnt = 0;
        for (Person p : people) {
            if (p.status == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int st = stdIn.nextInt();
            int et = stdIn.nextInt();
            people.add(new Person('s', st));
            people.add(new Person('e', et));
        }
        System.out.println(T.solution(n, people));
    }
}
