import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals("end")) break;
            char[] arr = s.toCharArray();
            // set에 모음 넣기
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            // 모음 확인 변수
            boolean flag = false;
            boolean end = false;
            // 연속 모음, 자음 확인 변수
            int mo=0, ja = 0;

            for(int i=0;i<arr.length;i++){
                //1번 조건 & 2번 조건
                if(set.contains(arr[i])) {
                    flag = true;
                    mo++;
                    ja = 0;
                } else{
                    ja++;
                    mo=0;
                }
                if(mo == 3 || ja == 3){
                    end = true;
                    break;
                }
                // 3번 조건
                if(i==arr.length-1 || arr[i] == 'e' || arr[i] =='o') continue;
                if(arr[i] != arr[i+1]) continue;
                end = true;
                break;
            }
            // 1번 종료 조건
            if(!flag) end = true;
            if(!end) sb.append("<").append(s).append("> is acceptable.\n");
            else sb.append("<").append(s).append("> is not acceptable.\n");
        }
        System.out.println(sb);
    }
}
