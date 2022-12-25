package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        var visited = new int[200001];
        System.out.println(bfs(visited, n, k)-1);
    }
    static int bfs(int[] visited, int n, final int k){
        visited[n] = 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        while(!queue.isEmpty()){
            int v = queue.poll();
            int cnt = visited[v]+1;
            if(v == k){
                return visited[k];
            }
            // v+1  => v < k 일 때 가능
            // 2*v => v < k 일 때 가능
            if(v < k){
                if(visited[v+1] == 0){
                    visited[v+1] = cnt;
                    queue.add(v+1);
                }
                if(visited[2*v] == 0){
                    visited[2*v] = cnt;
                    queue.add(2*v);
                }
            }
            // v-1  => v > 0 일 때 가능
            if(v > 0){
                if(visited[v-1] == 0){
                    visited[v-1] = cnt;
                    queue.add(v-1);
                }
            }
        }
        return 0;
    }
}
