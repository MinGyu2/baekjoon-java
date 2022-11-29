package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1654 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 0. init
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lan = new int[k];
        int maxLan = 0;
        for(int i = 0;i<k;i++){
            lan[i] = Integer.parseInt(br.readLine());
            maxLan = (lan[i] > maxLan)? lan[i]:maxLan;
        }

        // System.out.println(binarySearch(lan, n, 1, maxLan));
        System.out.println(binarySearch(lan, n, maxLan));
    }
    // logN -> divideLanCount 가 있으니  H * logN => O(HlogN)
    static long binarySearch(final int[] lan,final int minLanCnt, int maxLan){
        long start = 1;
        long end = maxLan;
        long mid;
        long ans = 0; // 무조건 k 개의 랜선으로 n개의 랜선을 만들수 있음
        while(start <= end){
            mid = (start + end)/2;
            long cnt = divideLanCount(lan, mid);
            if(cnt < minLanCnt){ // 좀더 작게 랜선을 잘라야함
                end = mid-1;
            }else{ // 좀더 최소 갯수에 근접하게 하기 위해 크게 랜선을 잘라보기(가장 크게 자를수 있는 길이를 구하기 위한것)
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
    // O(H)
    static long divideLanCount(int[] lan, long cm){
        int cnt = 0;
        for(int i:lan){
            cnt += i/cm;
        }
        return cnt;
    }
}
