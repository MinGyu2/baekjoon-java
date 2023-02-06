package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17472 {
    final static int MAX_LEN = 1001;
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 세로
        final int m = Integer.parseInt(st.nextToken()); // 가로

        int[][] island = new int[n+1][m+1];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j < m;j++){
                island[i][j] = Integer.parseInt(st.nextToken())*-1;
            }
        }

        // 섬 이름 정하기 + 갯수 구하기
        int name = 1;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(island[i][j] == -1){
                    setIslandNameNode(island, i, j, name);
                    name++;
                }
            }
        }
        final int islandCount = name-1;
        // end

        // 섬끼리 거리 구하기
        int[][] edge = new int[islandCount+1][islandCount+1];
        for(int i = 1;i<islandCount+1;i++){
            for(int j = i+1;j<islandCount+1;j++){
                edge[i][j] = MAX_LEN;
            }
        }
        // 가로 섬 거리 살피기
        for(int i = 0;i<n;i++){
            int first = island[i][0];
            int len = 0;
            for(int j = 1;j<m;j++){ // 가로
                int twice = island[i][j];
                if(first == 0){
                    first = twice;
                    continue;
                }
                if(first == twice){
                    len = 0;
                    continue;
                }
                if(twice == 0){
                    len++;
                    continue;
                }
                if(len > 1){
                    if(first < twice){
                        edge[first][twice] = Math.min(len, edge[first][twice]);
                    }else{
                        edge[twice][first] = Math.min(len, edge[twice][first]);
                    }
                }
                // System.out.println(String.format("%d %d %d", first,twice,len));
                // 마지막 작업
                first = twice;
                len = 0;
            }
        }
        // 세로 섬 거리 살피기
        for(int j = 0;j<m;j++){
            int first = island[0][j];
            int len = 0;
            for(int i = 1;i<n;i++){ // 가로
                int twice = island[i][j];
                if(first == 0){
                    first = twice;
                    continue;
                }
                if(first == twice){
                    len = 0;
                    continue;
                }
                if(twice == 0){
                    len++;
                    continue;
                }
                if(len > 1){
                    if(first < twice){
                        edge[first][twice] = Math.min(len, edge[first][twice]);
                    }else{
                        edge[twice][first] = Math.min(len, edge[twice][first]);
                    }
                }
                // System.out.println(String.format("%d %d %d", first,twice,len));
                // 마지막 작업
                first = twice;
                len = 0;
            }
        }
        // 섬끼리 거리 구함!

        // 모든 섬끼리 연결하기
        var queue = new PriorityQueue<Bridge>((b1, b2) -> b1.len - b2.len);
        for(int i = 1;i<islandCount+1;i++){
            for(int j = i+1;j<islandCount+1;j++){
                if(edge[i][j] == MAX_LEN){
                    continue;
                }
                queue.add(new Bridge(i, j, edge[i][j]));
            }
        }
        int[] root = new int[islandCount+1];
        for(int i = 1;i<islandCount+1;i++){
            root[i] = i;
        }
        
        int sum = 0;
        while(!queue.isEmpty()){
            var bridge = queue.poll();
            int rootA = getRoot(root, bridge.island1);
            root[bridge.island1] = rootA;
            int rootB = getRoot(root, bridge.island2);
            root[bridge.island2] = rootB;

            if(rootA == rootB){
                continue;
            }
            sum += bridge.len;
            if(rootA > rootB){
                root[rootA] = rootB;
            }else{
                root[rootB] = rootA;
            }
        }
        int f = getRoot(root, 1);
        for(int i = 2;i<islandCount+1;i++){
            if(f != getRoot(root, i)){
                // System.out.println(-1);
                // return;
                sum = -1;
                break;
            }
        }
        // System.out.println(Arrays.toString(root));
        System.out.println(sum);
        // System.out.println(queue);
        // System.out.println(islandCount);
        // for(int[] i:island){
        //     System.out.println(Arrays.toString(i));
        // }
        // for(int[] e:edge){
        //     System.out.println(Arrays.toString(e));
        // }
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
    static class Bridge{
        final int island1;
        final int island2;
        final int len; // bridge Length
        public Bridge(int island1, int island2, int len){
            this.island1 = island1;
            this.island2 = island2;
            this.len = len;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %d)", island1,island2,len);
        }
    }
    static void setIslandNameNode(int[][] island, int i, int j, int name){
        if(island[i][j] == -1){
            island[i][j] = name;
            setIslandNameNode(island, i, j+1, name);
            setIslandNameNode(island, i+1, j, name);
            //
            // 4 4
            // 0 1 0 1
            // 1 0 0 1
            // 1 0 0 1
            // 1 1 1 1
            // if(j == 0){ // i > 0 일때도 맨 마지막 줄이 실행안됨!!!
            //     return;
            // }
            // setIslandNameNode(island, i, j-1, name);
            // if(i == 0){
            //     return;
            // }
            // setIslandNameNode(island, i-1, j, name);
            //
            if(j != 0){
                setIslandNameNode(island, i, j-1, name);
                // return; 
            }
            if(i != 0){
                setIslandNameNode(island, i-1, j, name);
                // return;
            }
        }
    }
}
