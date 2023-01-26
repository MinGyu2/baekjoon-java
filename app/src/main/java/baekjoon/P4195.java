package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P4195 {
    public static void main(String[] args) throws IOException{
        var sb = new StringBuilder();
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int f = Integer.parseInt(br.readLine());
            var hashMap = new HashMap<String,CountAndRoot>();
            while(f-- > 0){
                var st = new StringTokenizer(br.readLine());
                var a = st.nextToken(); // root main
                var b = st.nextToken();

                var rootA = getRoot(hashMap, a);
                var rootB = getRoot(hashMap, b);

                if(rootA == null){
                    rootA = new CountAndRoot(1, a);
                    hashMap.put(a, rootA);
                }
                hashMap.get(a).setRoot(rootA.getRoot());

                if(rootB == null){
                    rootB = new CountAndRoot(1, b);
                    hashMap.put(b, rootB);
                }
                hashMap.get(b).setRoot(rootB.getRoot());

                if(rootA.root.equals(rootB.root)){ // 중복으로 카운터 안하기
                    // 출력은 해야한다!! 해당 Set의 친구 수를 출력 해야 한다.
                    sb.append(rootA.getCnt()).append('\n');
                    continue;
                }
                // union
                rootB.setRoot(rootA.getRoot());
                rootA.setCnt(rootA.getCnt() + rootB.getCnt());

                sb.append(rootA.getCnt()).append('\n');
            }
        }
        System.out.print(sb);
    }
    static CountAndRoot getRoot(HashMap<String, CountAndRoot> hashMap, String s){
        var temp = s;
        if(hashMap.get(temp) == null){
            return null;
        }
        while(!temp.equals(hashMap.get(temp).root)){
            temp = hashMap.get(temp).root;
        }
        return hashMap.get(temp);
    }
    static class CountAndRoot{
        private int cnt;
        private String root;
        public CountAndRoot(int cnt, String root){
            this.cnt = cnt;
            this.root = root;
        }
        public String getRoot() {
            return root;
        }
        public void setRoot(String root) {
            this.root = root;
        }
        public int getCnt() {
            return cnt;
        }
        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}
