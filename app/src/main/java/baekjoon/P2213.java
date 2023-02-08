package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2213 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n+1];
        var st = new StringTokenizer(br.readLine());
        for(int i = 1;i<n+1;i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        var tree = new ArrayList<ArrayList<Integer>>(n+1);
        for(int i = 0;i<n+1;i++){
            tree.add(new ArrayList<Integer>());
        }

        for(int i = 0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        boolean[] visited = new boolean[n+1];
        // 입력 끝
        var ans = independentGetSize(tree, visited, weight, 1);
        var sb = new StringBuilder();
        if(ans.a > ans.b){
            sb.append(ans.a).append('\n');
            ans.listA.sort((a,b)->a-b);
            for(int v:ans.listA){
                sb.append(v).append(' ');
            }
        }else{
            sb.append(ans.b).append('\n');
            ans.listB.sort((a,b)->a-b);
            for(int v:ans.listB){
                sb.append(v).append(' ');
            }
        }
        System.out.println(sb);

        // System.out.println(tree);
        // System.out.println(Arrays.toString(weight));
        System.out.println(ans);
    }
    static Pair independentGetSize(ArrayList<ArrayList<Integer>> tree, boolean[] visited, int[] weight, int root){
        visited[root] = true;
        int a = 0;
        int b = weight[root];

        var listA = new ArrayList<Integer>();
        var listB = new ArrayList<Integer>();
        for(int u:tree.get(root)){
            if(visited[u]){
                continue;
            }
            var temp = independentGetSize(tree, visited, weight,u);
            listB.addAll(temp.listB);
            b += temp.b;
            
            if(temp.a > temp.b){
                a += temp.a;
                listA.addAll(temp.listA);
            }else{
                a += temp.b;
                listA.addAll(temp.listB);
            }
        }
        listB.add(root);
        return new Pair(b,a, listB, listA);
    }
    static class Pair{
        final int a,b;
        final ArrayList<Integer> listA;
        final ArrayList<Integer> listB;
        public Pair(int a,int b, ArrayList<Integer> listA, ArrayList<Integer> listB){
            this.a = a;
            this.b = b;
            this.listA =listA;
            this.listB = listB;
        }
        // public int getMax(){
        //     return a > b ? a : b;
        // }
        @Override
        public String toString() {
            return String.format("(%d %d %s %s)",a,b,listA, listB);
        }
    }
}
