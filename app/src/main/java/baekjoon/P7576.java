package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    // x,y
    // x-1, y | x+1, y
    // x, y-1 | x, y+1
    final static int[] gX = {-1,1,0,0};
    final static int[] gY = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int[][] box = new int[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] visited = new int[m*n];
        // 밭 채우기
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<m;j++){
        //         if(box[i][j] == 1){
        //             bfs(visited,box , m, n, i*m+j);
        //         }
        //     }
        // }
        bfs(visited,box , m, n);
        // box에서 0인 값 찾기 만약 찾으면 모두 안 익은 것 이기 때문에 -1 이다.
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, visited[i*m+j]);
            }
        }
        // visited로 최소 날짜 찾기
        System.out.println(max-1);
        // System.out.println(Arrays.stream(visited).max().getAsInt()-1);
        // for(int[] i:box){
        //     System.out.println(Arrays.toString(i));
        // }
        // System.out.println(Arrays.toString(visited));
    }
    static void bfs(int[] visited,final int[][] box,final int m,final int n){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(box[i][j] == 1){
                    int r = i*m+j;
                    visited[r] = 1;
                    queue.add(r);
                }
            }
        }
        while(!queue.isEmpty()){
            int v = queue.poll();
            int y = v/m;
            int x = v%m;
            int cnt = visited[v];
            for(int i = 0;i<4;i++){
                int mvY = y+gY[i];
                int mvX = x+gX[i];
                if(mvY < 0 || mvY > n-1|| mvX<0 || mvX > m-1 || box[mvY][mvX] == -1){
                    continue;
                }
                int temp = mvY*m+mvX;
                if(visited[temp] == 0 || visited[temp] > cnt+1){
                    visited[temp] = cnt+1;
                    box[mvY][mvX] = 1;
                    queue.add(temp);
                }
            }
        }
    }
}
