package programmers.lv2.프린터;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Document> documentQue = new LinkedList<>();
        int index = 0;
        for (int p : priorities) {
            pQ.offer(p);
            documentQue.offer(new Document(index++, p));
        }

        while (!documentQue.isEmpty()) {
            Document now = documentQue.poll();

            if (pQ.peek() != now.priority) {
                documentQue.offer(now);
            } else {
                if (now.index == location) {
                    return answer;
                }
                pQ.poll();
                answer++;
            }

        }


        return answer;
    }
}

class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
