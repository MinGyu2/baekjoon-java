package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4803_1 {
    public static void main(String[] args) throws IOException{
        // FileReader fr = new FileReader("C:\\Users\\mq2022\\Desktop\\test.txt");
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int cs = 0;
        while(true){
            var st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }

            var root = new Integer[n+1];
            // False 면 해당 루트는 트리. True 면 트리 아니다.
            var isTree = new boolean[n+1]; // 해당 root 에서 트리인지 확인하기 위한 것. -> ex) 1번 루트에서 어떤지
            for(int i = 0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                if(root[v1] == null){
                    root[v1] = v1;
                    if(root[v2] == null){
                        root[v2] = v1;
                        isTree[v2] = true;
                    }else{
                        root[v2] = getRoot(root, v2);
                        isTree[root[v1]] = isTree[root[v2]]; // 루트 업데이트
                        isTree[root[v2]] = true;
                        root[root[v2]] = root[v1];
                    }
                }else if(root[v2] == null){
                    root[v1] = getRoot(root, v1);
                    root[v2] = root[v1];
                    
                    isTree[v2] = true;
                }else { // 여기서 사이클이 발생 할 수 있다.
                    root[v1] = getRoot(root, v1);
                    root[v2] = getRoot(root, v2);
                    if(root[v1] == root[v2]){
                        // 사이클 발생
                        isTree[root[v1]] = true; // 사이클 발생 했음으로 트리가 아니다.
                    }else {
                        // root[v2] 는 더이상 루트가 아님

                        // 두개의 집합 합치기
                        // root[v2] = root[v1];

                        // 1. 두개의 집합 합친것이 트리 인가 확인
                        isTree[root[v1]] = isTree[root[v1]] || isTree[root[v2]]; // false false 이여야 합친것도 Tree!!

                        // 2. root[v2]는 이제 루트가 아님
                        isTree[root[v2]] = true;

                        // 루트가 바뀜
                        root[root[v2]] = root[v1];
                    }
                }
            }
            // System.out.println(Arrays.toString(isTree));
            int cnt = 0;
            for(int i = 1;i<n+1;i++){
                if(!isTree[i]){
                    cnt++;
                }
            }
            sb.append(String.format("Case %d: ",++cs));
            if(cnt == 0){
                sb.append("No trees.");
            }else if(cnt == 1){
                sb.append("There is one tree.");
            }else {
                sb.append(String.format("A forest of %d trees.",cnt));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static int getRoot(Integer[] root, int v){
        int temp = v;
        while(root[temp] != temp){
            temp = root[temp];
        }
        return temp;
    }
}
