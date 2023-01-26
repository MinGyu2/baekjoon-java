package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] root = new int[n+1];
        for(int i = 1;i<n+1;i++){
            root[i] = i; // 처음의 루트 초기화
        }
        
        var sb = new StringBuilder();
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rootA = getRoot(root, a);
            root[a] = rootA;
            int rootB = getRoot(root, b);
            root[b] = rootB;
            if(cmd == 0){ // union a and b
                root[rootB] = rootA; // union !!
            }else if(rootA == rootB){ // Are a and b the same set?
                // Yes
                sb.append("YES").append('\n');
            }else {
                // No
                sb.append("NO").append('\n');
            }
        }
        System.out.print(sb);
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(root[temp] != temp){
            temp = root[temp];
        }
        return temp;
    }
}
