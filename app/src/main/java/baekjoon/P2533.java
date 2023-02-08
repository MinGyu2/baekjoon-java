package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2533 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var tree = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i = 0;i<n+1;i++){
            tree.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<n-1;i++){
            var st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        // 입력 끝

        boolean[] visited = new boolean[n+1];
        System.out.println(findMinEarlyAdaptor(tree, visited, 1).getMin());
    }
    static Pair findMinEarlyAdaptor(ArrayList<ArrayList<Integer>> tree, boolean[] visited, int root){
        visited[root] = true;
        int a = 0; 
        int b = 1; // root 자기 자신이 early adaptor 이다!
        for(int v : tree.get(root)){
            if(visited[v]){
                continue;
            }
            var temp = findMinEarlyAdaptor(tree, visited, v);
            a += temp.a;
            b += temp.getMin();
        }
        return new Pair(b, a);
    }
    static class Pair{
        final int a,b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int getMin(){
            return (a > b)?b:a;
        }
        @Override
        public String toString() {
            return String.format("(%d %d)", a,b);
        }
    }
}