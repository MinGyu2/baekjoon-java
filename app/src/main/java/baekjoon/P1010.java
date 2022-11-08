package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[31][31];
        for(int m = 1;m<31;m++){
            for(int n = 1;n<31;n++){
                if(m == n){
                    arr[m][n] = 1;
                }else if(n == 1) {
                    arr[m][n] = m;
                }else {
                    arr[m][n] = arr[m-1][n] + arr[m-1][n-1];
                }
            }
        }
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(arr[m][n]).append('\n');
        }
        System.out.println(sb);
    }
}
