package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6549 {
    static long maxArea = 0; 
    public static void main(String[] args) throws IOException{
        solution3();
    }
    static void solution3() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringTokenizer st;

        long[] arr = new long[100001];
        int[] indexStack = new int[100001];

        int arrI = 0;
        indexStack[0] = -1;
        int stackI = 1;
        long max = 0;
        
        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()).compareTo("0") != 0){
            st = new StringTokenizer(str);
            arrI = 0;
            stackI = 1;
            max = 0;
            st.nextToken();
            while(st.hasMoreTokens()){
                arr[arrI] = Integer.parseInt(st.nextToken());
                long s = indexStack[stackI - 1];
                // 현재 입력보다 작은 높이가 나올 때 까지 스택에서 뻐낸다.
                while(stackI > 1 && arr[indexStack[stackI-1]] > arr[arrI]){
                    long e = indexStack[stackI - 2];
                    max = Math.max(max, (s-e)*arr[indexStack[stackI-1]]);
                    stackI--;
                }
                indexStack[stackI++] = arrI;
                arrI++;
            }
            // 현재 stack 비우기
            long s = indexStack[stackI - 1];
            while(stackI > 1){
                long e = indexStack[stackI - 2];
                max = Math.max(max, (s-e)*arr[indexStack[stackI-1]]);
                stackI--;
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }
    static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        StringTokenizer st;
        int n;
        int[] arr = new int[100001];
        int[] segmentTree = new int[262145];
        StringBuilder sb = new StringBuilder();
        while((s = br.readLine()).compareTo("0") != 0){
            st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            maxArea = 0;
            // 높이 배열 초기화
            for(int i = 0; i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // segment tree 배열 초기화
            init(arr, segmentTree, 0, 0, n-1);

            // 최고 넓이 구하기
            findMax(n, arr, segmentTree, 0, n-1);
            sb.append(maxArea).append('\n');
        }
        System.out.println(sb);
    }
    // 최소값의 인덱스를 세그먼트 트리에 저장한다.
    static int init(final int[] arr, final int[] segmentTree, final int node, final int start, final int end){
        if(start == end){ // 인덱스 값 넘겨준다.
            segmentTree[node] = start;
            return start;
        }
        int mid = (start + end)/2;
        int left = init(arr, segmentTree, 2*node+1, start, mid);
        int right = init(arr, segmentTree, 2*node+2, mid+1, end);
        segmentTree[node] = (arr[left] > arr[right]) ? right : left;
        return segmentTree[node];
    }
    // segment 트리의 특정 범위안에서 최소 값이 되는 인덱스를 리턴한다. log(n) 걸린다.
    static int findRangeMinValueIndex(final int[] arr, final int[] segmentTree, final int node, final int start, final int end, final int left, final int right){
        if(start > right || end < left){ // 범위 밖
            return -1;
        }
        if(left <= start && end <= right){ // 범위 안
            return segmentTree[node];
        }

        // left <=  이 범위에 들어오게 만들기  <= right
        int mid = (start + end)/2;
        int l = findRangeMinValueIndex(arr, segmentTree, 2*node+1, start, mid, left, right);
        int r = findRangeMinValueIndex(arr, segmentTree, 2*node+2, mid+1, end, left, right);
        if(l == -1){
            return r;
        }else if( r == -1){
            return l;
        }else{
            return (arr[l] > arr[r]) ? r : l;
        }
    }

    static void findMax(final int n,final int[] arr, final int[] segmentTree, final int left, final int right){
        if(left > right) { return; }
        int minIndex = findRangeMinValueIndex(arr, segmentTree, 0, 0, n-1, left, right);
        long area = (long)arr[minIndex] * (long)(right - left +1);
        if(maxArea < area) { maxArea = area; }
        findMax(n, arr, segmentTree, left, minIndex-1); // left
        findMax(n, arr, segmentTree, minIndex+1, right); // right
    }
}
