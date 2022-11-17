package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n+1][n+1];
        for(int j = 1;j<n+1;j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 1;i<n+1;i++){
                board[j][i] = Integer.parseInt(st.nextToken()) + board[j-1][i] + board[j][i-1] - board[j-1][i-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            sb.append(board[y2][x2] - board[y2][x1-1] - board[y1-1][x2] + board[y1-1][x1-1]).append('\n');
        }
        System.out.println(sb);
    }
}
