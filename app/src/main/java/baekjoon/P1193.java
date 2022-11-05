package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        // 1. find n
        int n = 0;
        while(true){
            if(2*x <= n*(n+1)){
                break;
            }
            n++;
        }
        // 2. find 분자, 분모
        int numerator = x - (n-1) * n / 2;
        int denominator = n+1-numerator;
        if(n%2 == 1){
            System.out.println(denominator+"/"+numerator);
        }else{
            System.out.println(numerator+"/"+denominator);
        }
    }
}
