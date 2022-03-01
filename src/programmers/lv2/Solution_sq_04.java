package programmers.lv2;


// 프로그래머스 - 스택/큐 - 주식 가격
// https://programmers.co.kr/learn/courses/30/lessons/42584
// 초 단위로 기록된 주식가격이 담긴 배열 prices
// 가격이 떨어지지 않은 기간은 몇 초인지를 return

public class Solution_sq_04 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int period = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    period++;
                } else {
                    period++;
                    break;
                }
            }
            answer[i] = period;
        }
        return answer;
    }
}
