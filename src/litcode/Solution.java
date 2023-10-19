package litcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {


    public static void main(String[] args) {
//        SpiralGrid spiral = new SpiralGrid();
//        int[][] res = spiral.getSpiralGrid(5);
//        int[] a = new int[]{1, 2, 3};

        Sudoku sudoku = new Sudoku();
        int[][] grid = new int[][]{
                {1, 3, 2,  5, 4, 6,  9, 8, 7},
                {4, 6, 5,  8, 7, 9,  3, 2, 1},
                {7, 9, 8,  2, 1, 3,  6, 5, 4},

                {9, 2, 1,  4, 3, 5,  8, 7, 6},
                {3, 5, 4,  7, 6, 8,  2, 1, 9},
                {6, 8, 7,  1, 9, 2,  5, 4, 3},

                {5, 7, 6,  9, 8, 1,  4, 3, 2},
                {2, 4, 3,  6, 5, 7,  1, 9, 8},
                {8, 1, 9,  3, 2, 4,  7, 6, 5}
        };

        System.out.println(sudoku.validate(grid));

        Stream
                .iterate(0, i -> i + 1)
                .limit(grid.length)
                .map(i -> Arrays
                        .stream(grid)
                        .map(v -> v[i])
                        .toList())
                .forEach(System.out::println);
    }


}
