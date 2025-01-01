import java.util.*;

public class Main {

    /**
     *
     * Remember the old phone game of Snake? If not, let’s look at this first: Snake
     * The snake can move up, down, left or right in a 2-dimensional board of arbitrary size.
     * Let’s try to implement the base logic of this game.
     * Rules:
     * Every time moveSnake() is called, the snake moves up, down, left or right
     * The snake’s initial size is 3 and grows by 1 every 5 moves
     * The game ends when the snake hits itself
     * We can use the following as a starting point (pseudo-code)
     *
     *
     *
     *
     * interface SnakeGame {
     *     moveSnake(snakeDirection);
     *     isGameOver();
     * }
     *
     */

    static class Pair {
        int row, col;

        public Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Pair) {
                Pair other = (Pair) obj;
                return this.row == other.row && this.col == other.col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (""+this.row+"_"+this.col).hashCode();
        }

        @Override
        public String toString() {
            return ""+this.row+":"+this.col;
        }
    }

    enum SnakeDirection {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);


        int row, col;
        SnakeDirection(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    interface SnakeGame {
        boolean moveSnake(SnakeDirection dir);
        boolean isGameOver();
    }

    class Game implements SnakeGame {

        Queue<Pair> snakeCells;
        Set<Pair> occupiedSet;
        int rowSize, colSize;
        Pair snakeHead;
        SnakeDirection headDirection;
        int moveCounter;
        boolean isGameOver;

        public Game(int rowSize, int colSize) {
            this.snakeCells = new LinkedList<>();
            this.occupiedSet = new HashSet<>();
            Pair p1 = new Pair(0, 0), p2 = new Pair(0, 1), p3 = new Pair(0, 2);
            snakeCells.add(p1);
            snakeCells.add(p2);
            snakeCells.add(p3);
            occupiedSet.add(p1);
            occupiedSet.add(p2);
            occupiedSet.add(p3);
            this.rowSize = rowSize;
            this.colSize = colSize;
            this.snakeHead = p3;
            this.headDirection = SnakeDirection.RIGHT;
            this.moveCounter = 0;
            this.isGameOver = false;
        }

        @Override
        public boolean moveSnake(SnakeDirection dir) {
            if(this.isGameOver) {
                System.out.println("Sorry : Game is already ended");
                return false;
            }
            int currRow = snakeHead.row, currCol = snakeHead.col;
            int newRow = dir.row + currRow, newCol = currCol + dir.col;
            if(newRow < 0 || newRow == rowSize || newCol < 0 || newCol == colSize) {
                // Going out of grid;
                this.isGameOver = true;
                System.out.println("Moving out of Grid");
                return false;
            }
            this.moveCounter++;
            if((this.moveCounter%3) != 0) {
                Pair freedCell = snakeCells.poll();
                occupiedSet.remove(freedCell);
            }
            // Moving the snakeHead
            Pair newPoint = new Pair(newRow, newCol);
            if(occupiedSet.contains(newPoint)) {
                // Game over
                System.out.println("Moving to "+newPoint+" is prohibited. Cell already occupied");
                this.isGameOver = true;
                return false;
            }
            occupiedSet.add(newPoint);
            snakeCells.add(newPoint);
            snakeHead = newPoint;
            System.out.println("Moving to :"+newPoint+" New Len : "+this.snakeCells.size());
            this.headDirection = dir;
            return true;
        }

        @Override
        public boolean isGameOver() {
            return this.isGameOver;
        }
    }

    public void test() {
        Game snakeGame = new Game(10, 10);
        snakeGame.moveSnake(SnakeDirection.RIGHT);
        snakeGame.moveSnake(SnakeDirection.RIGHT);
        snakeGame.moveSnake(SnakeDirection.RIGHT);
        snakeGame.moveSnake(SnakeDirection.RIGHT);
        snakeGame.moveSnake(SnakeDirection.RIGHT);
        snakeGame.moveSnake(SnakeDirection.DOWN);
        snakeGame.moveSnake(SnakeDirection.LEFT);
        snakeGame.moveSnake(SnakeDirection.UP);
    }

    public static void main(String[] args) {
        new Main().test();
    }
}