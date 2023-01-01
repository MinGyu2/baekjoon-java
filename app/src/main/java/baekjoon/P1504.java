package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1504 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        var g = new ArrayList<ArrayList<Pair>>(n+1);
        for(int i = 0;i<n+1;i++){
            g.add(new ArrayList<Pair>());
        }
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.get(v).add(new Pair(u, w));
            g.get(u).add(new Pair(v, w));
        }
        st = new StringTokenizer(br.readLine());
        // System.out.println(g);
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        // s -> v1 -> v2 -> e
        // s -> v2 -> v2 -> e
        //   S     M     E
        int[] visited = new int[n+1];

        int middleW = bfs(visited, g, v1, v2);
        if(middleW == -1){
            System.out.println(-1);
            return;
        }
        //1. s->v1 v2는 지나면 안됨
        int startW = bfs(visited, g, 1, v1);
        int endW = bfs(visited, g, n, v2);
        int ans1 = 0;
        if(startW == -1 || endW == -1){
            ans1 = Integer.MAX_VALUE;
        }else{
            ans1 = startW+endW+middleW;
        }
        //2. s->v2 v1는 지나면 안됨
        startW = bfs(visited, g, 1, v2);
        endW = bfs(visited, g, n, v1);
        int ans2 = 0;
        if(startW == -1 || endW == -1){
            ans2 = Integer.MAX_VALUE;
        }else{
            ans2 = startW+endW+middleW;
        }
        int ans = Math.min(ans1, ans2);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
        // System.out.println(bfs(visited, g, 2, 4, 3));
        // System.out.println(Arrays.toString(visited));
    }
    // 시작, 도착지, 지나면 안되는 정점
    // 지나면 안되는 정점 설정 했을 때 반례
    // 4 3
    // 1 2 1
    // 2 3 1
    // 2 4 1
    // 2 3
    // static int bfs(int[] visited,ArrayList<ArrayList<Pair>> g,int s,int e, int noN){
    static int bfs(int[] visited,ArrayList<ArrayList<Pair>> g,int s,int e){
        for(int i = 1;i<visited.length;i++){
            visited[i] = Integer.MAX_VALUE;
        }
        visited[s] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((Pair a, Pair b) -> a.w - b.w);
        queue.add(new Pair(s, 0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int v = p.v;
            int w = p.w; // 현재 까지 합쳐진 가중치
            if(v == e){
                return w;
            }
            for(Pair gP:g.get(v)){
                int chV = gP.v;
                int edge = gP.w + w; // 엣지의 가중치
                // if(chV == noN || visited[chV] < edge){
                if(visited[chV] < edge){
                    continue;
                }
                visited[chV] = edge;
                queue.add(new Pair(chV, edge));
            }
        }
        return -1;
    }
    // 해당 도착지에 가면서 지나면 안되는 정점
    static class Pair{
        int v,w;
        public Pair(int v,int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", v,w);
        }
    }
}
