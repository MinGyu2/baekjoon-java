package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9372 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        var sb = new StringBuilder();
        while(t-->0){
            var st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 국가의 수
            int m = Integer.parseInt(st.nextToken()); // 비행기위 종류

            for(int i = 0;i<m;i++){
                br.readLine();
            }
            sb.append(n-1).append('\n');
        }
        System.out.print(sb);
    }
}
