package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] m = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();

        st = new StringTokenizer(br.readLine());
        int[] c = new int[n];
        int sumC = 0;
        for(int i = 0;i<n;i++){
            c[i] = Integer.parseInt(st.nextToken());
            sumC += c[i];
        }

        // dp
        int[] dp = new int[sumC + 1];
        for(int x = 0;x<n;x++){
            for(int i = sumC; i >= c[x];i--){
                dp[i] = Math.max(m[x] + dp[i-c[x]], dp[i]);
            }
        }
        // M 보다 큰 값을 가지는 맨 처음 인덱스 찾기
        for(int i = 0;i < sumC+1;i++){
            if(dp[i] >= M){
                System.out.println(i);
                break;
            }
        }
    }
}
