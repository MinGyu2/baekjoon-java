package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4153 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;
        StringBuilder sb = new StringBuilder();
        while(true){
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).sorted().toArray();
            if(arr[0] + arr[1] + arr[2] == 0) { break; }
            sb.append((arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2])?"right":"wrong").append('\n');
        }
        System.out.println(sb);
    }
}
