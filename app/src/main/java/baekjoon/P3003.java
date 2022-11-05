package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3003 {
    public static void main(String[] agrs) throws IOException{
        // 1 1 2 2 2 8
        int[] p = {1,1,2,2,2,8};

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        int[] sl = Arrays.stream(reader.readLine().split(" ")).mapToInt(
            (s) -> Integer.parseInt(s)
        ).toArray();

        for(int i=0; i< p.length; i++) {
            System.out.print((p[i] - sl[i] )+" ");
        }
        System.out.println();
    }
}
