package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2*n+1];
        for(int i = 1;i<n+1;i++){
            arr[i] = i;
        }

        int s = 1;
        int end = n;
        while(n != 1){
            s++;
            if(s == end) { break; }
            arr[++end] = arr[s++];
        }
        System.out.println(arr[s]);
    }
}
