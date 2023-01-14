package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        var visited = new Path[200_001];
        bfs(visited, n, k);

        
        StringBuilder sb = new StringBuilder();
        Path p = visited[k];
        sb.append(p.w).append('\n');
        int[] ans = new int[p.w+1];
        for(int i = ans.length-1; i > -1;i--){
            ans[i] = p.v;
            p = p.pre;
        }
        for(int i = 0;i<ans.length;i++){
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
        // System.out.println(visited[k]);
    }
    static void bfs(Path[] visited,final int n, int k){
        visited[n] = new Path(0, n, null);
        var queue = new LinkedList<Integer>();
        queue.add(n);
        while(!queue.isEmpty()){
            int v = queue.poll();
            int newTime = visited[v].w+1;
            if(v == k){
                return;
            }
            // v-1
            int temp = (v-1 < 0)?0:v-1;
            if(visited[temp] == null){
                visited[temp] = new Path(newTime, temp, visited[v]);
                queue.add(temp);
            }
            if(k < v){
                continue;
            }
            // v가 n보다 작을 때는 동작 안함!
            // v+1
            temp = v+1;
            if(visited[temp] == null){
                visited[temp] = new Path(newTime, temp, visited[v]);
                queue.add(temp);
            }

            // 2*v
            temp = 2*v;
            if(visited[temp] == null){
                visited[temp] = new Path(newTime, temp, visited[v]);
                queue.add(temp);
            }
        }
    }
    static class Path{
        final int w, v;
        final Path pre;
        public Path(int w, int v, Path pre){
            this.w = w;
            this.v = v;
            this.pre = pre;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %s)",w,v,pre);
        }
    }
}
