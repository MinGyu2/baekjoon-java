package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2480 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(
            (s) -> Integer.parseInt(s)
        ).toArray();
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if(a == b && b == c) {
            System.out.println(10000 + a*1000);
        }else if(a == b){
            System.out.println(1000+a*100);
        }else if(b == c) {
            System.out.println(1000+b*100);
        }else if(c == a) {
            System.out.println(1000+a*100);
        }else {
            System.out.println(Arrays.stream(arr).max().getAsInt()*100);
        }
    }
}
