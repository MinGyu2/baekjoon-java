package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4938 {
    public static void main(String[] args) throws IOException{
        int[] primes = new int[123456*2+1];
        primes[0] = 1;
        primes[1] = 1;
        for(int i = 2; i < 123456*2+1; i++){
            if(primes[i] != 0) { continue; }
            for(int j = i+i; j < 123456*2+1; j +=i){
                primes[j] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while((n = Integer.parseInt(br.readLine()))!= 0){
            int cnt = 0;
            for(int i = n+1; i < 2*n+1; i++){
                if(primes[i] == 0){
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
