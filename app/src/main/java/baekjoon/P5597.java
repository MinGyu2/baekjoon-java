package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5597 {
    public static void main(String[] args) throws IOException{
        int[] st = new int[31];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i<29; i++){
            st[Integer.parseInt(reader.readLine())] = 1;
        }
        for(int i = 1; i<31; i++){
            if(st[i] == 0){
                System.out.println(i);
            }
        }
    }
}
