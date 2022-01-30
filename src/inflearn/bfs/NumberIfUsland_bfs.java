package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;


/**
 * BFS : 섬의 개수 구하기
 * grid[][] 의 1은 땅, 0은 물
 * 섬의 개수를 리턴
 */
public class NumberIfUsland_bfs {
    public static void main(String[] args) {

        // 영역
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberIfUsland_bfs bfs = new NumberIfUsland_bfs();
        System.out.println("bfs = " + bfs.solve(grid));
    }

    // 방향 설정
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    int m, n;

    private int solve(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;        // 4
        n = grid[0].length;     // 5
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y) {
//        grid[x][y] = 'X';   // visited/
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int x1 = cur[0] + dir[0];   // 0+x;
                int y1 = cur[1] + dir[1];   // 0+y;

                if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == '1') {
                    grid[x1][y1] = 'X';
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
    }
}
