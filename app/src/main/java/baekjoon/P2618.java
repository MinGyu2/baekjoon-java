package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2618 {
    // dp 와 dfs 를 이용하였다.
    static ValueAndPre[][] dp = new ValueAndPre[1001][1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도로의 갯수
        int w = Integer.parseInt(br.readLine()); // 사건의 갯수

        var p1 = new Pair(1,1); // 경찰1 위치
        var p2 = new Pair(n,n); // 경찰2 위치
        
        var depth = new Pair[w];
        for(int i = 0;i<w;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            depth[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        // System.out.println(Arrays.toString(depth));
        var ans = dfs(p1, p2, depth, 0, 0, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.v).append('\n');
        for(int i = 0;i<w;i++){
            sb.append(ans.police).append('\n');
            ans = ans.next;
        }
        // System.out.println(ans);
        System.out.println(sb);
    }
    static ValueAndPre dfs(Pair p1,Pair p2,Pair[] depth, int d, int a, int b){ // 깊이 우선 탐색
        if(d == depth.length){
            dp[a][b] = new ValueAndPre(0, -1, null);
            return dp[a][b];
        }
        // p1 -> depth[d] 로 이동
        // or p2 -> depth[d] 로 이동
        if(dp[a][b] != null){
            return dp[a][b];
        }
        var one = dfs(depth[d], p2, depth, d+1, d+1, b);
        int o = one.v + depth[d].getLen(p1);

        var two = dfs(p1, depth[d], depth, d+1, a, d+1);
        int t = two.v + depth[d].getLen(p2);
        //Math.min(one, two);
        if(o > t){
            dp[a][b] = new ValueAndPre(t, 2, two);
        }else{
            dp[a][b] = new ValueAndPre(o, 1, one);
        }
        return dp[a][b];
    }
    static class ValueAndPre{
        final int v;
        final int police; // 어느 경창이 선택했는지 알려준다.
        final ValueAndPre next;
        public ValueAndPre(int v, int police, ValueAndPre next){
            this.v = v;
            this.police = police;
            this.next = next;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %s)",v,police,next);
        }
    }
    static class Pair{
        final int a;
        final int b;
        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        public int getLen(Pair p){
            return Math.abs(a-p.a)+Math.abs(b-p.b);
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", a,b);
        }
    } 
}
