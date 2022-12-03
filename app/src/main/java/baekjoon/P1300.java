package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        System.out.println(binarySearch(n,k));
    }
    //총 O(2Nlog(N))
    // 2log(N)
    static long binarySearch(final long n, final long k){
        long ans = 0;
        // ** B 배열에 들어있는 값
        long start = 0;
        long end = n*n;
        long mid;
        // **
        Pair1300 p;
        while(start <= end){
            mid = (start + end)/2;
            p = getValueCntNIndex(n, mid);
            long index = p.getB();
            long cnt = p.getA();
            if(k > index){
                start = mid+1;
            }else if(cnt == 0){
                end = mid-1; // 필요 없을 듯?
            }else if(index >= k && k >=index - cnt + 1){
                ans = mid;
                break;
            }else {
                end = mid-1;
            }
        }
        return ans;
    }
    // NxN 배열에 해당 변수가 몇개 있는지 확인하면서 해당 변수의 위치를 알려준다. 리턴 변수는 2개 이다.
    // O(N)
    static Pair1300 getValueCntNIndex(final long n, long value){
        long cnt = 0;
        long index = 0;
        long temp;
        for(int i = 1; i<n+1;i++){
            temp = value/i;
            if(temp > n){
                index += n;
            }else{
                index += temp;
                if(value%i == 0){
                    cnt++;
                }
            }
        }
        return new Pair1300(cnt, index);
    }
}
class Pair1300{
    private long a;
    private long b;
    public Pair1300(long a,long b){
        this.a = a;
        this.b = b;
    }
    public long getA(){
        return a;
    }
    public long getB(){
        return b;
    }
    @Override
    public String toString() {
        return String.format("%d %d", a,b);
    }
}
