package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11780 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        
        var stage = new Path[n+1][n+1];
        
        for(int i = 0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(stage[s][e] != null && stage[s][e].w <= w){
                // stage[s][e] = Math.min(stage[s][e], w);
                continue;
            }
            stage[s][e] = new Path(w, 2, -1);
        }
        for(int i = 1;i<n+1;i++){
            stage[i][i] = new Path(0, 1, -1);
        }

        floydWarshall(stage, n);
        // 계산 끝
        // 출력
        // 1 도시 최소 비용 출력
        StringBuilder sb = new StringBuilder();
        // 2 도시의 개수 + 경로 출력
        StringBuilder sb2 = new StringBuilder();
        for(int k = 1;k<stage.length;k++){
            Path[] s = stage[k];
            for(int i = 1;i<s.length;i++){
                if(s[i] == null || k == i){
                    sb.append(0).append(' ');
                    sb2.append(0).append('\n');
                    continue;
                }
                sb.append(s[i].w).append(' ');
                sb2.append(s[i].cnt).append(' ');
                cityPath(sb2, k, i, stage);
                sb2.append(i);
                sb2.append('\n');
            }
            sb.append('\n');
            // System.out.println(Arrays.toString(s));
        }
        sb.append(sb2);
        System.out.print(sb);
        // System.out.println(sb2);
    }
    static void floydWarshall(Path[][] stage, int n){
        for(int k = 1; k<n+1;k++){
            for(int i = 1; i<n+1;i++){
                for(int j =1;j<n+1;j++){
                    // null 이면 무한
                    if(stage[i][k] == null || stage[k][j] == null){
                        continue;
                    }
                    if(stage[i][j] == null || stage[i][j].w > stage[i][k].w + stage[k][j].w){
                        int temp = stage[i][k].w + stage[k][j].w;
                        stage[i][j] = new Path(temp, stage[i][k].cnt + stage[k][j].cnt - 1, k);
                    }
                    // else if(stage[i][j].w > stage[i][k].w + stage[k][j].w){
                    //     int temp = stage[i][k].w + stage[k][j].w;
                    //     stage[i][j] = new Path(temp, stage[i][k].cnt + stage[k][j].cnt - 1, k);
                    // }
                }
            }
        }
    }
    static void cityPath(StringBuilder sb, int s, int e, Path[][] stage){
        int temp = stage[s][e].c1;
        if(temp == -1){
            sb.append(s).append(' ');
            return;
        }
        cityPath(sb, s, temp, stage);
        cityPath(sb,temp, e, stage);
    }
    // w cnt(지나간 도시 수) c1(중앙 도시 위치) pre(이전 도시)
    static class Path{
        final int w, cnt, c1;
        public Path(int w, int cnt, int c1){
            this.w = w;
            this.cnt = cnt;
            this.c1 = c1;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %d)", w, cnt, c1);
        }
    }
}
