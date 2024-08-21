import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
        int cnt = 0;

        // 연결 리스트 만들기
        LinkedList<Integer> list = new LinkedList<>();
        // 1~N까지의 값 넣기
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        // 요소를 다 뽑아낼때 까지 반복
        int idx =0;
        sb.append("<");
        while(cnt != N){
            cnt++;
            idx = (idx+K)%list.size();
            sb.append(list.get(idx));
            if(cnt!=N) sb.append(", ");
            list.remove(idx);
        }
        sb.append(">");
        System.out.println(sb);
    }

}
