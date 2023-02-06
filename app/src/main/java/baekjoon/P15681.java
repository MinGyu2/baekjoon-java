package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15681 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int r = Integer.parseInt(st.nextToken());
        final int q = Integer.parseInt(st.nextToken());

        var tree = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i = 0;i<n+1;i++){
            tree.add(new ArrayList<>());
        }
        for(int x = 0;x<n-1;x++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        var subTreeCount = new int[n+1]; // 정점들의 서브 트리 수
        var visited = new boolean[n+1];

        getSubTreeCount(tree, subTreeCount, visited, r);

        var sb = new StringBuilder();
        for(int i = 0;i<q;i++){
            int u = Integer.parseInt(br.readLine());
            sb.append(subTreeCount[u]).append('\n');
        }
        // 입력 끝
        System.out.print(sb);
        
        // System.out.println(Arrays.toString(subTreeCount));
        // System.out.println(tree);
        // System.out.println(Arrays.toString(query));
    }
    static int getSubTreeCount(ArrayList<ArrayList<Integer>> tree, int[] subTreeCount, boolean[] visited, int root){
        visited[root] = true; // 이미 방문한것 즉 현재 쿼리의 부모이다!
        int cnt = 1;
        for(int u:tree.get(root)){
            if(visited[u]){
                continue;
            }
            cnt += getSubTreeCount(tree, subTreeCount, visited, u);
        }
        subTreeCount[root] = cnt;
        return cnt;
    }
}
