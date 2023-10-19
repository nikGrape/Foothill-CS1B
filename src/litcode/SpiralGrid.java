package litcode;

public class SpiralGrid {
    private enum Directions {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    int[][] getSpiralGrid(int n) {
        int[][] result = new int[n][n];
        int x = 0;
        int y = 0;
        Directions direction = Directions.RIGHT;

        for (int i = 1; i <= Math.pow(n, 2); i++) {
            result[y][x] = i;

            switch (direction) {
                case RIGHT -> {
                    x += 1;
                    if (x == n - 1 - y) direction = Directions.DOWN;
                }
                case DOWN -> {
                    y += 1;
                    if (y == x) direction = Directions.LEFT;
                }
                case LEFT -> {
                    x -= 1;
                    if (x == n - 1 - y) direction = Directions.UP;
                }
                case UP -> {
                    y -= 1;
                    if (y == x + 1) direction = Directions.RIGHT;
                }
            }
        }

        return result;
    }
}
