package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P13549 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int k = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] visited = new int[200_001];
        System.out.println(bfs(visited, n, k));
    }
    static int bfs(int[] visited, int s, int e){
        for(int i = 0;i<visited.length;i++){
            visited[i] = Integer.MAX_VALUE;
        }
        visited[s] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b)-> a.w - b.w);
        q.add(new Pair(s, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int v = pair.v;
            int w = pair.w;
            if(v == e){
                return w;
            }
            for(int i = 0;i<3;i++){
                int nextV = v;
                int nextW = w;
                // -1 , +1 -> 1
                // 2* -> 0
                if(i == 2){
                    if(v > e){
                        continue;
                    }
                    nextV += v;
                }else if(i == 1){
                    if(v > e){
                        continue;
                    }
                    nextV +=1;
                    nextW++;
                }else{
                    if(v == 0){
                        continue;
                    }
                    nextV -=1;
                    nextW++;
                }
                if(visited[nextV] > nextW){
                    visited[nextV] = nextW;
                    q.add(new Pair(nextV, nextW));
                }
            }
        }
        return -1;
    }
    static class Pair{
        int v,w;
        public Pair(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
}
