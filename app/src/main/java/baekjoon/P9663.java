package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        // long start = System.currentTimeMillis();
        nQueen(board, n, 0, n);
        System.out.println(cnt);
        // System.out.println(System.currentTimeMillis()-start);
    }
    static void nQueen(final int[][] board,final int n,int depth, final int maxDepth){
        if(depth == maxDepth-1){
            // int cnt = 0;
            for(int i = 0; i< n;i++){
                if(board[depth][i] == 0) { cnt++; }
            }
            return;
        }
        for(int x = 0; x < n; x++){
            if(board[depth][x] == 0){
                for(int i=0;i<n-depth;i++){
                    if(x-i >= 0) {
                        board[depth+i][x-i] +=1;
                    }
                    board[depth+i][x] +=1;
                    if(x+i < n){
                        board[depth+i][x+i] +=1;
                    }
                }
                nQueen(board, n, depth+1, maxDepth);
                for(int i=0;i<n-depth;i++){
                    if(x-i >= 0) {
                        board[depth+i][x-i] -=1;
                    }
                    board[depth+i][x] -=1;
                    if(x+i < n){
                        board[depth+i][x+i] -=1;
                    }
                }
            }
        }
    }
}
