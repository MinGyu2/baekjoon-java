package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] load = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        int[] city = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n-1;i++){
            min = Math.min(min, city[i]);
            sum += (long)min*(long)load[i];
        }
        System.out.println(sum);
    }
}
