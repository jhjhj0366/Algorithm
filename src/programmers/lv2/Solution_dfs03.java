package programmers.lv2;

// 프로그래머스 - BFS/DFS - 여행경로
// https://programmers.co.kr/learn/courses/30/lessons/43164
// 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
// 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
// 주어진 공항 수는 3개 이상 10,000개 이하

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_dfs03 {
    boolean[] visited;
    ArrayList<String> arrayList;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        arrayList = new ArrayList<>();
        // ticket 정렬
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(arrayList);
        String[] answer = arrayList.get(0).split(",");
        return answer;
    }

    public void dfs(String present, String end, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            arrayList.add(end);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && present.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], end + "," + tickets[i][1], tickets, cnt + 1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Solution_dfs03 sol = new Solution_dfs03();
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        // ["ICN", "JFK", "HND", "IAD"]
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        System.out.println("sol.solution() = " + Arrays.toString(sol.solution(tickets)));

    }
}
