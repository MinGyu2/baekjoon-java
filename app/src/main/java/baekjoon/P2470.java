package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 0;
        int e = n-1;
        var tp = new Triple(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        while(true){
            if(s >= e){
                break;
            }
            int temp = arr[s]+arr[e];
            if(Math.abs(tp.w) > Math.abs(temp)){
                tp.w = temp;
                tp.v1 = arr[s];
                tp.v2 = arr[e];
            }
            if(temp == 0){
                break;
            }else if(temp > 0){
                // e 를 바꿔야함
                // s+1 e-1 사이 이분 탐색 해서 최적의 e 값 찾기
                e = bs(arr, s+1, e-1, arr[s], e-1, tp);
                // e--;
            }else { // temp < 0
                // s 를 바꿔야함 
                // s+1 e-1 사이 이분 탐색 해서 최적의 s 값 찾기
                s = bs(arr, s+1, e-1, arr[e], s+1, tp);
                // s++;
            }
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(tp);
    }
    static int bs(int[] arr, int s, int e, int w, int init, Triple tp){ // cp 는 비교용 
        int mid = init;
        while(true){
            if(s > e){
                return mid;
            }
            mid = (s + e)/2;
            int temp = w+arr[mid];
            // 6
            // -98 -95 -93 -81 -77 80
            // 답 -81 80
            // 오답 -77 80
            // 이분 탐색에서도 비교를 해 줘야 한다!
            if(Math.abs(tp.w) > Math.abs(temp)){
                tp.w = temp;
                if(w > arr[mid]){
                    tp.v1 = arr[mid];
                    tp.v2 = w;
                }else{
                    tp.v1 = w;
                    tp.v2 = arr[mid];
                }
            }
            //
            if(temp == 0){
                return mid;
            }else if(temp > 0){
                e = mid-1;
            }else {
                s = mid+1;
            }
        }
    }
    static class Triple{
        int w,v1,v2;
        public Triple(int w,int v1,int v2){
            this.w = w;
            this.v1 = v1;
            this.v2 = v2;
        }
        @Override
        public String toString() {
            return String.format("%d %d", v1,v2);
        }
    }
}
