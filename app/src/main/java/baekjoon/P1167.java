package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1167 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        var graph = new ArrayList<ArrayList<Pair>>(v+1);
        for(int i = 0;i<v+1;i++){
            graph.add(new ArrayList<Pair>());
        }
        int max = 0;
        int leaf = 0;
        for(int i = 0;i<v;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b;

            int cnt = 0;
            while((b = Integer.parseInt(st.nextToken())) != -1){
                int w = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Pair(b, w));
                cnt++;
            }
            if(cnt > max){
                leaf = a;
                max = cnt;
            }
        }
        var visited = new boolean[v+1];
        // System.out.println(dfs(visited,graph,1));
        var temp = dfs(visited,graph,leaf);
        System.out.println(Math.max(temp.a+temp.b, temp.c));
    }
    // 트리 == 순환 없음
    static Triple dfs(boolean[] visited,ArrayList<ArrayList<Pair>> graph, int parent){
        visited[parent] = true;
        // Pair re = ;
        int a = 0;
        int b = 0;
        int c = 0;
        for(Pair p:graph.get(parent)){
            if(visited[p.v]){ // 이미 방문 함! 따라서 무시
                continue;
            }
            var trTemp = dfs(visited, graph, p.v);
            int temp = trTemp.a + p.w;
            if(temp > a){
                b = a;
                a = temp;
            }else if(temp > b){
                b = temp;
            }
            // 5
            // 1 3 2 -1
            // 2 4 4 -1
            // 3 1 2 4 3 -1
            // 4 2 4 3 3 5 6 -1
            // 5 4 6 -1
            // 에서 2를 루트로 잡고 계산 하였을 때 10 이 나온다. 하지만 정점2를 안지나면 11이 나온다.
            // 이러한 오류를 잡기 위한 것이다.
            //  2 <- root 로 잡고 했을 때 오류
            //   \   <- 이 길을 안지나는것이 최대이다!
            //    4
            //   / \
            //  3   5
            // /
            //1
            if(trTemp.c > c){
                c = trTemp.c;
            }
        }
        return new Triple(a,b, (c > a+b)?c:a+b);
    }
    static class Triple{
        final int a,b,c;
        public Triple(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %d)", a,b,c);
        }
    }
    static class Pair{
        final int v,w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public String toString() {
            return String.format("(%d %d)",v,w);
        }
    }
}
