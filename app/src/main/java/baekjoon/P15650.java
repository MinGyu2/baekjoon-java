package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15650 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] pr = new int[m]; // print
        int[] remember = new int[n];
        backTracking(pr, remember, 0, m);
        System.out.print(sb);
    }
    static void backTracking(int[] pr, int[] remember,int depth, final int maxDepth){
        if(depth == maxDepth){
            sb.append(Arrays.toString(pr).replaceAll("\\[|\\]|,", "")).append('\n');
            return;
        }
        for(int i = 0; i<remember.length; i++){
            if(remember[i] == 0){
                if(depth == 0 || (depth != 0 && pr[depth-1] < i+1) ){
                    pr[depth] = i+1;
                    remember[i] = 1;
                    backTracking(pr, remember, depth+1, maxDepth);
                    remember[i] = 0;
                }
            }
        }
    }
}
