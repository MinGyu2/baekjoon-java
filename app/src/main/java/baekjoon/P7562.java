package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    // y-2 , x-1 
    // y-2 , x+1
    // y+2 , x-1 
    // y+2 , x+1
    // y-1 , x-2 
    // y+1 , x-2
    // y-1 , x+2 
    // y+1 , x+2
    final static int[] gY = {-2,-2,2,2,-1,1,-1,1};
    final static int[] gX = {-1,1,-1,1,-2,-2,2,2};
    public static void main(String[] args)throws IOException{
        final int[] visited = new int[300*300];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            int i = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());
            
            sb.append(bfs(visited,i,sY*i+sX,eY*i+eX)-1).append('\n');
        }
        System.out.println(sb);
        // \ eX
        // eY
    }
    static int bfs(int[] visited,final int i, int r, final int e){ // 최소값을 구하기 위한 너비 우선 탐색
        // visited 초기화
        for(int k = 0;k<i*i;k++){
            visited[k] = 0;
        }
        visited[r] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        while(!queue.isEmpty()){
            int v = queue.poll();
            int cnt = visited[v];
            int y = v/i;
            int x = v%i;
            for(int z = 0; z<8;z++){
                if(y+gY[z] < 0 || y+gY[z] > i-1 || x+gX[z] < 0 || x+gX[z] > i-1 ){
                    continue;
                }
                int temp = (y+gY[z])*i + x+gX[z];
                if(visited[temp] != 0){
                    continue;
                }
                visited[temp] = cnt+1;
                if(temp == e) { return cnt+1; }
                queue.add(temp);
            }
        }
        return visited[e];
    }
}
