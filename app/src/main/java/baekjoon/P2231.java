package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        final int len = s.length();
        int n = Integer.parseInt(s);

        int z = n - 9*len;
        z = (z < 0)? 0 : z;
        int answer = 0;
        int temp;
        for(int i = z; i < n;i++){
            temp = i + sumOnebyOne(i);
            if(temp == n){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
    static int sumOnebyOne(int i){
        int sum = 0;
        while(true){
            if(i == 0){ return sum; }
            sum += i%10;
            i /=10;
        }
    }
}
