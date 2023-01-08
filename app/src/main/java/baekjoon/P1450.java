package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1450 {
    static int glcnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(sumArr));
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        dfs(a,arr, n/2, c, 0, 0);
        dfs(b,arr, n, c, n/2, 0);
        // System.out.println(cnt);
        
        // a b 중 길이가 짧은거 sort 하기
        if(a.size() > b.size()){
            b.sort((Integer i,Integer j)->i-j); // b가 짧음
            ArrayList<Integer> temp = b;
            b = a;
            a = temp;
            // 무조건 짧은건 a 가 되게 한다.
        }else{
            a.sort((Integer i,Integer j)->i-j);
        }
        int cnt = a.size();
        for(int i:b){
            if(i == 0){ continue; }
            // System.out.println(i+" : "+bs(a,c-i));
            cnt += bs(a,c-i)+1;
        }
        
        // System.out.println(a);
        // System.out.println(b);
        System.out.println(cnt);
        // glcnt = 0;
        // ArrayList<Integer> d = new ArrayList<>();
        // dfs(d, arr, n, c, 0, 0);
        // System.out.println(glcnt);
    }
    static int bs(ArrayList<Integer> arr, int cmp){ // 이분 탐색
        int e = arr.size()-1;
        int s = 0;
        while(s <= e){
            int mid = (s+e)/2;
            int temp = arr.get(mid);
            if(temp > cmp){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return e;
    }
    static void dfs(ArrayList<Integer> st, int[] arr,final int len, final int cmp, int s, int value){
        if(cmp < value){
            return;
        }
        st.add(value);
        glcnt++;
        for(int i = s;i<len;i++){
            value += arr[i];
            dfs(st,arr, len, cmp, i+1, value);
            value -= arr[i];
        }
    }
}
