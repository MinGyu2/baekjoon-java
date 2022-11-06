package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        System.out.println(String.format("%.6f",Math.PI*r*r));
        System.out.println(String.format("%.6f",(double)r*r*2));
    }
}
