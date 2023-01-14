package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = 0;
        int e = 0;

        var arr = new Pair[n+1];
        var st = new StringTokenizer(br.readLine());
        // 1 3 2 4
        // null null null null   s=0 e=0
        // 1    null null null   s=0 e=1
        // 1    3    null null   s=0 e=2
        // 1    2    null null   s=0 e=2
        // 1    2    4    null   s=0 e=3
        while(st.hasMoreTokens()){
            int temp = Integer.parseInt(st.nextToken());
            temp = bs(arr, s, e, temp); // 이분 탐색
            e = (temp == e)?e+1:e; // end 갱신한다.
        }
        // System.out.println(Arrays.toString(arr));
        Pair now = arr[e-1];
        int ans = e;
        int[] sol = new int[ans];
        for(int i = ans-1;i>-1;i--){
            sol[i] = now.v;
            now = now.pre;
        }
        var sb = new StringBuilder();
        sb.append(e).append('\n');
        for(int i:sol){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
        // System.out.println(e);
        // System.out.println(Arrays.toString(sol));
        // System.out.println(arr[e-1]);
    }
    static int bs(Pair[] arr, int s, int e, int v){
        int mid = 0;
        while(s <= e){
            mid = (s+e)/2;
            if(arr[mid] == null || arr[mid].v >= v ){
                e = mid-1;
            }else {//f(arr[mid].v < v){
                s = mid + 1;
            }
            // else {
            //     e = mid - 1;
            //     // e = mid-1;
            // }
        }
        arr[s] = new Pair(v,(s == 0)?null:arr[s-1]);
        return s;
    }
    static class Pair{
        int v;
        Pair pre;
        public Pair(int v, Pair pre){
            this.v = v;
            this.pre = pre;
        }
        @Override
        public String toString() {
            return String.format("(%d %s)", v, pre);
        }
    }
}
