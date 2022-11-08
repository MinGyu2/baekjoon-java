package baekjoon;

import java.io.IOException;
import java.util.Arrays;

public class P2580 {
    static int readInt() throws IOException{
        int ch;//System.in.read();
        while((ch = System.in.read()) == ' ' || ch == '\n' || ch == '\r'){}
        return ch - '0';
    }
    public static void main(String[] args) throws IOException{
        boolean[][] row = new boolean[10][10]; // 수평
        boolean[][] col = new boolean[10][10]; // 수직
        boolean[][] square = new boolean[10][10]; // 3x3
        int[][] sudoku = new int[9][9];
        int temp;
        for(int j = 0;j<9;j++){
            for(int i = 0;i<9;i++){
                temp = readInt();
                sudoku[j][i] = temp;
                // true
                row[j][temp] = true;
                col[i][temp] = true;
                square[i/3 + j/3 * 3][temp] = true;
            }
        }
        sudoku(row, col, square, sudoku, 0);
        for(int[] a:sudoku){
            System.out.println(Arrays.toString(a).replaceAll("\\[|\\]|,", ""));
        }
    }
    
    static boolean sudoku(final boolean[][] row, final boolean[][] col, final boolean[][] square, final int[][] sudoku, int n){
        int i = n%9;
        int j = n/9;
        while(n < 81 && sudoku[j][i] != 0) {
            n++;
            i = n%9;
            j = n/9;
        }
        if(n == 81){
            return false; // 끝
        }
        for(int k = 1; k<10;k++){
            if(!row[j][k] && !col[i][k] && !square[i/3 + j/3 * 3][k]){
                row[j][k] = true;
                col[i][k] = true;
                square[i/3 + j/3 * 3][k] = true;
                sudoku[j][i] = k;
                if(!sudoku(row, col, square, sudoku, n+1)) { return false; }
                row[j][k] = false;
                col[i][k] = false;
                square[i/3 + j/3 * 3][k] = false;
                sudoku[j][i] = 0;
            }
        }
        return true; // 실패
    }
}
