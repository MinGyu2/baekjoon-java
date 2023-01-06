package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 이해를 못함
// 사이클 중 가장 작은 거리 사이클을 가진 값을 출력하는 거였음
// 1 ~ V 까지 각 노드별 사이클 값을o 다 더하는게 아니었음 젠장
public class P1956 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] dist = new int[v+1][v+1];
        for(int i = 1;i<v+1;i++){
            for(int j = 1;j<v+1;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발마을
            int b = Integer.parseInt(st.nextToken()); // 도착마을
            int c = Integer.parseInt(st.nextToken()); // 거리
            if(dist[a][b] > c){
                dist[a][b] = c;
            }
        }
        floydWarshall(dist, v);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<v+1;i++){
            min = (min > dist[i][i])?dist[i][i]:min;
        }
        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        System.out.println(min);
    }
    static void floydWarshall(int[][] dist, int v){
        for(int k = 1;k<v+1;k++){
            for(int i = 1;i<v+1;i++){
                for(int j = 1;j<v+1;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
