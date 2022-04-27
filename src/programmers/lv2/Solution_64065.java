package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 - 2019 카카오 개발자 인턴쉽 - 튜플
// https://programmers.co.kr/learn/courses/30/lessons/64065

public class Solution_64065 {
    public int[] solution(String s) {

        ArrayList<Integer> list = new ArrayList<>();
        s = s.substring(2, s.length() - 2).replace("},{", "/");
        String[] strArr = s.split("/");
        Arrays.sort(strArr, ((o1, o2) -> o1.length() - o2.length()));
        System.out.println(Arrays.toString(strArr));

        for (String str : strArr) {
            String[] tmp = str.split(",");

            for (int i = 0; i < tmp.length; i++) {
                int n = Integer.parseInt(tmp[i]);

                if (!list.contains(n)) {
                    list.add(n);
                }
            }
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {
        Solution_64065 sol = new Solution_64065();
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println("sol.solution(s) = " + Arrays.toString(sol.solution(s)));
    }

}
