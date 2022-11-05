package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[] arr = reader.readLine().toCharArray();
        int sum = 0;
        for(int i:arr){
            sum += i - 48;
        }
        System.out.println(sum);
    }
}
