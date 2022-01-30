package inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;


/**
 * BFS : 섬의 최대 면적을 리턴
 * grid[][] 의 1은 땅, 0은 물
 * 섬의 최대 면접을 리턴, 섬이 없으면 0을 리턴
 */
public class MaxAreaIsland_bfs {

    public static void main(String[] args) {

        // 영역
        int[][] grid = {
                {0, 0, 1, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0}
        };

        MaxAreaIsland_bfs bfs = new MaxAreaIsland_bfs();
        System.out.println("bfs = " + bfs.solve(grid));
    }

    // 방향 설정
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int rowLen, colLen;

    private int solve(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        rowLen = grid.length;       // 5
        colLen = grid[0].length;     // 5

        int max = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    int area = bfs(grid, i, j);
                    max = Math.max(max, area);
                }

            }
        }
        return max;
    }

    private int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        int result = 0;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            result++;
            for (int[] dir : dirs) {
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];
                if (x1 >= 0 && y1 >= 0 && x1 < rowLen && y1 < colLen && grid[x1][y1] == 1) {
                    grid[x1][y1] = -1;      // visited
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
        return result;
    }
}
