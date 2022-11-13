package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461 {
    public static void main(String[] args) throws IOException{
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for(int i =6;i<101;i++){
            arr[i] = arr[i-1] + arr[i-5];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }
}
