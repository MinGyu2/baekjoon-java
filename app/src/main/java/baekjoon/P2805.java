package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 나무 수
        final int m = Integer.parseInt(st.nextToken()); // 잘라서 필요한 나무 길이

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int maxHeight = 0;
        for(int i = 0;i<n;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = (trees[i]>maxHeight)?trees[i]:maxHeight;
        }

        // System.out.println(maxHeight);
        // System.out.println(cutedTreeHSum(trees,15));
        System.out.println(binarySearch(trees, m, maxHeight));
    }
    // 절단기 최대 높이 구하기 (H*log(N))
    static int binarySearch(int[] trees, int minCutH, int maxHeight){
        int start = 0;
        int end = maxHeight;
        int mid;
        int ans = 0; // 절단기 최대 높이
        long sum;
        while(start <= end){
            mid = (start + end)/2; // 절단기 높이
            sum = cutedTreeHSum(trees, mid);
            if(sum < minCutH){ // 절단기 높이를 낮춰야함
                end = mid-1;
            }else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
    // 잘려진 나무 높이들의 합 O(H)
    static long cutedTreeHSum(int[] trees, int cutH){
        long sum = 0;
        int temp;
        for(int tree:trees){
            temp = tree - cutH;
            if(temp >= 0){
                sum += temp;
            }
        }
        return sum;
    }
}
