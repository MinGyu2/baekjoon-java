package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9020 {
    public static void main(String[] args) throws IOException{
        int[] primes = new int[10001];
        primes[0] = 1;
        primes[1] = 1;
        for(int i = 2; i<10001;i++){
            if(primes[i] == 1) {continue;}
            for(int j = i+i; j< 10001; j+=i){
                primes[j] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            for(int l = n/2; l > 1; l--){
                if(primes[l] == 0 && primes[n-l] == 0){
                    sb.append(l+" "+(n-l));
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
