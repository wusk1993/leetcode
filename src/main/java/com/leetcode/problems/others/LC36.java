package com.leetcode.problems.others;

import java.util.*;

import junit.framework.TestCase;

/**
 * @author wushaokang
 * @date 2021/9/17 23:44
 */
public class LC36 extends TestCase {
    public void test1() {
        char[][] board = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        print(board);
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            Arrays.fill(used, false);
            for (char c : row) {
                if ('.' == c) {
                    continue;
                }
                if (used[c - '1']) {
                    return false;
                }
                used[c - '1'] = true;
            }
        }

        for (int j = 0; j < 9; j++) {
            Arrays.fill(used, false);
            for (int k = 0; k < 9; k++) {
                char c = board[k][j];
                if ('.' == c) {
                    continue;
                }
                if (used[c - '1']) {
                    return false;
                }
                used[c - '1'] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int startRow = i * 3;
                int startCol = j * 3;
                Arrays.fill(used, false);
                for (int m = startRow; m < startRow + 3; m++) {
                    for (int n = startCol; n < startCol + 3; n++) {
                        char c = board[m][n];
                        if ('.' == c) {
                            continue;
                        }
                        if (used[c - '1']) {
                            return false;
                        }
                        used[c - '1'] = true;
                    }
                }
            }
        }
        return true;
    }

    public void print(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }


}