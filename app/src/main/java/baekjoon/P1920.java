package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt((s)->Integer.parseInt(s)).toArray();
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b;
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            b = Integer.parseInt(st.nextToken());
            sb.append(findBinarySearch(arr, 0, n-1, b)).append('\n');
        }
        System.out.println(sb);
    }
    // arr 은 오름차순으로 정렬되어 있다.
    // arr 에 변수 v 가 있는지 찾기! 만약 발견하면 1 리턴 아니면 0 리턴한다.
    static int findBinarySearch(int[] arr, int start, int end, final int v){
        if(start > end){ // 발견 못함
            return 0;
        }
        int midIndex = (start + end)/2;
        int mid = arr[midIndex];
        if(mid == v){
            return 1; // 발견!
        }
        if(mid > v){ // 왼쪽 살피기
            return findBinarySearch(arr, start, midIndex-1, v);
        }else{ // 오른쪽 살피기
            return findBinarySearch(arr, midIndex+1, end, v);
        }
    }
}
