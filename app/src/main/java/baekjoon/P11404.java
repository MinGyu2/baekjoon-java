package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {
    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine()); // 도시의 수 vertex
        final int m = Integer.parseInt(br.readLine()); // 버스의 수 edge

        int[][] cost = new int[n+1][n+1];
        // cost 초기화
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                if(i == j){
                    cost[i][j] = 0;
                    continue;
                }
                cost[i][j] = Integer.MAX_VALUE; // 무한대
            }
        }
        for(int i = 0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발지
            int b = Integer.parseInt(st.nextToken()); // 도착지
            int c = Integer.parseInt(st.nextToken()); // 비용
            if(cost[a][b] > c){
                cost[a][b] = c;
            }
        }
        floydWarshall(cost, n);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                if(cost[i][j] == Integer.MAX_VALUE){
                    cost[i][j] = 0;
                }
                sb.append(cost[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void floydWarshall(int[][] cost, final int n){
        // O(n^3);
        for(int k = 1;k < n+1;k++){ // 경유지
            for(int i = 1;i<n+1;i++){ // 출발지
                for(int j = 1;j<n+1;j++){ // 도착지
                    if(cost[i][k] == Integer.MAX_VALUE || cost[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(cost[i][j] > cost[i][k] + cost[k][j]){
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
    }
}
