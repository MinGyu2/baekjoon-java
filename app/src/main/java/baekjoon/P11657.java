package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수 vertex
        int m = Integer.parseInt(st.nextToken()); // 버스 노선 수 edge
        Edge[] edges = new Edge[m];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, w);
        }
        // System.out.println(Arrays.toString(edges));
        long[] ans = bellmanFord(edges, n, m);
        if(ans[0] == -1){
            System.out.println(-1);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 2;i<n+1;i++){
                if(ans[i] == Long.MAX_VALUE){ // 도시로 가는 경로가 없음
                    sb.append(-1);
                }else{
                    sb.append(ans[i]);
                }
                sb.append('\n');
            }
            System.out.print(sb);
        }
        // System.out.println(Arrays.toString(bellmanFord(edges, n, m)));
    }
    static long[] bellmanFord(Edge[] edges, int n, int m){
        long[] visited = new long[n+1];
        // 초기화
        for(int i = 0;i<visited.length;i++){
            visited[i] = Long.MAX_VALUE;
        }
        // 1번 도시에서 출발
        visited[1] = 0;

        for(int i = 0;i<n;i++){
            for(Edge edge:edges){
                // ***** 시작 위치가 아직 도달 못한 무한대 일 수도 있음!
                if(visited[edge.s] == Long.MAX_VALUE){
                    continue;
                }
                // long 범위를 넘어 버려서 그렇다!! 또 LongMax면서 edge 값이 음수 일때 값이 줄어든다고 인식하여
                // 무한히 오래 전으로 돌아간다고 생각하여 -1만을 출력할 수 있다.
                // ***** 이것 추가 안해서 틀렸다고 나옴! 즉 long 범위를 넘어 버려서 그렇다!!
                long w = visited[edge.s] + edge.w;
                if(visited[edge.e] <= w){
                    continue;
                }
                visited[edge.e] = w;
            }
        }

        for(Edge edge:edges){
            // *****시작 위치가 아직 도달 못한 무한대 일 수도 있음! 
            if(visited[edge.s] == Long.MAX_VALUE){
                continue;
            }
            // long 범위를 넘어 버려서 그렇다!! 또 LongMax면서 edge 값이 음수 일때 값이 줄어든다고 인식하여
            // 무한히 오래 전으로 돌아간다고 생각하여 -1만을 출력할 수 있다.
            // ***** 이것 추가 안해서 틀렸다고 나옴!
            if(visited[edge.e] > visited[edge.s] + edge.w){
                visited[0] = -1;
                break;
            }
        }
        return visited;
    }
    static class Edge{
        int s,e;
        long w;
        public Edge(int s, int e, long w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", s,e,w);
        }
    }
}
