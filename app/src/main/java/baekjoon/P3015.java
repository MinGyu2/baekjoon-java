package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] st = new int[n+1];
        int stI = 0;
        long ans = 0;
        while(n-->0){
            int h = Integer.parseInt(br.readLine());
            int temp = binarySearch1(st,0,stI-1,h);
            ans += stI-temp;
            stI = temp;
            // while(stI > 0 && st[stI-1] < h){
            //     stI--;
            //     ans++;
            // }
            // if(stI != temp)
            //     System.out.println("st : "+stI + " " + temp);

            int mem = stI;
            if(mem > 0 && st[stI-1] == h){
                temp = binarySearch1(st, 0, stI-1, h+1);
                mem = temp;
            }
            ans += stI-temp;
            // while(mem > 0 && st[mem-1] == h){
            //     mem--;
            //     ans++;
            // }
            
            if(mem > 0 && st[mem-1] > h){
                ans++;
            }
            st[stI++] = h;
        }
        System.out.println(ans);
    }
    static int binarySearch1(int[] arr, int s, int e, int v){ // 값 v 보다return index
        if(s >= e){
            if(arr[s] >= v){
                return s+1;
            }
            return s;
        }
        int mid = (s+e)/2;
        if(arr[mid] >= v){
            return binarySearch1(arr, mid+1, e, v);
        }else{
            return binarySearch1(arr, s, mid-1, v);
        }
    }
}
