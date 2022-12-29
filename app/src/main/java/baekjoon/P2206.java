package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206 {
    final static int[] gN = {0,0,-1,1};
    final static int[] gM = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 세로
        final int m = Integer.parseInt(st.nextToken()); // 가로
        int[][] map = new int[n][m];
        int[] visited = new int[n*m];
        int[] wall = new int[n*m];

        for(int i = 0;i<n;i++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0;j<m;j++){
                map[i][j] = temp[j] - '0';
            }
        }

        // test
        // map[0][1] = 0;
        bfs(visited,wall , map, n, m);
        System.out.println(Arrays.toString(visited));
        System.out.println();
    }
    // visitedNum visitedNum 구분 안하고 방문 했는지 확인하기 위한것
    static void bfs(int[] visited,int[] wall, int[][] map, final int N, final int M){
        //(1,1) => (n,m) 까지 이동.
        //(0,0) => (n-1,m-1) 까지 이동.
        int s = 0;
        visited[s] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int v = queue.poll();

            int n = v/M;
            int m = v%M;
            if(n == N-1 && m == M-1){ return; }

            int cnt = visited[v]+1;
            int w = wall[v]; // 벽을 한번 뚫었는지 확인하기 위한것 => 1 이면 한번 뚫음
            for(int i =0;i<4;i++){
                n +=gN[i];
                m +=gM[i];
                int temp = n*M +m;
                if(n < 0 || n > N-1 || m < 0 || m > M-1 || map[n][m] == 1 || visited[temp] != 0){ // 벽일 때도 무시
                    n -=gN[i];
                    m -=gM[i];
                    continue;
                }
                visited[temp] = cnt;
                queue.add(temp);
                n -=gN[i];
                m -=gM[i];
            }
        }
    }
}
