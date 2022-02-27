package programmers.lv2;

// 프로그래머스 - 스택/큐 - 프린터
//https://programmers.co.kr/learn/courses/30/lessons/42587

// priorities : 문서의 우선순위
// location : 내사 순서를 알고 싶은 문서의 위치

import java.util.*;

public class Solution_sq_02 {
    class Task {
        int location;
        int priority;

        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();

        // 순서에 맞게 큐 넣기
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }

        int now = 0;
        while (!queue.isEmpty()) {
            Task cur = queue.poll();
            boolean flag = false;

            for (Task t : queue) {
                if (t.priority > cur.priority) {
                    flag = true;            // 우선순위가 현재꺼보다 높으면 true
                }
            }

            // 우선순위가 높은 게 있다면
            if (flag) {
                queue.add(cur);
            } else {
                now++;
                if (cur.location == location) {
                    answer = now;
                    break;
                }
            }
        }
        return answer;

    }
}
