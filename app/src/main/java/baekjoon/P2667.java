package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P2667 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        for(int i = 0;i<n;i++){
            map[i] = br.readLine().toCharArray();
        }
        
        var graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n*n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] == '1'){
                    int x = i*n+j;
                    // right
                    int right = x+1;
                    if(j+1 < n && map[i][j+1] == '1'){
                        graph.get(x).add(right);
                        graph.get(right).add(x);
                    }
                    // down
                    int down = (i+1)*n+j;
                    if(i+1 < n && map[i+1][j] == '1'){
                        graph.get(x).add(down);
                        graph.get(down).add(x);
                    }
                }
            }
        }
        boolean[] visited = new boolean[n*n];

        int cnt = 0;
        ArrayList<Integer> cntArr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(map[i][j] == '1'){
                    cnt++;
                    cntArr.add(bfs(map, visited, graph, n, i*n+j));
                }
            }
        }
        cntArr.sort((Integer a,Integer b)->a-b);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        for(int i:cntArr){
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
    static int bfs(char[][] map,boolean[] visited, ArrayList<ArrayList<Integer>> e,final int n, int r){
        int cnt = 1;
        visited[r] = true;
        map[r/n][r%n] = '0';
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int i:e.get(v)){
                if(!visited[i]){
                    visited[i] = true;
                    cnt++;
                    map[i/n][i%n] = '0';
                    queue.add(i);
                }
            }
        }
        return cnt;
    }
}
