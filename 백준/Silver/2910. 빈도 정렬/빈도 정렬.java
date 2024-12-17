import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> idxMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int key = Integer.parseInt(st.nextToken());
            // 처음 hashMap에 들어가는 경우 idxMap에 idx 저장
            if(!map.containsKey(key)) idxMap.put(key,i);
            map.put(key,map.getOrDefault(key,0)+1);
        }

        // hashmap value순으로 정렬하기
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2) -> {
            // value가 같으면 idxMap의 value값이 작은 순서대로 정렬
            if(map.get(o1) == map.get(o2)){
                return idxMap.get(o1).compareTo(idxMap.get(o2));
            }
            return map.get(o2).compareTo(map.get(o1));
        });

        for(int key : keySet){
            for(int i = 0;i<map.get(key);i++){
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb);
    }
}
