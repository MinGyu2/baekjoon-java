package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P24444 {
    static int cnt = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        var arr = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n+1;i++){
            arr.add(new ArrayList<Integer>());
        }
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        for(int i = 1;i<n+1;i++){
            arr.get(i).sort((Integer a,Integer b)-> a-b);
        }
        boolean[] visited = new boolean[n+1];
        int[] order = new int[n+1];
        bfs(visited, arr, r,order);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<n+1;i++){
            sb.append(order[i]).append('\n');
        }
        System.out.println(sb);
    }
    static void bfs(boolean[] visited, ArrayList<ArrayList<Integer>> e, int r, int[] order){
        visited[r] = true;
        order[r] = cnt++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v:e.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    order[v] = cnt++;
                    queue.add(v);
                }
            }
        }
    }
}
