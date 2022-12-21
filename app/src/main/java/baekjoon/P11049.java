package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[][] dp = new int[n][n];
        int s = 0;
        int e = n-1;

        // int[][] arr = {{5,3},{3,2},{2,6}};
        // int n = arr.length;
        // int[][] dp = new int[n][n];
        // int s = 0;
        // int e = n - 1;
        
        // arr 입력 받기
        StringTokenizer st;
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // dp 초기화
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        recursion(s, e, arr, dp);
        System.out.println(dp[s][e]);
    }
    static void recursion(int s, int e, int[][] arr, int[][] dp){
        if(s == e){
            dp[s][e] = 0;
            return;
        }
        for(int i = s;i<e;i++){
            if(dp[s][i] == Integer.MAX_VALUE){
                recursion(s, i, arr, dp);
            }
            int alpha = dp[s][i];
            if(dp[i+1][e] == Integer.MAX_VALUE){
                recursion(i+1, e, arr, dp);
            }
            int beta = dp[i+1][e];
            long c = (long)alpha + (long)beta + (long)arr[s][0]*arr[i][1]*arr[e][1];
            if(c < Integer.MAX_VALUE){
                dp[s][e] = Math.min(dp[s][e], (int)c);
            }
        }
    }
}
