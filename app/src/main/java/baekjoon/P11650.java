package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int[][] arr = new int[n][2];
        while(--n > -1){
            arr[n] = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        }

        // Arrays.sort(arr, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         if(o1[0] == o2[0]){
        //             return o1[1] - o2[1];
        //         }
        //         return o1[0] - o2[0];
        //     }
        // });
        // merge sort
        mergeSrot(arr);
        StringBuilder sb = new StringBuilder();
        for(int[] i:arr){
            sb.append(i[0]+" "+i[1]).append("\n");
        }
        System.out.println(sb);
    }

    static void mergeSrot(int[][] arr){
        partition(arr, 0, arr.length-1);
    }
    static void merge(int[][] arr, int start, int end){ //
        int mid = (start+end)/2;
        int[][] a = new int[end - start + 1][];
        int f = start; // start ~ mid
        int t = mid+1; // mid+1 ~ end
        for(int x = 0; x<a.length;x++){
            if(f > mid){
                a[x] = arr[t++];
            }else if(t > end){
                a[x] = arr[f++];
            }else if(arr[f][0] > arr[t][0]){
                a[x] = arr[t++];
            }else if((arr[f][0] == arr[t][0]) && (arr[f][1] > arr[t][1])){
                a[x] = arr[t++];
            }else{
                a[x] = arr[f++];
            }
        }
        for(int i=0;i<a.length;i++){
            arr[start+i] = a[i];
        }
    }
    static void partition(int[][] arr, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            partition(arr, start, mid);
            partition(arr, mid+1, end);
            merge(arr, start, end);
        }
    }
}
 