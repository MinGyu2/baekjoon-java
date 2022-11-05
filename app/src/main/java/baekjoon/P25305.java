package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P25305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s) -> Integer.parseInt(s)).toArray();

        // 버블 sort
        int f;
        boolean isChange;
        while(true){
            isChange = false;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i] < arr[i+1]){ // 내림
                    f = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = f;
                    isChange = true;
                }
            }
            if(!isChange){ break; }
        }
        System.out.println(arr[k-1]);
    }
}
