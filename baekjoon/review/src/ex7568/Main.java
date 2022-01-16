package ex7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Person {
  int weight;
  int height;

  public Person(int weight, int height) {
    super();
    this.weight = weight;
    this.height = height;
  }
}


public class Main {
  public int[] solution(int n, Person[] personArr) {
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      Person me = personArr[i];
      int rank = 1;
      
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        Person you = personArr[j];
        
        if (you.weight > me.weight && you.height > me.height) {
          rank++;
        }
      }
      answer[i] = rank;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main T = new Main();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    Person[] personArr = new Person[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      personArr[i] = new Person(weight, height);
    }


    for (int i : T.solution(n, personArr)) {
      bw.write(i + " ");
    }
    bw.flush();
    bw.close();
  }
}
