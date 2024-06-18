import java.util.*;

// 알고리즘 : BFS(도달하는 최소값 찾기)
/*
- visited 방문처리 필요
- queue에 배열값 넣기([0]: string, [1]: int)
1. 처음 words에서 target값이 있는 지 확인하고 없으면 return 0
2. begin에서 words for문 돌아가면서 방문X and 알파벳 한개만 다르면 queue에 넣기
3. queue에서 빼면서 target값과 동일하면 return
*/

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin,target,words);
        return answer;
    }
    static int bfs(String begin, String target,String[] words){
        Queue<Word> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length]; // 방문처리 함수
        
        queue.add(new Word(begin,0));
        while(!queue.isEmpty()){
            Word w = queue.poll();
            if(w.s.equals(target)) {
                return w.cnt;
            }
            
            for(int i=0;i<words.length;i++){
                if(visited[i]) continue;
                // 해당 단어와 알파벳 한개만 다른지 확인
                if(!diffCnt(w.s,words[i])) continue;
                visited[i] = true;
                queue.add(new Word(words[i],w.cnt+1));
            }
        }
        
        return 0;
    }
    // 알파벳별 다른 개수 확인
    static boolean diffCnt(String target,String word){
        int cnt = 0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)!=word.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        if(cnt ==0) return false;
        return true;
    }
    static class Word{
        String s;
        int cnt;
        public Word(String s,int cnt){
            this.s = s;
            this.cnt = cnt;
        }
    }
}