package baekjoon;

import java.io.IOException;

public class P2941 {
    public static void main(String[] args) throws IOException{
        // c= c-
        // dz= d-
        // lj
        // nj
        // s=
        // z=
        char ch=(char)System.in.read();
        int word = 0;
        
        while(ch != '\n' && ch != '\r'){
            switch(ch){
                case 'c':
                word ++;
                ch=(char)System.in.read();
                if(ch == '=' || ch == '-'){
                    ch=(char)System.in.read();
                }
                break;
                case 'd':
                word ++;
                ch=(char)System.in.read();
                if(ch == '-'){
                    ch=(char)System.in.read();
                }else if(ch == 'z'){
                    ch=(char)System.in.read();
                    if(ch == '='){
                        ch=(char)System.in.read();
                    }else{
                        word+=1;
                    }
                }
                break;
                case 'l':
                word ++;
                ch=(char)System.in.read();
                if(ch == 'j'){
                    ch=(char)System.in.read();
                }
                break;
                case 'n':
                word++;
                ch=(char)System.in.read();
                if(ch == 'j'){
                    ch=(char)System.in.read();
                }
                break;
                case 's':
                word++;
                ch=(char)System.in.read();
                if(ch == '='){
                    ch=(char)System.in.read();
                }
                break;
                case 'z':
                word++;
                ch=(char)System.in.read();
                if(ch == '='){
                    ch=(char)System.in.read();
                }
                break;
                default:
                word++;
                ch=(char)System.in.read();
                break;
            }
        }
        System.out.println(word);
    }
}
