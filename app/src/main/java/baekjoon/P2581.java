package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2581 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] primes = new int[n+1];
        primes[0] = 1;
        primes[1] = 1;
        for(int i=2; i < n+1; i++){
            if(primes[i] != 0){ continue; }
            for(int j=i+i; j < n+1; j+=i){
                primes[j] = 1;
            }
        }
        int sum = 0;
        int f = -1;
        for(int i=m;i<n+1;i++){
            if(primes[i] == 0){
                if(f == -1){ f = i; }
                sum += i;
            }
        }
        if(f == -1){
            System.out.println(-1);
        }else{
            System.out.println(sum);
            System.out.println(f);
        }
    }
}
