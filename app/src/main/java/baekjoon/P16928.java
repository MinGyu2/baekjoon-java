package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928 {
    public static void main(String[] argsi) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 사다리 수
        final int m = Integer.parseInt(st.nextToken()); // 뱀 수
        int[] ladder = new int[101];
        int[] snake = new int[101];
        for(int i = 0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(i < n){
                ladder[a] = v;
            }else{
                snake[a] = v;
            }
        }

        int[] visited = new int[101];
        bfs(visited, ladder, snake);
        // System.out.println(Arrays.toString(ladder));
        // System.out.println(Arrays.toString(snake));
        // System.out.println(Arrays.toString(visited));
        System.out.println(visited[100]-1);
    }
    static void bfs(final int[] visited,final int[] ladder, final int[] snake){
        // 1 부터 시작
        int s = 1;
        visited[s] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int v = queue.poll();
            if(v == 100){ break; }
            int cnt = visited[v]+1;
            for(int i = 1;i<7;i++){
                int temp = v+i;
                if(temp > 100 || visited[temp] != 0){
                    continue;
                }
                int temp2 = temp;
                // 반례
                // 1 1
                // 13 99
                // 8 7
                    
                // # Output
                // 4
                    
                // # Answer
                // 3 (1 - 7 - 13(99) - 100)
                //if(visited[temp2] == 0) 문 추가 하였다.
                // 왜냐하면 방문 된 곳이 0이 아니면 이미 최소 주사위 사용 값으로 방문 했기 때문. 
                // => 너비 우선 탐색의 특징이다.
                // 최소값을 구하였다.
                while(snake[temp2]!= 0){
                    if(visited[temp2] == 0){
                        visited[temp2] = cnt;
                    }
                    temp2 = snake[temp2];
                }
                while(ladder[temp2]!=0){
                    if(visited[temp2] == 0){
                        visited[temp2] = cnt;
                    }
                    temp2 = ladder[temp2];
                }
                if(visited[temp2] == 0){
                    visited[temp2] = cnt;
                    queue.add(temp2);
                }
            }
        }
    }
}
