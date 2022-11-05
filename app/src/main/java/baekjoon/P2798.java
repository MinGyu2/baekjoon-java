package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s) -> Integer.parseInt(s)).toArray();
        int sum = 0;
        int temp;
        for(int x = 0; x<n-2;x++){
            for(int y = x+1; y<n-1;y++){
                for(int z = y+1; z<n;z++){
                    temp = arr[x] + arr[y] +arr[z];
                    if(temp <= m && temp > sum){
                        sum = temp;
                    }
                }
            }   
        }
        System.out.println(sum);
    }
}
