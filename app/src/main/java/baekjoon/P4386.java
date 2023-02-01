package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4386 {
    public static void main(String[] args) throws IOException{
        var br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        var coordinate = new Pair[n];
        for(int i = 0;i<n;i++){
            var st = new StringTokenizer(br.readLine());
            double d1 = Double.parseDouble(st.nextToken());
            double d2 = Double.parseDouble(st.nextToken());
            coordinate[i] = new Pair(d1,d2);
        }

        var starLine = new StarLine[n*(n-1)/2];
        int cnt = 0;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                double temp = distance( coordinate[i], coordinate[j]);
                starLine[cnt++] = new StarLine(i, j, temp);
            }
        }
        Arrays.sort(starLine,(StarLine s1, StarLine s2) -> {
            if(s1.distance < s2.distance){
                return -1;
            }else if(s1.distance == s2.distance){
                return 0;
            }else{
                return 1;
            }
        });

        var root = new int[n];
        for(int i = 0;i<n;i++){
            root[i] = i;
        }

        double ans = 0;
        cnt = 0;
        for(var sLine:starLine){
            int rootA = getRoot(root, sLine.star1);
            root[sLine.star1] = rootA;
            int rootB = getRoot(root, sLine.star2);
            root[sLine.star2] = rootB;

            if(rootA == rootB) { continue; }

            if(rootA < rootB){
                root[rootB] = rootA;
            }else {
                root[rootA] = rootB;
            }
            ans += sLine.distance;
            if(++cnt == n-1){
                break;
            }
        }
        System.out.println(String.format("%.2f",ans));
    }
    static int getRoot(int[] root, int i){
        int temp = i;
        while(temp != root[temp]){
            temp = root[temp];
        }
        return temp;
    }
    static double distance(Pair a, Pair b){
        double w = a.d1 - b.d1;
        w *=w;
        double h = a.d2 - b.d2;
        h *=h;
        double hypotenuse = Math.sqrt(w + h);
        return hypotenuse;
    }
    static class Pair{
        final double d1;
        final double d2;
        public Pair(double d1, double d2){
            this.d1 = d1;
            this.d2 = d2;
        }
        @Override
        public String toString() {
            return String.format("(%.2f %.2f)",d1,d2);
        }
    }
    // 두점 사이 거리 두점 각각 이름
    static class StarLine{
        final int star1;
        final int star2;
        final double distance;
        public StarLine(int star1, int star2, double distance){
            this.star1 = star1;
            this.star2 = star2;
            this.distance = distance;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %.2f)", star1, star2, distance);
        }
    } 
}
