package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15649 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // max depth

        int[] pr = new int[m];
        int[] arr = new int[n];
        backTracking(pr, arr, 0, m);
        System.out.print(sb);
    }
    static void backTracking(int[] pr, int[] arr,int depth, final int maxDepth){ // depth = 0 1 2 3 ... maxDepth
        if(depth == maxDepth){
            // 출력
            sb.append(Arrays.toString(pr).replaceAll("\\[|\\]|,", "")).append('\n');
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){ // 0 이면 사용 가능
                pr[depth] = i+1;
                arr[i] = 1; // 1이면 사용 불가
                backTracking(pr, arr, depth+1, maxDepth);
                arr[i] = 0;
            }
        }
    }
}
