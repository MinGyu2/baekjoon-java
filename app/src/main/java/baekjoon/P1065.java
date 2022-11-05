package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int cnt = 0;
        for(int i=1;i<n+1;i++){
            cnt += hannum(i);
        }
        System.out.println(cnt);
    }
    static int hannum(int n){
        if(n < 100){
            return 1;
        }else if(n == 1000){
            return 0;
        }
        int a = n%10;
        int b = (n/10)%10;
        int c = (n/100)%10;
        if(a-b == b-c){
            return 1;
        }else{
            return 0;
        }
    }
}
