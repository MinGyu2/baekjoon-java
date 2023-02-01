package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20040 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 같은 집합이면 사이클 이라 볼 수 있다.
        int[] root = new int[n];
        for(int i = 0;i<n;i++){
            root[i] = i;
        }
        for(int i = 1;i<m+1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rootA = getRoot(root, a);
            root[a] = rootA;
            int rootB = getRoot(root, b);
            root[b] = rootB;

            if(rootA == rootB){ // 사이클!!
                System.out.println(i);
                return;
            }
            // 다르면 집합에 합치기
            root[rootB] = rootA;
        }
        System.out.println(0);
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
}
