package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// EOF 문제!
public class P5639 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        // 이진 검색 트리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in;
        var preorder = new LinkedList<Integer>();
        // 입력
        while((in = br.readLine())!=null){
            preorder.add(Integer.parseInt(in));
        }
        recursion(preorder, Integer.MAX_VALUE, Integer.MAX_VALUE);
        System.out.print(sb);
    }
    static int recursion(final Queue<Integer> queue,int node, int parent){
        if(queue.isEmpty()){
            return -1;
        }
        int v = queue.poll();
        if(v < node){
            // left
            int temp = v;
            v = recursion(queue, v, node);
            sb.append(temp).append('\n');
            if(v == -1){return -1;}
        }
        if(v < parent) {
            // right
            int temp = v;
            v = recursion(queue, v, parent);
            sb.append(temp).append('\n');
            if(v == -1){return -1;}
        }
        // return
        return v;
    }
}
