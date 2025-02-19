import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = BFS(begin,target,words);
        // 최단 변화수 : BFS
        // 1. queue에 넣고 words 처음에 돌리면서 1개만 다른 경우 큐에 넣고 방문처리
        // 2. queue값중에 cog가 있으면 종료
        // 3. queue는 int[] 저장
        
        return answer;
    }
    static int BFS(String begin,String target,String[] words){
        Queue<Word> queue= new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new Word(begin,0));
        
        while(!queue.isEmpty()){
            Word v = queue.poll();
            
            // 종료조건
            if(v.s.equals(target)) return v.num;
            
            for(int i=0;i<words.length;i++){
                if(visited[i]) continue;
                // 한개만 다른지 확인
                if(!diff(v.s,words[i])) continue;
                visited[i] = true;
                queue.add(new Word(words[i],v.num+1));
            }
        }
        return 0;
    }
    static boolean diff(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        int n = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i)) continue;
            else {
                n++;
                if(n >=2) return false;
            }
        }
        return true;
    }
    static class Word{
        String s;
        int num;
        
        public Word(String s,int num){
            this.s = s;
            this.num = num;
        }
    }
}