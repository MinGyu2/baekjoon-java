package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // HashSet<Integer> s = new HashSet<Integer>();
        // while(n-->0){
        //     s.add(Integer.parseInt(st.nextToken()));
        // }
        // int m = Integer.parseInt(br.readLine());
        // st = new StringTokenizer(br.readLine()," ");
        // StringBuilder sb = new StringBuilder();
        // while(m-->0){
        //     if(s.contains(Integer.parseInt(st.nextToken()))){
        //         sb.append(1).append(' ');
        //     }else{
        //         sb.append(0).append(' ');
        //     }
        // }
        // System.out.println(sb);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            sb.append(isContain(arr,Integer.parseInt(st.nextToken()))).append(' ');
        }
        System.out.println(sb);
    }
    // binary search
    static int isContain(int[] arr, int v){
        int start = 0;
        int end = arr.length-1;
        int mid;
        while(!(start > end)){
            mid = (start + end)/2;
            if(arr[mid] == v){
                return 1;
            }else if(v > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return 0;
    }
}
