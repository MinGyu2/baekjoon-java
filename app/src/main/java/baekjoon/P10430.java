package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10430 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(
            (s)-> Integer.parseInt(s)
        ).toArray();
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];
        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}
