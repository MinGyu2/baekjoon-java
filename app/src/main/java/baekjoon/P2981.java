package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P2981 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int[] arr = new int[n];
        while(n-->0){
            arr[n] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(arr);
        // final int[] arr2 = arr.clone();
        int a = arr[0];
        // 1. 뺴기
        // 5 14 17 23 83
        // 0  9 12 18 78
        // 0  0  3  9 69
        // 0  0  0  6 66
        // 5  9  3  9 60
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                arr[j] -= arr[i];
            }
        }

        // 2. gcd
        int temp = 0;
        for(int i=arr.length-1; i>0;i--){
            temp = gcd(arr[i], temp);
        }

        // 3. 모든 약수 구하기
        StringBuilder sb = new StringBuilder();
        findDivisors(sb, temp);
        System.out.println(sb);
    }
    static int gcd(int a, int b){
        int temp;
        while(b > 0){
            temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
    static void findDivisors(final StringBuilder sb, final int a){
        int z = (int)Math.sqrt(a);
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 1;i<z+1;i++){
            if(a%i == 0){
                if(i != 1){
                    l.add(i);
                }
                if(i != a/i){
                    l.add(a/i);
                }
            }
        }
        Collections.sort(l);
        sb.append(l.toString().replaceAll("\\[|\\]|,", ""));
    }
}



