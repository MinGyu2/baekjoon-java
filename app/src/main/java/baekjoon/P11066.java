package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11066 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        final int[][] dp = new int[500][500];
        final int[] arr = new int[10001];
        final int[] sumArr = new int[10001];
        final StringBuilder sb = new StringBuilder();
        while(t-->0){
            int len = Integer.parseInt(br.readLine()); // 장수
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 각 장마다의 파일 크기
            for(int i = 0;i<len;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // dp 초기화
            for(int i = 0;i<len;i++){
                for(int j = i;j<len;j++){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            // sum 합 초기화
            sumArr[0] = arr[0];
            for(int i = 1; i<len;i++){
                sumArr[i] = arr[i] + sumArr[i-1];
            }

            int s = 0;
            int e = len - 1;
            // System.out.println(recursion(s, e, arr, dp,sumArr));
            sb.append(recursion(s, e, arr, dp,sumArr)).append('\n');
        }
        System.out.print(sb);
        // int[] arr = {1, 21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32};
        // int[] arr = {40, 30, 30, 50};
        // int[] arr = {1, 2,3,4,5,6,7,8};
        // int[] arr = {21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32};
        
        // dp 초기화
        // int len = arr.length;
        // for(int i = 0;i<len;i++){
        //     for(int j = i;j<len;j++){
        //         dp[i][j] = Integer.MAX_VALUE;
        //     }
        // }
        
        // int[] sumArr = new int[len];
        // sum 합 초기화
        // sumArr[0] = arr[0];
        // for(int i = 1; i<len;i++){
        //     sumArr[i] = arr[i] + sumArr[i-1];
        // }

        // int s = 0;
        // int e = len-1;
        // System.out.println(recursion(s, e, arr, dp,sumArr));
    }
    static int recursion(int s, int e, final int[] arr, final int[][] dp, final int[] sumArr){
        if(s == e){
            dp[s][e] = 0;
            return 0;
        }
        int sum = sumArr[e] - ((s == 0)?0:sumArr[s-1]);
        for(int i = s;i<e;i++){
            int f = (dp[s][i] == Integer.MAX_VALUE)? recursion(s, i, arr, dp, sumArr):dp[s][i];
            int b = (dp[i+1][e] == Integer.MAX_VALUE)? recursion(i+1, e, arr, dp, sumArr):dp[i+1][e];
            dp[s][e] = Math.min(dp[s][e], sum+f+b);
        }
        return dp[s][e];
    }
}
