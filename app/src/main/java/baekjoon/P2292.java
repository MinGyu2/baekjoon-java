package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int z = Integer.parseInt(br.readLine());
        int n = 0;
        while(true){
            if(z <= 3*n*(n+1) + 1){
                break;
            }
            n++;
        }
        System.out.println(n+1);
    }
}
