package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1197 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        var graph = new ArrayList<ArrayList<Edge>>(v+1);
        for(int i = 0;i<v+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Edge(v1, v2, w));
            graph.get(v2).add(new Edge(v2, v1, w));
        }
        System.out.println(primAlgo(v, graph, 1));
        // var edges = new Edge[e];
        // for(int i = 0;i<e;i++){
        //     st = new StringTokenizer(br.readLine());
        //     int v1 = Integer.parseInt(st.nextToken());
        //     int v2 = Integer.parseInt(st.nextToken());
        //     int w = Integer.parseInt(st.nextToken());
        //     edges[i] = new Edge(v1, v2, w);
        // }
        // System.out.println(kruskalAlgo(v, edges));
    }
    static int primAlgo(final int v, ArrayList<ArrayList<Edge>> graph, int start){
        int node = start;
        var queue = new PriorityQueue<Edge>((Edge e1, Edge e2) -> e1.w - e2.w);
        var visited = new boolean[v+1]; // 사이클 유무 확인 가능 왜냐하면 prim 알고리즘의 특징 때문이다. 한붓 그리기를 생각하면 된다.
        visited[start] = true;
        int cnt = 0;
        for(int i = 0;i<v-1;i++){
            // 한 노드의 엣지 집어넣기
            for(var e:graph.get(node)){
                if(visited[e.v2]){ // 사이클 발생
                    continue;
                }
                queue.add(e);
            }
            // 가장 작은 크기의 vertex 꺼내기
            var e = queue.poll();
            node = e.v2;
            if(visited[node]){
                i--;
                continue;
            }
            visited[node] = true;
            cnt += e.w;
        }
        return cnt;
    }

    static int kruskalAlgo(final int v, Edge[] edges){
        // sort
        Arrays.sort(edges, (Edge e1, Edge e2) -> e1.w - e2.w);
        
        // 그래프가 이어져 있고 사이클 유무를 확인 하기 위한것
        int[] root = new int[v+1];
        for(int i = 1;i<v+1;i++){
            root[i] = i;
        }

        int n = 0;
        int cnt = 0;
        for(var edge:edges){
            int rootA = getRoot(root, edge.v1);
            root[edge.v1] = rootA;
            int rootB = getRoot(root, edge.v2);
            root[edge.v2] = rootB;

            if(rootA == rootB){ // 사이클 발생!!
                continue;
            }
            cnt += edge.w;
            root[rootB] = rootA;
            n++;
            if(n == v-1){
                break;
            }
        }
        return cnt;
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
    static class Edge{
        final int v1, v2, w;
        public Edge(int v1, int v2, int w){
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d, %d)",v1,v2,w);
        }
    }
}
