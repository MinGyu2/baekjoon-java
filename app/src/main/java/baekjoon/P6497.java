package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6497 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        while(true){
            // 에러 발생 백준의 채점 환경이 이상해서 그런것!
            // var br = new BufferedReader(new InputStreamReader(System.in));
            var st = new StringTokenizer(br.readLine());
            final int m = Integer.parseInt(st.nextToken());
            final int n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0){
                break;
            }
            
            var loads = new Load[n];
            for(int i = 0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                
                loads[i] = new Load(x, y, z);
            }
            var root = new int[m];
            for(int i = 0;i<m;i++){
                root[i] = i;
            }
            int savingCost = 0;
            Arrays.sort(loads, (Load l1, Load l2) -> l1.cost - l2.cost);
            for(var l:loads){
                if(!union(root, l.house1, l.house2)){
                    savingCost += l.cost;
                }
            }
            sb.append(savingCost).append('\n');
        }
        System.out.print(sb);
    }
    static boolean union(final int[] root,int a, int b){
        int rootA = getRoot(root, a);
        root[a] = rootA;
        int rootB = getRoot(root, b);
        root[b] = rootB;

        if(rootA == rootB){ // 이미 같은 그룹
            return false;
        }
        if(rootA > rootB){
            root[rootA] = rootB;
        }else{
            root[rootB] = rootA;
        }
        return true;
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
    static class Load{
        final int house1, house2, cost;
        public Load(int house1, int house2, int cost){
            this.house1 = house1;
            this.house2 = house2;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %d)", house1, house2, cost);
        }
    }
}
