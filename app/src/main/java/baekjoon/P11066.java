package baekjoon;

import java.io.IOException;
import java.util.Arrays;

public class P11066 {
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        // int[] arr = {40, 30, 30, 50};
        int[] arr = {1, 21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32};
        // int[] arr = {1, 2,3,4,5,6,7,8};
        // int[] arr = {21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32};
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i = 1;i<arr.length;i++){
            sum[i] = sum[i-1] + arr[i];
        }
        System.out.println(Arrays.toString(sum));
        System.out.println(recursion(0, arr.length-1, arr, sum));
        System.out.println(ans);
    }
    static int recursion(int s, int e, int[] arr, int[] sumArr){
        while(true){
            if(s == e){
                return arr[s];
            }
            int max = Math.max(arr[s], arr[e]);
            int mid = sumArr[e-1] - sumArr[s];
            if(max <= mid){
                int f = arr[s] + arr[s+1];
                int t = arr[e-1] + arr[e];
                if(f<t){
                    arr[s+1] = f;
                    ans +=f;
                    s++;
                }else{
                    arr[e-1] = t;
                    ans +=t;
                    e--;
                }
            }else{
                if(s+1 > e-1){
                    int r = arr[s]+arr[e];
                    ans +=r;
                    return r;
                }
                int r = recursion(s+1, e-1, arr, sumArr);
                if(arr[s] < arr[e]){
                    r+=arr[s];
                    ans +=r;
                    r+=arr[e];
                    ans +=r;
                }else{
                    r+=arr[e];
                    ans +=r;
                    r+=arr[s];
                    ans +=r;
                }
                return r;
            }
        }
        // return 0;
    }
}
