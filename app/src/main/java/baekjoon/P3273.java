package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        // 투 포인터 알고리즘
        int s = 0;
        int e = n-1;
        int cnt = 0;
        while(true){
            if(s >= e){
                break;
            }
            int temp = arr[s] + arr[e];
            if(temp == x){
                s++;
                e--;
                cnt++;
            }else if(temp > x){
                e--;
            }else{
                s++;
            }
        }
        System.out.println(cnt);
    }
}
