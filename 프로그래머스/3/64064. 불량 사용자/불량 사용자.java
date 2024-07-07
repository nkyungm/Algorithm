import java.util.*;
import java.util.stream.*;

// 알고리즘 : 

// 1. arrayList 2차원 배열 생성
// 2. 같은 것의 index 넣기
// 3. 조합을 통해 경우의 수 구하기
// 주의 ) 겹칠 수도 있음
// 동일하면 같은 곳으로 처리
/*
*rodo : 0,2
*rodo : 0,2

****** : 3,4
(0,2,3),(0,2,4)

*/
class Solution {
    static ArrayList<Integer>[] arr;
    static int banned_size;
    static boolean[] visited;
    static Set<List<Integer>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        banned_size = banned_id.length;
        int user_size = user_id.length;
        visited = new boolean[user_size];
        
        // 1. arrayList 2차원 배열 생성
        arr = new ArrayList[banned_size];
        for(int i=0;i<banned_size;i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        // 2. 같은것 넣기 
        bannList(banned_id,user_id);
        
        // 3. 순열 통해 수 구하기
        go(0,new boolean[user_size],new int[banned_size]);
        
        answer = set.size();
        
        return answer;
    }
    static void go(int cnt,boolean[] visited,int[] arr2){
        if(cnt == banned_size){
            List<Integer> list = Arrays.stream(arr2).boxed().collect(Collectors.toList());
            Collections.sort(list);
            set.add(list);
            return;
        }
        for(int i=0;i<arr[cnt].size();i++){
            int id = arr[cnt].get(i);
            if(visited[id]) continue;
            visited[id] = true;
            arr2[cnt] = id;
            go(cnt+1,visited,arr2);
            visited[id] = false;
        }
    }
    static void bannList(String[] banned_id,String[] user_id ){
        for(int i=0;i<banned_id.length;i++){
            String bann_id = banned_id[i];
            for(int j=0;j<user_id.length;j++){
                String u_id = user_id[j];
                boolean flag = true;
                if(bann_id.length()!=u_id.length()) continue; // 길이 다르면 continue
                for(int k=0;k<bann_id.length();k++){ // 하나씩 비교하면서 * continue
                    if(bann_id.charAt(k) == '*') continue;
                    if(bann_id.charAt(k)!= u_id.charAt(k)) {
                        flag = false;
                        break; // 다르면 바로 중단
                    }
                } 
                if(flag) arr[i].add(j);
                flag = true;
            }
        }
    }
}