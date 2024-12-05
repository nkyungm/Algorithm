import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String s=  br.readLine();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                int num = ((c - (int)'A')+13)%26;
                c = (char) (num+(int)'A');
            }else if(Character.isLowerCase(c)){
                int num = ((c - (int)'a')+13)%26;
                c = (char) (num+(int)'a');
            }
            sb.append(c);
        }

        System.out.println(sb);
    }
}
