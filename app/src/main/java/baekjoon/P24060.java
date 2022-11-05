package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P24060 {
    static int k;
    static int kNum = -1;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        mergeSort(a, 0, a.length-1);
        System.out.println(kNum);
    }
    static void mergeSort(int[] a, int p, int r){ // partition
        if(p < r){
            int mid = (p+r)/2;
            mergeSort(a, p, mid);
            mergeSort(a, mid+1, r);
            merge(a, p, mid, r);
        }
    }
    static void merge(int[] a, int p, int mid, int r){ // p ~ mid , mid+1 ~ r
        int i = p;
        int j = mid+1;
        int t = 0;
        int[] temp = new int[r-p + 1];
        while(i <= mid && j <= r){
            if(a[i]<= a[j]){
                temp[t++] = a[i++];
            }else{
                temp[t++] = a[j++];
            }
        }
        while(i <= mid){
            temp[t++] = a[i++];
        }
        while(j <= r){
            temp[t++] = a[j++];
        }
        for(int x=0; x<temp.length; x++){
            a[p+x] = temp[x];
            if(++cnt == k){
                kNum = temp[x];
            }
        }
    }
}
