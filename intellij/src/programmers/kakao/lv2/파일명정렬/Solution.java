package programmers.kakao.lv2.파일명정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Word implements Comparable<Word> {
    String head;
    int number;
    String tail;
    String fileName;

    public Word() {
    }

    public Word(String head, int number, String tail, String fileName) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.fileName = fileName;
    }

    @Override
    public int compareTo(Word o) {
        if (this.head.equals(o.head)) {
            return this.number - o.number;
        }
        return this.head.compareTo(o.head);
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        ArrayList<Word> words = new ArrayList<>();
        for (String file : files) {
            words.add(getWord(file));
        }

        Collections.sort(words);
        int len = words.size();
        answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = words.get(i).fileName;
        }
        return answer;
    }

    private Word getWord(String file) {
        Word word = new Word();
        word.fileName = file;

        // head
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                word.head = file.substring(0, i).toLowerCase();
                file = file.substring(i);
                break;
            }
        }

        // number
        for (int i = 0; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i))) {
                word.number = Integer.parseInt(file.substring(0, i));
                word.tail = file.substring(i);
                break;
            }

            if (i == file.length() - 1) {
                word.number = Integer.parseInt(file);
            }
        }

        return word;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner stdIn = new Scanner(System.in);

//        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files = {"img12", "img1"};

        System.out.println(T.solution(files));
    }
}
