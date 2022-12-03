package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp;
        int start = 0;
        int end = 0;
        int[] arr = new int[n+1];
        for(int i = 0;i<n+1;i++){
            arr[i] = 1000001;
        }
        // N * logN
        while(st.hasMoreTokens()){
            temp = Integer.parseInt(st.nextToken());
            temp = binarySearch(arr, start, end, temp);
            end = (temp == end)?end+1:end;
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(end);
    }
    // 1 4 2 3 1
    // 1 무한
    // 1 4 무한
    // 1 2 무한
    // 1 2 3 무한
    // logN
    static int binarySearch(int[] arr, int s, int e, int value){
        int ans = 0;
        int mid;
        while(s <= e){
            mid = (s + e)/2;
            if(value > arr[mid]){
                ans = mid+1;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        arr[ans] = value;
        return ans;
    }
}
