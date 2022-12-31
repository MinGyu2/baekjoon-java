package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {
    public static void main(String[] args) throws IOException{
        // ArrayList<Queue<Integer>> g = new ArrayList<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0;i<200001;i++){
            // g.add(new LinkedList<Integer>());
            g.add(new ArrayList<Integer>());
        }
        int[] visited = new int[20001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        // k 번 동안 반복
        StringBuilder sb = new StringBuilder();
        while(k-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int V = Integer.parseInt(st.nextToken());
            final int E = Integer.parseInt(st.nextToken());
    
            // 초기화
            for(int i = 1;i<V+1;i++){
                visited[i] = 0;
                g.get(i).clear();
            }
            for(int i = 0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                g.get(u).add(v);
                g.get(v).add(u);
            }
            
            boolean temp = true;
            for(int i = 1;i<V+1;i++){
                if(visited[i] == 0){
                    temp &=bfs(visited, g, V, i);
                }
            }
            sb.append(temp?"YES":"NO").append('\n');
        }
        System.out.print(sb);
        // for(int i = 0;i<10;i++){
        //     System.out.print(visited[i]+" ");
        // }
        // System.out.println();
    }
    static boolean bfs(int[] visited,ArrayList<ArrayList<Integer>> g, final int V,int r){
        visited[r] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        boolean ans = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            int newNum = visited[v]*-1;
            for(int u:g.get(v)){
                if(visited[u] == 0){ // 한번도 방문 안한것
                    visited[u] = newNum;
                    queue.add(u); 
                }else if(visited[u] != newNum){
                    return false;
                }
            }
            // while(!g.get(v).isEmpty()){
            //     int u = g.get(v).poll();
            //     if(visited[u] == 0){ // 한번도 방문 안한것
            //         visited[u] = newNum;
            //         queue.add(u); 
            //     }else if(visited[u] != newNum){
            //         return false;
            //         // ans &=false;
            //     }
            // }
        }
        return ans;
    }
}
