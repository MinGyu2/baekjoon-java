package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17299 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dic = new int[1000001];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dic[arr[i]]++;
        }

        int[] stack = new int[n];
        int stackI = -1;
        int[] ans = new int[n];
        for(int i = n-1;i>-1;i--){
            while(true){
                if(stackI < 0){
                    ans[i] = -1;
                    stackI++;
                    stack[stackI] = arr[i];
                    break;
                }
                if(dic[arr[i]] < dic[stack[stackI]]){
                    ans[i] = stack[stackI];
                    stackI++;
                    stack[stackI] = arr[i];
                    break;
                }
                stackI--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int a:ans){
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
}
