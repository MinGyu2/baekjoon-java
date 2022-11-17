package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] accSum = new int[n+1];
        int[] cnt = new int[m];
        st = new StringTokenizer(br.readLine());
        cnt[0]++;
        for(int i = 1;i<n+1;i++){
            accSum[i] = (accSum[i-1] + Integer.parseInt(st.nextToken()))%m;
            cnt[accSum[i]]++;
        }
        long sum = 0;
        for(int i:cnt){
            sum += iC2(i);
        }
        System.out.println(sum);
    }
    static long iC2(long i){
        return i*(i-1)/2;
    }
}
