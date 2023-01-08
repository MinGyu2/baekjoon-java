package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cp = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n+1]; // 누적합
        for(int i = 1;i<n+1;i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }
        // 두 포인터 
        int s = 0, e = 0;
        int minlen = Integer.MAX_VALUE;
        while(s < e && e < n+1){ // !(s >= e || e > n) 이면 틀림 왜냐하면 s == e== 0 이기 때문 즉 무조건 한번은 돌아야 하는데 둘다 0이라서 못돔!!
            long temp = arr[e] - arr[s];
            if(temp < cp){
                e++;
            }else{
                minlen = Math.min(e-s, minlen);
                s++;
            }
            // if(s >= e || e > n){
            //     break;
            // }
        }
        System.out.println((minlen == Integer.MAX_VALUE)?0:minlen);
    }
}
