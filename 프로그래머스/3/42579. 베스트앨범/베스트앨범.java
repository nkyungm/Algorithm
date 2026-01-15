import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        // map으로 장르별 재생횟수 저장
        HashMap<String,Integer> map = new HashMap<>();
        // 장르별 고유번호도 해시맵으로 저장
        HashMap<String,List<Music>> map2 = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            String genre = genres[i];
            int play = plays[i];
            map.put(genre,map.getOrDefault(genre,0)+play);
            // 리스트로 넣는 방법
            map2.computeIfAbsent(genre,g->new ArrayList<>())
                .add(new Music(i,play));
        }
        
        // 장르 재생횟수별 내림차순 정렬
        List<Map.Entry<String,Integer>> list 
            = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        // 장르별 노래 내림차순 정렬
        for(Map.Entry<String,Integer> entry: list){
            String genre = entry.getKey();
            List<Music> mList = map2.get(genre);
            mList.sort((x1,x2) -> {
                if(x1.cnt == x2.cnt){
                    return x1.idx - x2.idx; 
                }
                return x2.cnt - x1.cnt;
            });
            for(int i=0;i<Math.min(2,mList.size());i++){
                answer.add(mList.get(i).idx);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    class Music{
        int idx;
        int cnt;
        
        Music(int idx,int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}