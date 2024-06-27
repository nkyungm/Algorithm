import java.util.*;
import java.lang.*;

// 알고리즘 : HashMap

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String,Long> map = new HashMap<>();
        HashMap<String,ArrayList<Music>> memo = new HashMap<>();
        
        for(int i=0;i<plays.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0L) + plays[i]);
            if(memo.containsKey(genres[i])) {
                memo.get(genres[i]).add(new Music(i,plays[i]));
            }else{
                ArrayList<Music> arr = new ArrayList<>();
                arr.add(new Music(i,plays[i]));
                memo.put(genres[i],arr);
            }
        }
        
        // 1. value값을 기준으로 HashMap 정렬
        // keySet : key만 받아오기
        List<String> keySet = new ArrayList<>(map.keySet());
        // 내림차순 정렬
        keySet.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1)));
        
        List<Integer> temp = new ArrayList<>();
        for(String key : keySet){
            List<Music> musicList = memo.get(key);
            Collections.sort(musicList);
            
            for(int i=0;i<musicList.size();i++){
                if(i==2) break;
                temp.add(musicList.get(i).idx);
            }
        }
        
        answer = temp.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
    static class Music implements Comparable<Music>{
        int idx,play;
        public Music(int idx,int play){
            this.idx = idx;
            this.play = play;
        }
        
        public int compareTo(Music m2){
            if(this.play == m2.play) return this.idx - m2.idx;
            return m2.play - this.play;
        }
    }
}