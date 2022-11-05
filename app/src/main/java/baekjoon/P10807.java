package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P10807 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        IntStream arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(
            (s) -> Integer.parseInt(s)
        );
        int v = Integer.parseInt(reader.readLine());
        System.out.println(arr.filter((i)-> i==v).count());
    }
}
