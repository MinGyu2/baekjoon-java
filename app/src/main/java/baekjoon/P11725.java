package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11725 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var graph = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i = 0;i<n+1;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<n-1;i++){
            var st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // System.out.println(graph);
        var visited = new Integer[n+1];

        // dfs(visited, graph, 1, 0);
        bfs(visited, graph);

        StringBuilder sb = new StringBuilder();
        for(int i = 2;i<visited.length;i++){
            sb.append(visited[i]).append('\n');
        }
        // System.out.println(Arrays.toString(visited));
        System.out.print(sb);
    }
    static void dfs(Integer[] visited,ArrayList<ArrayList<Integer>> graph, int me, int parent){
        visited[me] = parent;
        for(var v : graph.get(me)){
            if(visited[v] != null){
                continue;
            }
            // visited[v] = me;
            dfs(visited, graph, v, me);
        }
    }
    static void bfs(Integer[] visited, ArrayList<ArrayList<Integer>> graph){
        visited[1] = 0;
        var queue = new LinkedList<Integer>();
        queue.add(1);
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for(var me:graph.get(parent)){
                if(visited[me] != null){
                    continue;
                }
                visited[me] = parent;
                queue.add(me);
            }
        }
    }
}
