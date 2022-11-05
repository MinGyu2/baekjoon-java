package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p1001 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        int[] arr = Arrays.stream(reader.readLine().split(" "))
            .mapToInt((i)->{
                return Integer.parseInt(i);
            }).toArray();
        System.out.println(arr[0]- arr[1]);

    }
}
