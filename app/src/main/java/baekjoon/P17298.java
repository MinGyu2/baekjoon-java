package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17298 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        int[] st = new int[n];
        int[] ans = new int[n];
        int stI = -1;
        for(int arrI = n-1;arrI>-1;arrI--){
            while(true){
                if(stI < 0){ // stack 텅 비어 있음
                    ans[arrI] = -1;
                    stI++;
                    st[stI] = arr[arrI];
                    break;
                }
                if(arr[arrI] < st[stI]){
                    ans[arrI] = st[stI];
                    stI++;
                    st[stI] = arr[arrI];
                    break;
                }
                stI--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int a:ans){
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
}
