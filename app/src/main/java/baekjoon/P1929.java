package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 소수 찾기
        StringBuilder sb = new StringBuilder();
        int[] primes = new int[n+1];
        primes[0] = 1;
        primes[1] = 1;
        for(int i=2; i < n+1; i++){
            if(primes[i] != 0){ continue; }
            if(i >= m) {
                sb.append(i);
                sb.append('\n');
            }
            for(int j=i+i; j < n+1; j+=i){
                primes[j] = 1;
            }
        }

        //출력
        // for(int i=m; i<n+1;i++){
        //     if(primes[i] == 0) {
        //         sb.append(i);
        //         sb.append('\n');
        //     }
        // }
        System.out.println(sb);
    }
}
