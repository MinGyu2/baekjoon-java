package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(a,b)-> {
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        int temp = Integer.MAX_VALUE;
        int cnt = 0;
        for(int[] a:arr){
            if(temp >= a[1]){
                cnt ++;
                temp = a[0];
            }
        }
        System.out.println(cnt);
    }
}
