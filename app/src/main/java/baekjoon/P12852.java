package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P12852 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final var visited = new Pair[n+1];

        bfs(visited, n, 1);

        var prt = new int[visited[1].a+1];
        prt[0] = 1;
        for(int i = 1,j = 1;i<visited[1].a+1;i++){
            j = visited[j].b;
            prt[i] = j;
        }

        final var sb = new StringBuilder();
        for(int i = prt.length-1;i>-1;i--){
            sb.append(prt[i]).append(' ');
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(visited[1].a);
        System.out.println(sb);
    }
    static void bfs(Pair[] visited, int s, int e){ // s 시작 지점, e 도착지점
        for(int i = 0;i<visited.length;i++){
            visited[i] = new Pair(Integer.MAX_VALUE, -1);
        }
        visited[s].a = 0;
        // visited[s].b = -1; 이전 방문 노드
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int x = queue.poll();
            int cnt = visited[x].a + 1; // 방문 횟수 1 늘리기
            if(x == e){
                break;
            }
            // x가 3으로 나누어 떨어지면 3으로 나눈다.
            if(x % 3 == 0){
                int temp = x/3;
                if(visited[temp].a > cnt){ // 이미 방문한 곳을 중복으로 방문 하는것 방지용
                    visited[temp].a = cnt;
                    visited[temp].b = x; // 이전 방문 지점
                    queue.add(temp);
                }
            }
            // x가 2으로 나누어 떨어지면 2으로 나눈다.
            if(x % 2 == 0){
                int temp = x/2;
                if(visited[temp].a > cnt){ // 이미 방문한 곳을 중복으로 방문 하는것 방지용
                    visited[temp].a = cnt;
                    visited[temp].b = x; // 이전 방문 지점
                    queue.add(temp);
                }
            }
            // x에서 1을 뺀다
            int temp = x - 1;
            if(visited[temp].a > cnt){ // 이미 방문한 곳을 중복으로 방문 하는것 방지용
                visited[temp].a = cnt;
                visited[temp].b = x; // 이전 방문 지점
                queue.add(temp);
            }
        }
    }
    static class Pair{
        int a,b;
        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", a,b);
        }
    }
}
