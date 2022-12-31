package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1753 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(br.readLine());

        var g = new ArrayList<HashMap<Integer,Integer>>();
        
        for(int i = 0;i<V+1;i++){
            g.add(new HashMap<Integer,Integer>());
        }
        
        for(int i = 0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(g.get(u).containsKey(v)){
                int temp = g.get(u).get(v);
                w = (temp > w)?w:temp;
            }
            g.get(u).put(v, w);
            // g.get(v).put(u, w);
        }
        
        int[] visited = new int[V+1];

        // System.out.println(g.get(1).values());
        // System.out.println(g.get(1).keySet());
        // System.out.println(g.get(1));
        bfs(visited, g, K);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<V+1;i++){
            sb.append((visited[i] == Integer.MAX_VALUE)?"INF":visited[i]).append('\n');
        }
        // System.out.println(Arrays.toString(visited));
        System.out.println(sb);
    }
    static void bfs(int[] visited, ArrayList<HashMap<Integer,Integer>> g, int r){
        for(int i = 0;i<visited.length;i++){
            visited[i] = Integer.MAX_VALUE; // 무한대(INF)!
        }
        visited[r] = 0; // 처음 시작은 0
        Queue<Integer> queue = new LinkedList<>();
        // PriorityQueue<Pair> pqueue = new PriorityQueue<>((Pair a, Pair b)-> a.w - b.w);
        queue.add(r);
        while(!queue.isEmpty()){
            int v = queue.poll();
            int w = visited[v]; // v 정점 까지 오는데 든 가중치
            var edge = g.get(v);
            for(int u:edge.keySet()){
                int newW = w+edge.get(u); // 현재 새로 계산한 따끈따끈 한 가중치
                int oldW = visited[u]; // 오래된 u 가중치
                // 새로운 가중치가 더 크거나 같음
                if(oldW <= newW){ continue; }
                // 새로운 가중치가 더 작음
                visited[u] = newW;
                queue.add(u);
            }
        }
    }
    static class Pair{
        int v;
        int w;
        public Pair(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
}
