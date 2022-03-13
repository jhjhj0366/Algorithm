package programmers.lv2;


// 프로그래머스 - 정렬 - H Index
// https://programmers.co.kr/learn/courses/30/lessons/42747?language=java

// 어떤 과학자가 발표한 논문 n편 중,
// h번 이상 인용된 논문이 h편 이상이고
// 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

// x = 배열의 값이 h회 이상인 요소의 수
// y = citations.length - 나머지 얘들이 x회 이하 인용

import java.util.Arrays;

public class Solution_sorting01 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Solution_sorting01 sol = new Solution_sorting01();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println("sol = " + sol.solution(citations));

    }
}
