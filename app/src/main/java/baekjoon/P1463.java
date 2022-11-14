package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i = 2; i < n+1;i++){
            arr[i] = Math.min(
                (i%3 == 0)?arr[i/3]:Integer.MAX_VALUE,
                Math.min((i%2 == 0)?arr[i/2]:Integer.MAX_VALUE, arr[i-1])
            )+1;
        }
        System.out.println(arr[n]);
    }
}
