package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11780 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        
        var stage = new Integer[n+1][n+1];
        
        for(int i = 0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(stage[s][e] != null && stage[s][e] <= w){
                // stage[s][e] = Math.min(stage[s][e], w);
                continue;
            }
            stage[s][e] = w;
        }
        for(int i = 1;i<n+1;i++){
            stage[i][i] = 0;
        }

        floydWarshall(stage, n);
        for(Integer[] s:stage){
            System.out.println(Arrays.toString(s));
        }
    }
    static void floydWarshall(Integer[][] stage, int n){
        for(int k = 1; k<n+1;k++){
            for(int i = 1; i<n+1;i++){
                for(int j =1;j<n+1;j++){
                    // null 이면 무한
                    if(stage[i][k] == null || stage[k][j] == null){
                        continue;
                    }
                    if(stage[i][j] == null){
                        int temp = stage[i][k] + stage[k][j];
                        stage[i][j] = temp;
                    }else{
                        int temp = Math.min(stage[i][j],stage[i][k] + stage[k][j]);
                        stage[i][j] = temp;
                    }
                }
            }
        }
    }
    // w cnt(지나간 도시 수) c1(도시 출발 위치) pre(이전 도시)
    static class Path{
        final int w, cnt, c1;
        final Path pre;
        public Path(int w, int cnt, int c1, Path pre){
            this.w = w;
            this.cnt = cnt;
            this.c1 = c1;
            this.pre = pre;
        }
    }
}
