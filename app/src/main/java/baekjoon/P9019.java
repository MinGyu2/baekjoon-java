package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P9019 {
    static char[] ch = {'D','S','L','R'};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Command cmdD = (int a) -> { return (a*2)%10_000; };
        Command cmdS = (int a) -> { 
            return (a == 0)?9999:a-1;
        };
        Command cmdL = (int a) -> {
            int i = a/1000;
            a = (a*10 + i)%10_000;
            return a;
        };
        Command cmdR = (int a) -> {
            int i = a%10;
            a = a/10 + i*1000;
            return a;
        };

        Command[] cmds = {cmdD,cmdS,cmdL,cmdR}; // graph

        char[] ans = new char[10_000];
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            var visited = bfs(a, b, cmds);

            // 출력
            var pre = visited[b];
            int cnt = pre.cnt;
            for(int i = cnt-1;i>-1;i--){
                ans[i] = pre.v;
                pre = pre.pre;
            }
            for(int i = 0;i<cnt;i++){
                sb.append(ans[i]);
            }
            sb.append('\n');
        }
        // var visited = bfs(s, e, cmds);
        // var pre = visited[e];
        // int cnt = pre.cnt;
        // for(int i =cnt-1;i>-1;i--){
        //     ans[i] = pre.v;
        //     pre = pre.pre;
        // }
        // for(int i = 0;i<cnt;i++){
        //     sb.append(ans[i]);
        // }
        System.out.println(sb);
    }
    static Pair[] bfs(final int s, final int e, Command[] cmds){
        // 방문 기록 초기화
        Pair[] visited = new Pair[10_000];
        //
        visited[s] = new Pair(0,' ', null);
        var queue = new LinkedList<Integer>();
        queue.add(s);
        while(!queue.isEmpty()){
            int v = queue.poll();
            if(v == e){
                break;
            }
            Pair pre = visited[v];
            int cnt = pre.cnt+1;
            for(int i = 0;i<4;i++){
                int temp = cmds[i].cmd(v);
                if(visited[temp] != null){
                    continue;
                }
                visited[temp] = new Pair(cnt,ch[i], pre);
                queue.add(temp);
            }
        }
        return visited;
    }
    static class Pair{
        final int cnt;
        final char v;
        final Pair pre;
        public Pair(int cnt,char v, Pair pre){
            this.cnt = cnt;
            this.v = v;
            this.pre = pre;
        }
        @Override
        public String toString() {
            return String.format("(%d %c %s)", cnt, v,pre);
        }
    }
    static interface Command{
        public int cmd(int a);
    }
}
