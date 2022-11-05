package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = -1;
        for(int i = 0;i < n/3+1;i++){
            if((n-3*i) % 5 == 0){
                sum = i+(n-3*i)/5;
                break;
            }
        }
        System.out.println(sum);
    }
}
