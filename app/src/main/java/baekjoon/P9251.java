package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9251 {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // char[] s1 = br.readLine().toCharArray();

        // ArrayList<Integer>[] alpha = new ArrayList[26];
        // for(int i = 0;i<26;i++){
        //     alpha[i] = new ArrayList<Integer>();
        // }
        
        // {
        //     char[] s2 = br.readLine().toCharArray();
        //     for(int i = 0;i<s2.length;i++){
        //         alpha[s2[i] - 'A'].add(i+1);
        //     }
        // }
        
        // int start = Integer.MAX_VALUE;
        // int max = 0;
        // for(int j = 0; j < s1.length;j++){
        //     int[] arr = new int[s1.length];
        //     int a = 0;
        //     for(int i = j; i<s1.length;i++){
        //         char ch = s1[i];
        //         Iterator<Integer> iter = alpha[ch-'A'].iterator();
        //         while(iter.hasNext()){
        //             int k = iter.next();
        //             if(a == 0 && k < start) {
        //                 arr[a+1] = k;
        //                 a++;
        //                 break;
        //             }
        //             if(a!=0 && k > arr[a]){
        //                 arr[a+1] = k;
        //                 a++;
        //                 break;
        //             }
        //         }
        //     }
        //     // System.out.println(a);
        //     // System.out.println(Arrays.toString(arr));
        //     if(a != 0) {
        //         start = arr[1];
        //         if(a > max){ max = a;}
        //     }
        // }
        // System.out.println(max);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int[][] dp = new int[1001][1001];
        int max = 0;
        for(int i = 1; i < s1.length+1;i++){
            char ch1 = s1[i-1];
            for(int j = 1; j<s2.length+1;j++){
                if(ch1 == s2[j-1]){
                    dp[j][i] = dp[j-1][i-1] + 1;
                }else{
                    dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
                }
            }
            if(dp[s2.length][i] > max)
                max = dp[s2.length][i];
        }
        System.out.println(max);
    }
}
