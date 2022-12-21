package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1520 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] a = new int[m][n];
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // int m = 4;
        // int n = 5;
        // int[][] a = {{50,45,37,32,30},{35,50,40,20,25},{30,30,25,17,28},{27,24,22,15,10}};

        int i = 1;
        int j = 1;
        int endI = m;
        int endJ = n; 
        int[][] arr = new int[m+2][n+2];
        int[][] dp = new int[m+2][n+2];
        // 입력 배열 초기화
        for(int y = 0;y<m+2;y++){
            for(int x = 0;x<n+2;x++){
                if(y == 0 || x == 0 || y == m+1 || x == n+1){
                    arr[y][x] = Integer.MAX_VALUE;
                }else{
                    arr[y][x] = a[y-1][x-1];
                }
            }
        }
        // dp 초기화
        for(int y = 0;y<m+2;y++){
            for(int x = 0;x<n+2;x++){
                if(y == 0 || x == 0 || y == m+1 || x == n+1){
                }else{
                    dp[y][x] = -1;
                }
            }
        }
        recursion(i, j, endI, endJ, arr, dp);


        // for(int[] ar:arr){
        //     System.out.println(Arrays.toString(ar));
        // }
        // System.out.println();
        // for(int[] ar:dp){
        //     System.out.println(Arrays.toString(ar));
        // }
        // System.out.println();
        System.out.println(dp[i][j]);
    }
    static void recursion(int i, int j, int endI, int endJ, int[][] arr, int[][] dp){
        if(i == endI && j == endJ){
            dp[i][j] = 1;
            return;
        }
        int v = arr[i][j];
        dp[i][j] = 0;
        if(v > arr[i][j+1]){
            if(dp[i][j+1] < 0){
                recursion(i, j+1, endI, endJ, arr, dp);
            }
            dp[i][j] += dp[i][j+1];
        }
        if(v > arr[i][j-1]){
            if(dp[i][j-1] == -1){
                recursion(i, j-1, endI, endJ, arr, dp);
            }
            dp[i][j] += dp[i][j-1];
        }
        if(v > arr[i+1][j]){
            if(dp[i+1][j] == -1){
                recursion(i+1, j, endI, endJ, arr, dp);
            }
            dp[i][j] += dp[i+1][j];
        }
        if(v > arr[i-1][j]){
            if(dp[i-1][j] == -1){
                recursion(i-1, j, endI, endJ, arr, dp);
            }
            dp[i][j] += dp[i-1][j];
        }
    }
}
