import java.util.*;
import java.io.*;
public class Main {
    static int cnt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            // hash map사용해서 저장하면서 있으면 key값으로 넣고 아니면 hashMap에 저장한 다음 넣기
            HashMap<String,Integer> map = new HashMap<>();
            for(int n=0;n<N;n++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                map.put(key,map.getOrDefault(key,0)+1);
            }
            cnt = 1;
            // map별로 value +1 을 cnt에 곱하기
            for(String key: map.keySet()){
                cnt *= (map.get(key)+1);
            }
            cnt--;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

