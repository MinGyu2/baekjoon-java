package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10844 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][11];
        int s = 0;
        for(int i = 0;i<10;i++){
            arr[0][i] = 1;
        }
        s++;
        n = n-1;
        while(n-->0){
            for(int i = 0; i<10;i++){
                if(i == 0){
                    arr[s%2][i] = arr[(s+1)%2][i+1];
                }else{
                    arr[s%2][i] = (arr[(s+1)%2][i+1] + arr[(s+1)%2][i-1])%1000000000;
                }
            }
            s++;
        }
        arr[(s+1)%2][0] = 0;
        int sum = 0;
        for(int i:arr[(s+1)%2]){
            sum = (sum + i)%1000000000;
        }
        System.out.println(sum);
    }
}
