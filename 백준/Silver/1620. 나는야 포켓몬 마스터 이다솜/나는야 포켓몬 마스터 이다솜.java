import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer,String> map = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        for(int i=1;i<=N;i++) {
            String name = br.readLine();
            map.put(i,name);
            map2.put(name,i);
        }

        for(int i=0;i<M;i++){
            String s = br.readLine();
            // 숫자일 경우
            if(Character.isDigit(s.charAt(0))){
                sb.append(map.get(Integer.parseInt(s))).append("\n");
            }
            // 문자일 경우
            else sb.append(map2.get(s)).append("\n");
        }

        System.out.println(sb);
    }
}
