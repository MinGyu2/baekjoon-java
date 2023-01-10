package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];
        var st = new StringTokenizer(br.readLine());
        var arr = new Triple[1001];
        for(int i = 0;i<n;i++){
            int temp = Integer.parseInt(st.nextToken());
            if(arr[temp-1] == null || arr[temp] == null){
                arr[temp] = new Triple(1, temp, null);
                for(int k = temp+1;k<1001;k++){
                    if(arr[k] == null){
                        arr[k] = arr[temp];
                    }else {
                        break;
                    }
                }
            }else if(arr[temp].a < arr[temp-1].a+1){ // 바꾸기
                arr[temp] = new Triple(arr[temp-1].a+1, temp, arr[temp-1]);
                for(int k = temp+1;k<1001;k++){
                    if(arr[k].a < arr[temp].a){
                        arr[k] = arr[temp];
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(arr[1000]);
    }
    static class Triple{
        final int a,b;
        final Triple c;
        public Triple(int a, int b,Triple c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public String toString() {
            return String.format("(%d %d %s)",a,b,c);
        }
    }
}
