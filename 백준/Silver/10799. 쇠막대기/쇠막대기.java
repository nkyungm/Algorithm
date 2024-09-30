import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        int leftCnt = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // 1. ( 인 경우 -> +1
            if(c == '(') leftCnt++;
            else{
                // 2. ) 인데 바로 앞에 (인경우 -> leftCnt--하고 answer에 추가
                if(s.charAt(i-1) == '('){
                    leftCnt--;
                    answer += leftCnt;
                }else{
                    answer++;
                    leftCnt--;
                }
            }
        }
        System.out.println(answer);
    }
}
