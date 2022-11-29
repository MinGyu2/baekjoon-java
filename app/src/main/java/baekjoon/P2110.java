package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    public static void main(String[] args) throws IOException{
        // 가장 인접한 두 공유기 사이의 거리 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken()); // 집의 갯수
        final int c = Integer.parseInt(st.nextToken()); // 공유기 갯수
        int[] homes = new int[n]; // 집 좌표
        for(int i = 0;i<n;i++){
            homes[i] = Integer.parseInt(br.readLine());
        }
        // 배열 정렬 Nlog(N) 올림으로 정렬 *
        Arrays.sort(homes);
        
        // HlogH + NlogN + H;
        System.out.println(binarySearch(homes, homes[homes.length-1] - homes[0], c));
    }
    // maxDis 는 집들 사이 거리중 가장 먼 거리
    // 가장 인접한 공유기 사이의 최대 거리
    static int binarySearch(int[] homes,int maxDis, int minRouterCnt){
        int ans = 0;
        // ** 공유기 사이 거리
        int start = 1;
        int end = maxDis;
        int mid;
        // **
        int cnt = 0;
        while(start <= end){
            mid = (start + end)/2;
            cnt = routerCnt(homes, mid);
            if(cnt < minRouterCnt){ // 공유기 사이의 거리를 줄여야한다.
                end = mid-1;
            }else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
    
    // 최소로 인접할 수 있는 값(value)이 주어졌을 때 설치 가능한 공유기수를 리턴한다.
    // O(N) *
    static int routerCnt(int[] homes, int value){ // homes 은 올림으로 정렬되어있다.
        int ans = 1; // 처음 집에 무조건 설치한다!
        int f = homes[0];
        for(int i = 1; i < homes.length;i++){
            if(homes[i] - f >= value){
                ans++;
                f = homes[i];
            }
        }
        return ans;
    }
}
