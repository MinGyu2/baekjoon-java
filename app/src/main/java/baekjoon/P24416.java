package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24416 {
    static int cnt = 0;
    static int cnt2 = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // System.out.println(fib(n));
        // System.out.println(cnt);
        System.out.print(fibonacci(n)+" "+cnt2);
    }
    static int fib(int n){
        if(n == 1 || n == 2){
            cnt++;
            return 1;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }
    static int fibonacci(int n){
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 1;
        for(int i = 3; i<n+1;i++){
            cnt2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
