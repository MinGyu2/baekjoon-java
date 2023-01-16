package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11779 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        
        var graph = new ArrayList<ArrayList<Pair>>(n+1);
        for(int i = 0;i<n+1;i++){
            graph.add(new ArrayList<Pair>());
        }

        for(int i = 0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Pair(e, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        var visited = new Triple[n+1];
        bfs(visited, graph, s, e);
        // System.out.println(graph);
        // System.out.println(visited[e]);
        StringBuilder sb = new StringBuilder();
        var pre = visited[e];
        sb.append(pre.w).append('\n');
        sb.append(pre.cnt).append('\n');
        int[] prt = new int[pre.cnt];
        // System.out.println(pre);
        for(int i = prt.length-1;i>-1;i--){
            prt[i] = pre.city;
            pre = pre.pre;
        }
        for(int c:prt){
            sb.append(c).append(' ');
        }
        System.out.println(sb);
    }
    static void bfs(Triple[] visited, ArrayList<ArrayList<Pair>> graph, int s, int e){
        visited[s] = new Triple(s, 0, 1, null);
        var priorityQueue = new PriorityQueue<Triple>((Triple t1, Triple t2)-> t1.w - t2.w);
        priorityQueue.add(visited[s]);
        while(!priorityQueue.isEmpty()){
            var v = priorityQueue.poll();
            if(v.city == e){
                return;
            }
            int cnt = v.cnt+1;
            for(Pair newC:graph.get(v.city)){
                int city = newC.city;
                if(visited[city] != null){
                    if(visited[city].w <= newC.w + v.w){
                        continue;
                    }
                }
                visited[city] = new Triple(city, v.w + newC.w, cnt, v);
                priorityQueue.add(visited[city]);
            }
        }
    }
    static class Triple{
        final int city; // 현재 도시 정보
        final int w; // 비용
        final int cnt; // 지나간 도시수
        final Triple pre; // 이전 도시 정보
        public Triple(int city, int w, int cnt, Triple pre){
            this.city = city;
            this.w = w;
            this.cnt = cnt;
            this.pre = pre;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %d %s)",city,w,cnt,pre);
        }
    }
    static class Pair{
        final int city;
        final int w;
        public Pair(int city, int w){
            this.city = city;
            this.w = w;
        }
        @Override
        public String toString() {
            return String.format("(%d %d)", city, w);
        }
    }
}
