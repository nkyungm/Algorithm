import java.util.*;
import java.io.*;
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

        // hashmap value순으로 정렬하기
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2) -> {
            return map.get(o2).compareTo(map.get(o1));
        });

        for(int key : keySet){
            String k = String.valueOf(key);
            k += " ";
            sb.append(k.repeat(map.get(key)));
        }
        System.out.println(sb);
    }
}
