package programmers.lv2;

// https://programmers.co.kr/learn/courses/30/lessons/42883
// 프로그래머스 - 탐욕법 - 큰 수 만들기

public class Solution_42883 {
    public String solution(String number, int k) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_42883 sol = new Solution_42883();
        System.out.println("sol = " + sol.solution("4177252841", 4));
        System.out.println("4177252841".charAt(1) - '0');
    }
}
