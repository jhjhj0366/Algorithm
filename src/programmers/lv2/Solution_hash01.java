package programmers.lv2;


// 프로그래머스 - 해쉬 - 위장
// https://programmers.co.kr/learn/courses/30/lessons/42578


// clothes의 각 행은 [의상의 이름, 의상의 종류]

import java.util.HashMap;

public class Solution_hash01 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            if (map.containsKey(key)) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Solution_hash01 sol = new Solution_hash01();
        String[][] clothes = {{"yellowhat", "headgear"}
                , {"bluesunglasses", "eyewear"}
                , {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }
}
