package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1774 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 우주신의 수
        final int m = Integer.parseInt(st.nextToken()); // 이미 연결된 통로 수

        var godCoordinates = new Coordinate[n+1]; // 우주신+선명이 좌표
        for(int i = 1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            godCoordinates[i] = new Coordinate(x, y);
        }

        var root = new int[n+1];
        for(int i = 1;i<n+1;i++){
            root[i] = i;
        }
        int cnt = 0; // n-1 개가 되어야한다.

        boolean[][] isLinked = new boolean[n+1][n+1];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isLinked[b][a] = true;
            isLinked[a][b] = true;
            
            // union
            int rootA = getRoot(root, a);
            root[a] = rootA;
            int rootB = getRoot(root,b);
            root[b] = rootB;
            
            if(rootA == rootB){ continue; }
            if(rootA < rootB){
                root[rootB] = rootA;
            }else{
                root[rootA] = rootB;
            }
            cnt++;
            // union end
        }


        // var godLines = new Line[n*(n-1)/2];
        var godLines = new PriorityQueue<Line>((Line l1, Line l2)-> {
            if(l1.distance < l2.distance){
                return -1;
            }else if(l1.distance == l2.distance){
                return 0;
            }else{
                return 1;
            }
        });
        // int index = 0;
        for(int i = 1;i<n;i++){
            for(int j = i+1;j<n+1;j++){
                if(isLinked[i][j]){ continue; }
                // godLines[index++] = new Line(i, j, distance(godCoordinates[i], godCoordinates[j]));
                godLines.add(new Line(i, j, distance(godCoordinates[i], godCoordinates[j])));
            }
        }
        // Arrays.sort(godLines, (Line l1, Line l2) -> {
        //     if(l1 == null){
        //         return 1;
        //     }else if(l2 == null){
        //         return -1;
        //     }
        //     if(l1.distance < l2.distance){
        //         return -1;
        //     }else {
        //         return 1;
        //     }
        // });

        double ans = 0;
        while(true){
            var l = godLines.poll();
            int rootA = getRoot(root, l.god1);
            root[l.god1] = rootA;
            int rootB = getRoot(root, l.god2);
            root[l.god2] = rootB;

            if(rootA == rootB){ continue; }
            if(rootA > rootB){
                root[rootA] = rootB;
            }else {
                root[rootB] = rootA;
            }
            ans += l.distance;
            cnt++;
            if(cnt == n-1){
                break;
            }
        }
        // for(Line l:godLines){
        //     int rootA = getRoot(root, l.god1);
        //     root[l.god1] = rootA;
        //     int rootB = getRoot(root, l.god2);
        //     root[l.god2] = rootB;

        //     if(rootA == rootB){ continue; }
        //     if(rootA > rootB){
        //         root[rootA] = rootB;
        //     }else {
        //         root[rootB] = rootA;
        //     }
        //     ans += l.distance;
        //     cnt++;
        //     if(cnt == n-1){
        //         break;
        //     }
        // }
        System.out.println(String.format("%.2f",ans));
        // System.out.println(Arrays.toString(godLines));
        // System.out.println(Arrays.toString(godCoordinates));
    }
    static double distance(Coordinate c1, Coordinate c2){
        long w = c1.x - c2.x;
        w *=w;
        long h = c1.y - c2.y;
        h *=h;
        return Math.sqrt(w + h);
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
    static class Coordinate{
        final int x, y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return String.format("(%d %d)", x, y);
        }
    }
    static class Line{
        final int god1, god2;
        final double distance;
        public Line(int god1, int god2, double distance){
            this.god1 = god1;
            this.god2 = god2;
            this.distance = distance;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %.2f)", god1, god2, distance);
        }
    }
}
