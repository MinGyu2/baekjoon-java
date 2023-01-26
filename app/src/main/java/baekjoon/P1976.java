package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] root = new int[n+1];
        for(int i = 1;i<n+1;i++){
            root[i] = i;
        }

        for(int i = 1;i<n+1;i++){
            var st = new StringTokenizer(br.readLine());
            for(int j = 1;j<n+1;j++){
                if(Integer.parseInt(st.nextToken()) == 0){
                    continue;
                }
                // else if(i >= j){
                //     continue;
                // }
                int rootI = getRoot(root, i);
                int rootJ = getRoot(root, j);

                root[i] = rootI;
                root[j] = rootJ;
                root[rootJ] = rootI;
            }
        }

        var st = new StringTokenizer(br.readLine());

        boolean ans = true;
        int temp = Integer.parseInt(st.nextToken());
        final int rt = getRoot(root, temp); // 같은 집합에 속하는지 확인 하기 위한것
        for(int i = 1;i<m;i++){
            temp = Integer.parseInt(st.nextToken());
            if(rt == getRoot(root, temp)){
                continue;
            }
            ans = false;
        }
        System.out.println((ans)?"YES":"NO");
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
}
