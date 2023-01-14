package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9252 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch1 = br.readLine().toCharArray();
        char[] ch2 = br.readLine().toCharArray();
        var w = new Weight[1001]; // dp

        int l1 = ch1.length;
        int l2 = ch2.length;
        var zero = new Weight(0, '0', null);
        for(int i = 0;i<l2+1;i++){
            w[i] = zero;
        }
        for(int j = 1;j<l1+1;j++){
            char c1 = ch1[j-1];
            boolean isSame = false;
            for(int i = 1;i<l2+1;i++){
                char c2 = ch2[i-1];
                int newCnt = w[i-1].cnt;
                int oldCnt = w[i].cnt;
                if(c1 == c2 && !isSame){
                    newCnt += 1;
                    if(newCnt > oldCnt){
                        w[i] = new Weight(newCnt, c2, w[i-1]);
                        isSame = true;
                    }
                    continue;
                }
                if(newCnt > oldCnt){ // 분기점
                    w[i] = w[i-1];
                }else{
                    isSame = false;
                }
            }
        }
        var sb = new StringBuilder();
        sb.append(w[l2]);
        System.out.println(w[l2].cnt);
        System.out.println(sb.reverse());
        // System.out.println(Arrays.toString(w));
    }
    static class Weight{
        final int cnt;
        final char value;
        final Weight pre;
        public Weight(int cnt,char v,Weight pre){
            this.cnt = cnt;
            this.pre = pre;
            this.value = v;
        }
        @Override
        public String toString() {
            // return String.format("(%d %c W)",cnt,value,pre);
            return String.format("%s%s",(value == '0')?"":value,(pre == null)?"":pre);
        }
    }
}
