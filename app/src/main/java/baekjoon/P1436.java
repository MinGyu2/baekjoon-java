package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i = 666;
        while(true){
            if(isMovieTitle(i)) { cnt++; }
            if(cnt == n){break;}
            i++;
        }
        System.out.println(i);
    }
    static boolean isMovieTitle(int i){
        while(true){
            if(i < 666) return false;
            if(i%1000 == 666) return true;
            i /=10;
        }
    }
}
