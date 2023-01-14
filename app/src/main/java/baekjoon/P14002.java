package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
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
        int ans = arr[1000].a;
        int[] ansArr = new int[ans];
        var temp = arr[1000];
        for(int i = ans-1;i>-1;i--){
            ansArr[i] = temp.b;
            temp = temp.c;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans).append('\n');
        for(int i:ansArr){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
        // System.out.println(arr[1000]);
        // System.out.println(Arrays.toString(ansArr));
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
            return String.format("%d %s",b,c);
        }
    }
}
