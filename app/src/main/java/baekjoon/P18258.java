package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18258 {
    static class MQueue{
        private int size = 0;
        private Node firstNode = null;
        private Node lastNode = null;
        private class Node{
            private int value;
            private Node nextNode = null;
            public Node(int i){
                value = i;
            }
            public int getValue(){
                return value;
            }
            public void setNextNode(final Node node){
                nextNode = node;
            }
            public Node getNextNode(){
                return nextNode;
            }
        }
        public MQueue(){}
        public void push(int x){
            if(isEmpty() == 1){
                firstNode = new Node(x);
                lastNode = firstNode;
            }else{
                Node temp = new Node(x);
                lastNode.setNextNode(temp);
                lastNode = temp;
            }
            size++;
        }
        public int pop(){
            if(isEmpty() == 1){
                return -1;
            }else{
                Node temp = firstNode;
                firstNode = firstNode.getNextNode();
                size--;
                return temp.getValue();
            }
        }
        public int size(){
            return size;
        }
        public int isEmpty(){
            return (size == 0)? 1 : 0;
        }
        public int front(){
            if(isEmpty() == 1){
                return -1;
            }else{
                return firstNode.getValue();
            }
        }
        public int back(){
            if(isEmpty() == 1){
                return -1;
            }else{
                return lastNode.getValue();
            }
        }
    }
    static HashMap<String,Fn> hashMap = new HashMap<String,Fn>();
    static {
        hashMap.put("push", (mq, st, sb) -> {
            mq.push(Integer.parseInt(st.nextToken()));
        });
        hashMap.put("pop", (mq, st, sb) -> {
            sb.append(mq.pop()).append('\n');
        });
        hashMap.put("size", (mq, st, sb) -> {
            sb.append(mq.size()).append('\n');
        });
        hashMap.put("empty", (mq, st, sb) -> {
            sb.append(mq.isEmpty()).append('\n');
        });
        hashMap.put("front", (mq, st, sb) -> {
            sb.append(mq.front()).append('\n');
        });
        hashMap.put("back", (mq, st, sb) -> {
            sb.append(mq.back()).append('\n');
        });
    }
    interface Fn{
        public void cmd(MQueue mq,StringTokenizer st, StringBuilder sb);
    }
    public static void main(String[] args) throws IOException{
        MQueue mq = new MQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            hashMap.get(st.nextToken()).cmd(mq, st, sb);
        }
        System.out.println(sb);
    }
}
