package programmers.lv2;

// 프로그래머스 - 힙 - 스코빌 지수

// https://programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;

public class Solution_heap01 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.peek() < K) {
            if (pq.size() <=1){
                return -1;
            }
            int sum = pq.poll() + (pq.poll() * 2);
            pq.add(sum);
            answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_heap01 sol = new Solution_heap01();
//        int[] scoville = {1, 2, 3, 9, 10, 12};
        int[] scoville = {1, 2};
        int K = 7;
        System.out.println(sol.solution(scoville, K));

    }

}
