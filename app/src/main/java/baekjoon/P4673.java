package baekjoon;

public class P4673 {
    public static void main(String[] args){
        int[] arr = new int[10001];
        arr[0] = 1; // 1 은 self 넘버 아님
        for(int i = 1; i<10001;i++){
            if(arr[i] == 0){
                for(int f = d(i); f < 10001; f = d(f)){
                    arr[f] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 10001; i++){
            if(arr[i] == 0){
                sb.append(i+"\n");
            }
        }
        System.out.print(sb);
    }
    public static int d(int n){
        // 1. 1 나누고 10 나눈 나머지
        // 2. 10 나누고 10 나눈 나머지 ...
        int sum = 0;
        for(int i = 1;i<10001;i *=10){
            int a = n/i;
            if(a == 0){
                break;
            }
            sum += a%10;
        }
        return sum + n;
    }
}
