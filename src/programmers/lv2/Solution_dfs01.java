package programmers.lv2;

// 깊이/너비 우선 탐색 (DFS/BFS) - 타겟 넘버
// https://programmers.co.kr/learn/courses/30/lessons/43165

public class Solution_dfs01 {

    int dfsTotal = 0;
    public int solution(int[] numbers, int target) {

        return dfs(0, 0, numbers, target);
    }

    public int dfs(int idx, int total, int[] numbers, int target) {

        if (idx == numbers.length) {
            if (total == target) {
                dfsTotal++;
            }
        } else {
            dfs(idx + 1, total + numbers[idx], numbers, target);
            dfs(idx + 1, total - numbers[idx], numbers, target);
        }
        return dfsTotal;

    }

}
