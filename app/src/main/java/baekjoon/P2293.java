package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        while(n-->0){
            arr[n] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        // dp 초기화
        dp[0] = 1;
        for(int c :arr){
            for(int i = c;i<k+1;i++){
                dp[i] += dp[i-c];
            }
        };
        System.out.println(dp[k]);
    }
}
