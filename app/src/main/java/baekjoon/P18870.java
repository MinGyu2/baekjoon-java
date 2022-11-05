package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();// N
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        // 1. sort
        // int[] cpy = Arrays.stream(arr.clone()).sorted().distinct().toArray();
        int[] cpy = Arrays.stream(arr.clone()).distinct().toArray();
        mergeSort(cpy);

        // 2. find
        StringBuilder sb = new StringBuilder();
        for(int a: arr){
            sb.append(findIndex(a, cpy)).append(" ");
        }
        System.out.println(sb);
    }
    static int findIndex(final int value, final int[] arr){
        int start = 0;
        int end = arr.length-1;
        int mid;
        while(true){
            mid = (start + end)/2;
            if(value > arr[mid]){
                start = mid+1;
            }else if(value < arr[mid]){
                end = mid-1;
            }else{
                break;
            }
        }
        return mid;
    }
    
    static void mergeSort(int[] arr){
        partition(arr, 0, arr.length-1);
    }
    static void merge(int[] arr, int start, int end){
        int mid = (start + end)/2;
        int f = start; // start ~ mid
        int t = mid+1; // mid+1 ~ end
        int[] newArr = new int[end-start+1];
        for(int i=0;i<newArr.length;i++){
            if(f > mid){
                newArr[i] = arr[t++];
            }else if(t > end){
                newArr[i] = arr[f++];
            }else if(arr[t] > arr[f]){
                newArr[i] = arr[f++];
            }else{
                newArr[i] = arr[t++];
            }
        }
        for(int i=0;i<newArr.length;i++){
            arr[start+i] = newArr[i];
        }
    }
    static void partition(int[] arr, int start, int end){
        if(start < end){ // start 와 end 가 다를때 까지 쪼개기
            int mid = (start + end)/2;
            partition(arr, start, mid);
            partition(arr, mid+1, end);
            merge(arr, start, end);
        }
    }
}
