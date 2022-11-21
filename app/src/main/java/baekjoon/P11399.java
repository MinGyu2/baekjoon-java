package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        Arrays.sort(arr);
        int totalSum = 0;
        int sum = 0;
        for(int a:arr){
            sum += a;
            totalSum += sum;
        }
        System.out.println(totalSum);
    }
}
