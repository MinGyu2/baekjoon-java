package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P25304 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int sum = 0;
        for(int i=0;i<n;i++){
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(
                (s) -> Integer.parseInt(s)
            ).toArray();
            sum += arr[0]*arr[1];
        }
        if(sum == x){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
