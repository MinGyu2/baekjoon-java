package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 100 이하
        int m = Integer.parseInt(br.readLine()); // 연결된 쌍의 수

        var e = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<n+1;i++){
            e.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            e.get(u).add(v);
            e.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];
        System.out.println(bfs(visited, e));
    }
    // 1번과 연결된 컴터 수 구하기
    // 너비 우선 탐색 으로 찾는다.
    static int bfs(boolean[] visited,ArrayList<ArrayList<Integer>> e){
        int cnt = 0;
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int n:e.get(u)){
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
