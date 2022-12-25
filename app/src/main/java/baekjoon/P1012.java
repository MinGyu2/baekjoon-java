package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {
    final static int[] w = {-1,0,1,0}; // 가론
    final static int[] l = {0,-1,0,1}; // 세로
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[50][50];
        boolean[] visited = new boolean[50*50];
        boolean[][] graph = new boolean[50*50][4]; // {left,up,right,down}
        
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로
            int n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken());
            // map 채우기
            while(k-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            //그래프 연결선 초기화
            for(int y = 0;y<n;y++){
                for(int x = 0;x<m;x++){
                    if(!map[y][x]){ continue; }
                    // (y,x) 기준에서 left up 살피기
                    if(y-1 >= 0 && map[y-1][x]){ // up
                        graph[m*y + x][1] = true; // up
                        // y-1, x 위치에서 down
                        graph[m*(y-1) + x][3] = true;
                    }
                    if(x-1 >= 0 && map[y][x-1]){ // left
                        graph[m*y + x][0] = true; // left
                        // y, x-1 위치에서 down
                        graph[m*y + x-1][2] = true; // right
                    }
                }
            }
            int cnt = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(map[i][j]){
                        bfs(visited, graph, map, m, n, m*i+j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int m = Integer.parseInt(st.nextToken()); // 가로
        // int n = Integer.parseInt(st.nextToken()); // 세로
        // int k = Integer.parseInt(st.nextToken());
        // // map 채우기
        // while(k-->0){
        //     st = new StringTokenizer(br.readLine());
        //     int x = Integer.parseInt(st.nextToken());
        //     int y = Integer.parseInt(st.nextToken());
        //     map[y][x] = true;
        // }
        // //그래프 연결선 초기화
        // for(int y = 0;y<n;y++){
        //     for(int x = 0;x<m;x++){
        //         if(!map[y][x]){ continue; }
        //         // (y,x) 기준에서 left up 살피기
        //         if(y-1 >= 0 && map[y-1][x]){ // up
        //             graph[m*y + x][1] = true; // up
        //             // y-1, x 위치에서 down
        //             graph[m*(y-1) + x][3] = true;
        //         }
        //         if(x-1 >= 0 && map[y][x-1]){ // left
        //             graph[m*y + x][0] = true; // left
        //             // y, x-1 위치에서 down
        //             graph[m*y + x-1][2] = true; // right
        //         }
        //     }
        // }
        // int cnt = 0;
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         if(map[i][j]){
        //             bfs(visited, graph, map, m, n, m*i+j);
        //             cnt++;
        //         }
        //     }
        // }
        // // for(int i=0;i < n;i++){
        // //     System.out.println(Arrays.toString(map[i]));
        // // }
        // // for(int i = 0; i< n*m;i++){
        // //     System.out.println(Arrays.toString(graph[i]));
        // // }
        // System.out.println(cnt);
    }
    static void bfs(boolean[] visited,boolean[][] graph,boolean[][] map,int m,int n, int r){
        // 방문 기록 초기화
        for(int i = 0;i<visited.length;i++){
            visited[i] = false;
        }
        // 시작
        visited[r] = true;
        map[r/m][r%m] = false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int z = 0;z<4;z++){
                if(!graph[v][z]){
                    continue;
                }
                graph[v][z] = false;
                int y = v/m;
                int x = v%m;
                // z == 0 y, x-1
                // z == 1 y-1, x
                // z == 2 y, x+1
                // z == 3 y+1, x
                int i = m*(y+l[z]) + x + w[z];
                if(!visited[i]){
                    visited[i] = true;
                    map[y+l[z]][x + w[z]] = false;
                    queue.add(i);
                }
            }
        }
    }
}
