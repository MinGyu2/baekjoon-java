package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        while(n-->0){
            arr[n] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i:arr){
            cnt += k/i;
            k = k - (k/i)*i;
        }
        System.out.println(cnt);
    }
}
