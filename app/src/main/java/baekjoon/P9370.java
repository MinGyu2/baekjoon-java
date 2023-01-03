package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P9370 {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> output = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 교차로
            int m = Integer.parseInt(st.nextToken()); // 도로
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 예술가들의 출발지
            // g와 h의 교차로를 무조건 지났다!
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            var graph = new ArrayList<ArrayList<Pair>>(n+1);
            // 그래프 초기화 하기
            for(int i = 0;i<n+1;i++){
                graph.add(new ArrayList<Pair>());
            }
            for(int i = 0;i<m;i++){ // 그래프 그리기
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()); // a 와 b 사이 거리(길이) 양방향
                graph.get(a).add(new Pair(b, d));
                graph.get(b).add(new Pair(a, d));
            }
            var visited = new Pair[n+1];
            bfs(visited, graph, s, g, h);
            // System.out.println(Arrays.toString(visited));
            for(int i = 0;i<t;i++){ // 목적지 후보
                int temp = Integer.parseInt(br.readLine());
                if(visited[temp].v == 1){
                    output.offer(temp);
                }
            }
            while(!output.isEmpty()){
                sb.append(output.poll()).append(' ');
            }
            sb.append('\n');
        }
        // end while
        System.out.print(sb);
    }
    static void bfs(Pair[] visited, ArrayList<ArrayList<Pair>> graph, int s,int g,int h){
        // visited 초기화
        for(int i = 1;i<visited.length;i++){
            // 0 이면 g와 h를 지나 i 로 도달 한게 아니다 라는 의미
            // 1 이면 g와 h를 지나 i 로 도달 한것 이다 라는 의미
            visited[i] = new Pair(0, Integer.MAX_VALUE);
        }
        visited[s].changeValue(0, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> a.w-b.w);
        pq.add(new Pair(s, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int v = p.v;
            int w = p.w;
            for(Pair pair:graph.get(v)){
                int tempV = pair.v;
                int tempW = pair.w;
                if(visited[tempV].w < w+tempW){
                    continue;
                }else if(visited[tempV].w == w+tempW && visited[tempV].v == 1){
                    continue;
                }
                // visited[tempV].w == w+tempW 을 때 visited[tempV].v == 0 이 된다는 뜻이다
                visited[tempV].v = visited[v].v; // 앞에서 g와 h를 방문 했는지 알아본다. 0 방문 안함, 1 방문 함
                if((v == g && tempV == h)||(v == h && tempV == g)){
                    visited[tempV].v = 1; // g 와 h 를 방문 했으면 1로 바꿔 준다.
                }
                visited[tempV].w = w+tempW;
                pq.add(new Pair(tempV, w+tempW));
            }
        }
    }

    static class Pair{
        int v,w;
        public Pair(int v,int w){
            this.v = v;
            this.w = w;
        }
        public void changeValue(int v,int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", v,w);
        }
    }
}
