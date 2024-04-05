package practice.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {

        int valueToCheckNeighbour = grid[sr][sc];
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(sr, sc));

        while(!q.isEmpty()) {
            Coord coord = q.poll();

            // already visited
            if (grid[coord.x][coord.y] == target) {
                continue;
            }

            //not equals to initial value
            if (grid[coord.x][coord.y] != valueToCheckNeighbour) {
                continue;
            }

            grid[coord.x][coord.y] = target;

            for (int i = 0; i < 4; i++) {
                int newx = coord.x + x[i];
                int newy = coord.y + y[i];
                if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length) {
                    continue;
                }
                q.add(new Coord(newx, newy));
            }
        }

        return grid;
    }

}
