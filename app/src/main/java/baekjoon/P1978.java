package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        int max = Arrays.stream(arr).max().getAsInt();

        int[] primes = new int[max+1];
        primes[0] = 1;
        primes[1] = 1;
        for(int i=2; i < max+1; i++){
            if(primes[i] != 0){ continue; }
            for(int j=i+i; j < max+1; j+=i){
                primes[j] = 1;
            }
        }
        
        int cnt = 0;
        for(int k:arr){
            if(primes[k] == 0){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
