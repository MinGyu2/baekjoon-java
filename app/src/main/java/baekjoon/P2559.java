package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] accSum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i<n+1;i++){
            accSum[i] = accSum[i-1]+Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 1;i<n-k+2;i++){
            temp = accSum[i+k-1]-accSum[i-1];
            if(temp > max) { max = temp; }
        }
        System.out.println(max);
    }
}
