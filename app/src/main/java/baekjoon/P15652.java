package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15652 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pr = new int[m];
        backTracking(pr, n, 0, m);
        System.out.print(sb);
    }
    static void backTracking(int[] pr, final int n,int depth, final int maxDepth){
        if(depth == maxDepth){
            sb.append(Arrays.toString(pr).replaceAll("\\[|\\]|,", "")).append('\n');
            return;
        }
        for(int i = 0;i<n;i++){
            if(depth == 0 || pr[depth-1] <= i+1){
                pr[depth] = i+1;
                backTracking(pr, n, depth+1, maxDepth);
            }
        }
    }
}
