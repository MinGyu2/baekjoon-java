package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10816 {
    public static void main(String[] args) throws IOException{
        solution3();
    }
    // v 값의 인덱스 찾기
    // arr 은 정렬되어 있다.
    static int findValueIndex(int[][] arr, int start, int end, int v){
        if(start > end){
            return -1;
        }
        int midIndex = (start + end)/2;
        int mid = arr[midIndex][0];
        if(mid == v){
            return midIndex;
        }
        if(mid > v){// 왼쪽 살피기
            return findValueIndex(arr, start, midIndex-1, v);
        }else { // 오른쪽 살피기
            return findValueIndex(arr, midIndex+1, end, v);
        }
    }
    // 이분 탐색 사용
    static void solution3() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt((s)-> Integer.parseInt(s)).toArray();
        Arrays.sort(a);
        int[][] arr = new int[n][2];
        int i = 0;
        int f;
        // 저장
        for(int temp:a){
            f = findValueIndex(arr, 0, i-1, temp);
            if(f == -1){
                // 삽입
                arr[i][0] = temp;
                arr[i][1]++;
                i ++;
            }else{
                // 갯수 증가
                arr[f][1]++;
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            f = findValueIndex(arr, 0, i-1, Integer.parseInt(st.nextToken()));
            sb.append((f != -1)?arr[f][1]:0).append(' ');
        }
        System.out.println(sb);
    }
    // 사전
    static void solution2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // count 하기
        while(n-->0){
            arr[10000000 + Integer.parseInt(st.nextToken())]++;
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-->0){
            sb.append(arr[10000000+Integer.parseInt(st.nextToken())]).append(' ');
        }
        System.out.println(sb);
    }
    static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i;
        while(n-->0){
            i = Integer.parseInt(st.nextToken());
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
                map.putIfAbsent(null, null);
            }else{
                map.put(i,1);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            i = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(i, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
