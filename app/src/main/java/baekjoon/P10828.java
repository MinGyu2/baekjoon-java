package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    static HashMap<String,Fun> map = new HashMap<String,Fun>();
    static {
        map.put("push", (st, out, stack) -> {
            int x = Integer.parseInt(st.nextToken());
            stack.push(x);
        });
        map.put("pop", (st, out, stack) -> {
            out.append((stack.isEmpty())? -1:stack.pop()).append('\n');
        });
        map.put("size", (st, out, stack) -> {
            out.append(stack.size()).append('\n');
        });
        map.put("empty", (st, out, stack) -> {
            out.append((stack.isEmpty())? 1 : 0).append('\n');
        });
        map.put("top", (st, out, stack) -> {
            out.append((stack.isEmpty())?-1:stack.peek()).append('\n');
        });
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.get(st.nextToken()).cmd(st, sb, stack);
        }
        System.out.println(sb);
    }
    static interface Fun{
        public void cmd(StringTokenizer st, StringBuilder out, Stack<Integer> stack);
    }
}
