package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        var e = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n+1;i++){
            e.add(new ArrayList<Integer>());
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            e.get(u).add(v);
            e.get(v).add(u);
        }
        for(int i = 1;i<n+1;i++){
            e.get(i).sort((Integer a,Integer b)->a-b);
        }
        // 1. dfs
        StringBuilder sb = new StringBuilder();
        boolean[] visited1 = new boolean[n+1];
        dfs(visited1, e, r, sb);

        // 2. bfs
        boolean[] visited2 = new boolean[n+1];
        StringBuilder sb2 = new StringBuilder();
        bfs(visited2, e, r, sb2);
        System.out.println(sb);
        System.out.println(sb2);
    }
    static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> e, int r, StringBuilder sb){
        visited[r] = true;
        sb.append(r).append(' ');
        for(int i:e.get(r)){
            if(!visited[i]){
                dfs(visited, e, i, sb);
            }
        }
    }
    static void bfs(boolean[] visited, ArrayList<ArrayList<Integer>> e, int r, StringBuilder sb){
        visited[r] = true;
        sb.append(r).append(' ');
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        while(!queue.isEmpty()){
            int i = queue.poll();
            for(int v:e.get(i)){
                if(!visited[v]){
                    visited[v] = true;
                    sb.append(v).append(' ');
                    queue.add(v);
                }
            }
        }
    }
}
