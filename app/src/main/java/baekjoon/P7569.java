package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    // h n m
    // 0 0 -1
    // 0 0 1
    // 0 -1 0
    // 0 1 0
    // 1 0 0
    // -1 0 0
    final static int[] gH = {0,0,0,0,-1,1};
    final static int[] gN = {0,0,-1,1,0,0};
    final static int[] gM = {-1,1,0,0,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(st.nextToken()); // 가로
        final int N = Integer.parseInt(st.nextToken()); // 세로
        final int H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] farm = new int[H][N][M];
        for(int h = 0;h<H;h++){
            for(int n = 0;n<N;n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0;m<M;m++){
                    int temp = Integer.parseInt(st.nextToken());
                    farm[h][n][m] = temp;
                }
            }
        }

        // h = A/(M*N)
        // n = (A%(M*N))/M
        // m = (A%(M*N))%M
        int[] visited = new int[M*N*H];
        bfs(visited, farm, M, N, H);
        int c = 0;
        int max = 0;
        for(int[][] f1:farm){
            for(int[] f:f1){
                for(int v:f){
                    if(v == 0){
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, visited[c]);
                    c++;
                }
            }
        }
        System.out.println(max-1);
        // for(int[][] f1:farm){
        //     for(int[] f:f1){
        //         System.out.println(Arrays.toString(f));
        //     }
        // }
        // System.out.println(Arrays.toString(visited));
    }
    static void bfs(final int[] visited, final int[][][] farm,final int M,final int N,final int H){
        Queue<Integer> queue = new LinkedList<>();
        for(int h = 0;h<H;h++){
            for(int n = 0;n<N;n++){
                for(int m = 0;m<M;m++){
                    if(farm[h][n][m] == 1){
                        int temp = h*M*N+n*M+m;
                        visited[temp] = 1;
                        queue.add(temp);
                    }
                }
            }
        }
        
        final int temp = M*N;
        while(!queue.isEmpty()){
            int v = queue.poll();

            int h = v/temp;
            int n = (v%temp)/M;
            int m = (v%temp)%M;
            int cnt = visited[v]+1;
            for(int i = 0;i<6;i++){
                h += gH[i];
                n += gN[i];
                m += gM[i];
                if(h < 0 || h > H-1 || n < 0 || n > N-1|| m < 0 || m > M-1 || farm[h][n][m] == -1){
                    h -= gH[i];
                    n -= gN[i];
                    m -= gM[i];
                    continue;
                }
                int num = h*temp + n*M+ m;
                if(visited[num] != 0){
                    h -= gH[i];
                    n -= gN[i];
                    m -= gM[i];
                    continue;
                }
                visited[num] = cnt;
                farm[h][n][m] = 1;
                queue.add(num);
                h -= gH[i];
                n -= gN[i];
                m -= gM[i];
            }
        }
    }
}
