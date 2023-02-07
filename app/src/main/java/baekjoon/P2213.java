package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
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
        // System.out.println(tree);
        // System.out.println(Arrays.toString(weight));
        System.out.println(independentSetSize(tree, visited, weight, 7));

        // System.out.println();
        // var nlist = new NodeList();
        // nlist.add(1);
        // // nlist.add(2);
        // // nlist.add(3);

        // var nlist2 = new NodeList();
        // nlist2.add(4);
        // nlist2.add(5);
        // nlist2.add(6);
        // nlist.merge(nlist2);

        // System.out.println(nlist);
        // System.out.println(nlist2);
    }
    static Pair independentSetSize(ArrayList<ArrayList<Integer>> tree, boolean[] visited, int[] weight, int root){
        visited[root] = true;
        int a = 0;
        int b = weight[root];
        for(int u:tree.get(root)){
            if(visited[u]){
                continue;
            }
            var temp = independentSetSize(tree, visited, weight,u);
            b += temp.b;
            a += temp.getMax();
        }
        return new Pair(b,a);
    }
    static class Pair{
        final int a,b;
        public Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
        public int getMax(){
            return a > b ? a : b;
        }
        @Override
        public String toString() {
            return String.format("(%d %d)",a,b);
        }
    }
    static class Node{
        private Node next;
        private int value;
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        @Override
        public String toString() {
            return String.format("%d %s",value,next);
        }
    }
    static class NodeList{
        Node first = null;
        Node end = null;
        public NodeList(){}
        public void add(int v){
            Node n = new Node(v, null);
            if(end != null){
                end.setNext(n);
            }
            end = n;
            if(first == null){
                first = n;
            }
        }
        public void merge(NodeList nodeList){
            if(this.end != null){
                this.end.next = nodeList.first;
            }
            this.end = nodeList.end;

            if(this.first == null){
                this.first = nodeList.first;
            }
        }
        @Override
        public String toString() {
            return String.format("(%s)",first);
        }
    }
}
