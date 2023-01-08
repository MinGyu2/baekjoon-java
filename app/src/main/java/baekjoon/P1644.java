package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1644 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n 이하의 소수 찾기 아리스토테네스의 체 방법이용
        boolean[] nums = new boolean[n+1];
        long[] sumArr = new long[4000_000+1];
        int len = findPrimeNumber(nums,sumArr);
        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(Arrays.copyOfRange(sumArr, 0, len)));
        System.out.println(findCountContiSum(sumArr, len, n));
    }
    static int findCountContiSum(long[] sumArr, int len, int cmp){ // 소수의 연속합 수 가 == n 이 나오는 갯수 구하기
        int s = 0;
        int e = 0;
        int cnt = 0;
        while(true){
            long temp = sumArr[e]-sumArr[s];
            if(temp == cmp){
                s++;
                e++;
                cnt++;
            }else if(temp < cmp){
                e++;
            }else{
                s++;
            }
            if(s >= e || e > len){
                break;
            }
        }
        return cnt;
    }
    // sumArr 의 길이를 리턴한다.
    static int findPrimeNumber(boolean[] nums, long[] sumArr){
        int len = nums.length;
        int cnt = 0;
        int c = 1;
        nums[0] = true;
        nums[1] = true;
        int i = 1;
        while(++i < len){
            if(nums[i]){
                continue;
            }
            cnt++;
            sumArr[c] = i + sumArr[c-1];
            c++;
            for(int j = i+i;j<len;j+=i){
                nums[j] = true;
            }
        }
        return cnt+1;
    }
}
