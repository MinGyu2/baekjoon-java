package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P24479 {
    static int c = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 수
        int m = Integer.parseInt(st.nextToken()); // 간선의 수
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        boolean[] visited = new boolean[n+1];    
        // int[][] e = new int[n+1][n+1]; // e[i][0] 에 e[i] 속 들어있는 원소 갯수이다.
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0;i < n+1;i++){
            arr.add(new ArrayList<Integer>());
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr.get(i).add(x);
            arr.get(x).add(i);
        }
        for(ArrayList<Integer> a:arr){
            // a.sort((Integer x,Integer y) -> x-y); // 올림
            a.sort((Integer x,Integer y) -> y-x); // 내림차순
        }
        int[] cnt = new int[n+1];
        dfs(visited, arr, r, cnt);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i< n+1;i++){
            sb.append(cnt[i]).append('\n');
        }
        System.out.print(sb);
        // for(int[] ee:e){
        //     if(ee[0] != 0) Arrays.sort(ee,1,ee[0]+1);
        //     // System.out.println(Arrays.toString(ee));
        // }
        // int[] cnt = new int[n+1];
        // dfs(visited, e, r, cnt);
        // StringBuilder sb = new StringBuilder();
        // for(int i = 1;i< n+1;i++){
        //     sb.append(cnt[i]).append('\n');
        // }
        // System.out.print(sb);
    }
    static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> e, int r,int[] cnt){
        visited[r] = true;
        cnt[r] = c++;
        ArrayList<Integer> temp = e.get(r);
        for(int i = 0;i < temp.size() ;i++){
            if(!visited[temp.get(i)]){
                dfs(visited, e, temp.get(i),cnt);
            }
        }
    }
}
