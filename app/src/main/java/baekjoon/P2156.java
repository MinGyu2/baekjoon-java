package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i = 1;i<n+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] g = new int[n+1];
        g[1] = arr[1];
        if(n > 1){
            g[2] = arr[2] + arr[1];
            for(int i = 3;i<n+1;i++){
                g[i] = Math.max(g[i-1], Math.max(arr[i]+g[i-2], arr[i]+arr[i-1]+g[i-3]));
            }
        }
        System.out.println(g[n]);
    }
}
