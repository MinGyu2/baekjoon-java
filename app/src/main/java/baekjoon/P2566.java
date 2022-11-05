package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2566 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        for(int i = 0; i < 9; i++){
            arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        }
        int[] arr2 = Arrays.stream(arr).flatMapToInt((a)->Arrays.stream(a)).toArray();
        int max = 0;
        int maxIndex = 0;
        for(int i=0;i<81;i++){
            if(arr2[i]>max){
                max = arr2[i];
                maxIndex = i;
            }
        }
        System.out.println(arr2[maxIndex]);
        System.out.println((maxIndex/9 + 1) + " "+ (maxIndex%9 + 1));
    }
}
