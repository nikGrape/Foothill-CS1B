package litcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sudoku {

    public boolean validate(int[][] grid) {
        return validateRowsColumns(grid) && validateBlock(grid);
    }

    private boolean validateRowsColumns(int[][] grid) {
        return Arrays
                .stream(grid)
                .parallel()
                .allMatch(row-> Arrays
                        .stream(row)
                        .distinct()
                        .count() == 9)
                &&
                Stream
                        .iterate(0, i -> i + 1)
                        .limit(grid.length)
                        .allMatch(i -> Arrays
                            .stream(grid)
                            .map(v -> v[i])
                            .distinct()
                            .count() == 9);
    }

    private boolean validateBlock(int[][] grid) {
        boolean[] checker = new boolean[10];

        for (int block = 0; block < 9; block += 1) {
            Arrays.fill(checker, false);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int n = grid[i + (block / 3) * 3][j + (block % 3) * 3];
                    if (n < 1 || n > 9 || checker[n]) return false;
                    checker[n] = true;
                }
            }
        }

        return true;
    }

}
