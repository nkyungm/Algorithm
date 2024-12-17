import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key,map.getOrDefault(key,0)+1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for(int key : keySet){
            for(int i=0;i<map.get(key);i++){
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb);
    }
}
