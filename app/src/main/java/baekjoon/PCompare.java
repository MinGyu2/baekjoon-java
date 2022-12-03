package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PCompare {
    public static void main(String[] args) throws IOException{
        InputStream input1 = new FileInputStream("C:\\Users\\mq2022\\Desktop\\t1.txt");
        InputStream input2 = new FileInputStream("C:\\Users\\mq2022\\Desktop\\t2.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(input1));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(input2));
        int tcnt = 0;
        int fcnt = 0;
        while(true){
            String s1 = br1.readLine();
            String s2 = br2.readLine();
            if(s1 == null || s2 == null) break;
            if(s1.compareTo(s2) == 0){
                System.out.println("true");
                tcnt++;
            }else{
                System.out.println("false");
                fcnt++;
            }
        }
        System.out.println(tcnt);
        System.out.println(fcnt);
        br1.close();
        br2.close();
    }
}
