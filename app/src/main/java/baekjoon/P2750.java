package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        while(--n >= 0){
            arr[n] = Integer.parseInt(br.readLine());
        }

        int f;
        boolean isChange = false;
        // 버블 sort
        while(true){
            isChange = false;
            for(int i=0; i< arr.length-1;i++){
                if(arr[i] > arr[i+1]){
                    f = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = f;
                    isChange = true;
                }
            }
            if(!isChange) { break; }
        }
        // 출력
        System.out.println(Arrays.toString(arr).replaceAll("\\[|\\]|,", "").replaceAll(" ", "\n"));
    }
}
