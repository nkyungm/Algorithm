import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = null;

        int N = Integer.parseInt(st.nextToken());
        List<Long> list = new ArrayList<>();

        int len = st.countTokens();
        for(int i=0;i<len;i++){
            String s = st.nextToken();
            // 반대로 돌리기
            sb = new StringBuilder();
            for(int j=s.length()-1;j>=0;j--) sb.append(s.charAt(j));
            list.add(Long.parseLong(sb.toString()));
        }

        while(list.size() < N){
            st = new StringTokenizer(br.readLine());
            len = st.countTokens();
            for(int i=0;i<len;i++){
                String s = st.nextToken();
                // 반대로 돌리기
                sb = new StringBuilder();
                for(int j=s.length()-1;j>=0;j--) sb.append(s.charAt(j));
                list.add(Long.parseLong(sb.toString()));
            }
        }
        Collections.sort(list);
        sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
