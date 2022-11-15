package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11054 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        int[] f = new int[n];
        int[] fcnt = new int[n];
        int[] b = new int[n];
        int[] bcnt = new int[n];
        for(int i = 0; i<n;i++){
            f[i] = Integer.MAX_VALUE;
            b[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i<n;i++){
            for(int k = 0; k<n;k++){
                if(f[k] >= arr[i]){
                    f[k] = arr[i];
                    fcnt[i] = k+1;
                    // isIn = true;
                    break;
                }
            }
            for(int k = 0; k<n;k++){
                if(b[n-1-k] >= arr[n-1-i]){
                    b[n-1-k] = arr[n-1-i];
                    bcnt[n-1-i] = k+1;
                    // isIn = true;
                    break;
                }
            }
        }
        // find max
        int max = 0,temp;
        for(int i = 0; i<n;i++){
            temp = fcnt[i] + bcnt[i] - 1;
            if(temp > max){
                max = temp;
            }
        }
        System.out.println(max);
    }
}