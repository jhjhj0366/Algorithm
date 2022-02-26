package programmers.lv2;

// 프로그래머스 - 스택/큐 - 기능개발
//https://programmers.co.kr/learn/courses/30/lessons/42586

// 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses
// 작업 개발 속도 speeds


import java.util.*;


public class Solution_sq_01 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            double temp = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(temp);

            if (!queue.isEmpty() && queue.peek() < date) {
                list.add(queue.size());
                queue.clear();
            }
            queue.offer(date);
        }

        list.add(queue.size());

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
