package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P4803 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while(true){
            var st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            var graph = new ArrayList<ArrayList<Integer>>(n+1);
            for(int i = 0;i<n+1;i++){
                graph.add(new ArrayList<Integer>());
            }
            for(int i = 0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            // Save the graph End
            // 트리인지 확인하기
            boolean[] visited = new boolean[n+1];
            int cnt = 0;
            for(int i = 1;i<n+1;i++){
                if(dfs(visited, graph, i, -1)){
                    cnt++;
                }
            }
            // System.out.println(graph);
            // System.out.println(cnt);
            sb.append("Case ").append(++t).append(": ");
            if(cnt == 0){
                sb.append("No trees.");
            }else if(cnt == 1){
                sb.append("There is one tree.");
            }else{
                sb.append(String.format("A forest of %d trees.", cnt));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    // no tree false
    // tree true
    static boolean dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int v, int parent){
        if(visited[v]){
            return false;
        }
        visited[v] = true;
        boolean re = true;
        for(var i:graph.get(v)){
            if(i == parent){ continue; }
            re = re && dfs(visited, graph, i, v);
        }
        return re;
    }
}