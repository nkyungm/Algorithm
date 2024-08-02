import java.util.*;
/**
구현문제
1. 
*/

class Solution {
    static int L;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        L = numbers.length();
        
        for(int i=1;i<=L;i++){
            Permutation(i,0,new char[i],new boolean[L],numbers);
        }
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            if(search(iter.next())) answer++;
        }
        
        return answer;
    }
    // 순열
    static void Permutation(int M,int selected,char[] arr,
                            boolean[] visited,String numbers){
        if(selected == M){
            String s="";
            for(int i=0;i<M;i++){
                s += arr[i];
            }
            if(s != "") set.add(Integer.parseInt(s));
            return;
        }
        for(int i=0;i<L;i++){
            if(!visited[i]){
                arr[selected] = numbers.charAt(i);
                visited[i] = true;
                Permutation(M,selected+1,arr,visited,numbers);
                visited[i] = false;
            }
        }
    }
    static boolean search(int N){
        if(N <=1) return false;
        for(int i=2;i<=N/2;i++){
            if(N%i==0) return false;
        }
        return true;
    }
}