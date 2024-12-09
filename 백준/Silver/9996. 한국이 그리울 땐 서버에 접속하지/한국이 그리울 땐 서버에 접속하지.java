import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int star = 0;
        boolean flag;

        // 별 찾기
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != '*') continue;
            star = i;
            break;
        }

        for(int n =0;n<N;n++){
            String s1 = br.readLine();
            flag = true;

            // 처음 체크
            if(s1.length() < s.length()-1) flag = false;
            if(star >= s1.length()) flag = false;

            // 앞에서 부터
            if(flag){
                for(int i=0;i<star;i++){
                    if(s.charAt(i) == s1.charAt(i)) continue;
                    flag = false;
                    break;
                }
            }

            // 중간 체크
            if(flag){
                // 뒤에서 부터
                int j = s1.length()-1;
                for(int i=s.length()-1;i>star;i--){
                    if(s.charAt(i) == s1.charAt(j)){
                        j--;
                        continue;
                    }
                    flag = false;
                    break;
                }
            }

            if(flag) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }

        System.out.println(sb);
    }
}
