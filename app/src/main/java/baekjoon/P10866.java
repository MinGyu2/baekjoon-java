package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10866 {
    static HashMap<String,Fun> map = new HashMap<>();
    static {
        map.put("push_front", (st,dq,sb)->{
            int x = Integer.parseInt(st.nextToken());
            dq.push_front(x);
        });
        map.put("push_back", (st,dq,sb)->{
            int x = Integer.parseInt(st.nextToken());
            dq.push_back(x);
        });
        map.put("pop_front", (st,dq,sb)->{
            sb.append(dq.pop_front()).append('\n');
        });
        map.put("pop_back", (st,dq,sb)->{
            sb.append(dq.pop_back()).append('\n');
        });
        map.put("size", (st,dq,sb)->{
            sb.append(dq.size()).append('\n');
        });
        map.put("empty", (st,dq,sb)->{
            sb.append(dq.empty()).append('\n');
        });
        map.put("front", (st,dq,sb)->{
            sb.append(dq.front()).append('\n');
        });
        map.put("back", (st,dq,sb)->{
            sb.append(dq.back()).append('\n');
        });
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MDeque md = new MDeque();
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.get(st.nextToken()).cmd(st, md, sb);
        }
        System.out.println(sb);
    }
    static interface Fun{
        public void cmd(StringTokenizer st, MDeque dq, StringBuilder sb);
    }
}

class MDeque{
    private class Node{
        private int value;
        private Node nextNode = null;
        private Node preNode = null;
        public Node(int value){
            this.value = value;
        }
        public void setNextNode(Node node){
            nextNode = node;
        }
        public Node getNextNode(){
            return nextNode;
        }
        public void setPreNode(Node node){
            preNode = node;
        }
        public Node getPreNode(){
            return preNode;
        }
        public int getValue(){
            return value;
        }
    }
    private int size = 0;
    private Node firstNode = null;
    private Node lastNode = null;
    public MDeque(){}
    public void push_front(int x){
        if(empty() == 1){
            firstNode = new Node(x);
            lastNode = firstNode;
        }else{
            Node temp = new Node(x);
            temp.setNextNode(firstNode);
            firstNode.setPreNode(temp);
            firstNode = temp;
        }
        size++;
    }
    public void push_back(int x){
        if(empty() == 1){
            lastNode = new Node(x);
            firstNode = lastNode;
        }else{
            Node temp = new Node(x);
            lastNode.setNextNode(temp);
            temp.setPreNode(lastNode);
            lastNode = temp;
        }
        size++;
    }
    public int pop_front(){
        if(empty() == 1){
            return -1;
        }else{
            size--;
            Node temp = firstNode;
            firstNode = firstNode.getNextNode();
            if(firstNode != null){
                firstNode.setPreNode(null);
            }
            return temp.getValue();
        }
    }
    public int pop_back(){
        if(empty() == 1){
            return -1;
        }else{
            size--;
            Node temp = lastNode;
            lastNode = lastNode.getPreNode();
            if(lastNode != null){
                lastNode.setNextNode(null);
            }
            return temp.getValue();
        }
    }
    public int size(){
        return size;
    }
    public int empty(){
        return (size == 0)? 1 : 0;
    }
    public int front(){
        return (empty() == 1)?-1:firstNode.getValue();
    }
    public int back(){
        return (empty() == 1)?-1:lastNode.getValue();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(empty() == 1){
            return "empty";
        }
        for(Node n = firstNode; n!=null; n= n.getNextNode()){
            sb.append(n.getValue()).append(' ');
        }
        return sb.toString();
    }
}
