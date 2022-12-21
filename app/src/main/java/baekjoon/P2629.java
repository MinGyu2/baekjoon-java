package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2629 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wArr = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            wArr[i] = Integer.parseInt(st.nextToken());
            sum += wArr[i];
        }

        int[] dp = new int[sum+1];
        // dp 완성하기
        for(int w:wArr){
            for(int i = sum;i > -1;i--){ // 내림차순
                dp[i] = Math.max((i-w >= 0)?w+dp[i-w]:0, dp[i]);
            }
        }

        // 비교할 무게 입력
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int v;
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            v = Integer.parseInt(st.nextToken());
            if(compare(v, dp)){
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }
    static boolean compare(int v, int[] dp){
        int maxW = dp.length -1;
        int temp, temp2;
        for(int i:dp){
            temp = v + i;
            if(temp > maxW){
                continue;
            }
            temp2 = dp[temp];
            if(temp == temp2){
                return true;
            }
        }
        return false;
    }
}
