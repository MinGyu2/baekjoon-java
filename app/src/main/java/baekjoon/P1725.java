package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1725 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int[] indexStack = new int[n+2];
        indexStack[0] = -1;
        int stackI = 1;

        int max = 0;
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            int s = indexStack[stackI - 1];
            while(stackI > 1 && arr[indexStack[stackI-1]] > arr[i]){
                int e = indexStack[stackI - 2];
                max = Math.max(max, (s-e)*arr[indexStack[stackI-1]]);
                stackI--;
            }
            indexStack[stackI++] = i;
        }
        // stack 비우기
        int s = indexStack[stackI - 1];
        while(stackI > 1){
            int e = indexStack[stackI - 2];
            max = Math.max(max, (s-e)*arr[indexStack[stackI-1]]);
            stackI--;
        }

        System.out.println(max);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(indexStack));
    }
}
