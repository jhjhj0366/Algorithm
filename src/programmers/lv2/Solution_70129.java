package programmers.lv2;

// 프로그래머스 - 위클리챌린지1 - 이진 변환 반복하기
// https://programmers.co.kr/learn/courses/30/lessons/70129

import java.util.Arrays;

public class Solution_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int cnt_zero = 0;

        while (!s.equals("1")) {
            int cnt_one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    cnt_one++;
                } else {
                    cnt_zero++;
                }
            }
            s = Integer.toBinaryString(cnt_one);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = cnt_zero;

        return answer;
    }

    public static void main(String[] args) {
        Solution_70129 sol = new Solution_70129();
        String s = "110010101001";
        System.out.println("sol = " + Arrays.toString(sol.solution(s)));
    }

}
