package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로
        var maze = new int[n][m];
        var graph = new ArrayList<ArrayList<Integer>>();
        char[] ch;
        // 입력 밑 연결된 그래프 배열 초기화
        for(int i = 0;i<n;i++){
            ch = br.readLine().toCharArray();
            for(int j = 0;j<m;j++){
                maze[i][j] = ch[j]-'0';
                graph.add(new ArrayList<>());
                if(maze[i][j] != 1){
                    continue;
                }
                int u = i*m + j;
                int v = (i-1)*m+j;
                if(i-1>=0 && maze[i-1][j] == 1){
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
                v = i*m+j-1;
                if(j-1>=0 && maze[i][j-1] == 1){
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
            }
        }
        var visited = new boolean[n*m];
        // 미로 1,1 -> n,m 위치로 이동할 때 지나야 하는 최소의 칸수
        // 0 -> 23 까지 갈 때 이동할 최소의 칸수  => 너비 우선 탐색으로 최소의 칸수 구한다 bfs
        bfs(visited, maze, m, graph, 0, n*m-1);
        // for(int[] ma:maze){
        //     System.out.println(Arrays.toString(ma));
        // }
        System.out.println(maze[n-1][m-1]);
    }
    static void bfs(boolean[] visited, int[][] maze,final int m,ArrayList<ArrayList<Integer>> graph, int s, int e){
        visited[s] = true;
        maze[s/m][s%m] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while(!queue.isEmpty()){
            int v = queue.poll();
            int cnt = maze[v/m][v%m] + 1;
            for(int i:graph.get(v)){
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                maze[i/m][i%m] = cnt;
                queue.add(i);
            }
        }
    }
}
