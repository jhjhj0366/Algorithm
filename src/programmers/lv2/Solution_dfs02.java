package programmers.lv2;

// 프로그래머스 - BFS/DFS - 단어 변환
// https://programmers.co.kr/learn/courses/30/lessons/43163
public class Solution_dfs02 {

    static int answer = 0;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        // 최종 begin 과 target이 같으면 값 리턴
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j))
                    k++;
            }

            if (k == begin.length() - 1) { // 한글자 빼고 모두 같은 경우
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
