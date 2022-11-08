package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1676 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // BigInteger mulI = new BigInteger("1");
        // // int cnt = 0;
        // while(n > 0){
        //     mulI = mulI.multiply(BigInteger.valueOf(n));
        //     n--;
        //     // while(mulI.mod(BigInteger.TEN).compareTo(BigInteger.ZERO) == 0){
        //     //     mulI = mulI.divide(BigInteger.TEN);
        //     //     cnt++;
        //     // }
        // }
        // System.out.println(mulI);
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(n > 0){
            cnt += n/5;
            n /=5;
        }
        System.out.println(cnt);
    }
}
