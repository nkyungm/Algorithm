import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int[] arr;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        set = new HashSet<>();
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        makePermutation(0,new int[K], new boolean[N]);
        System.out.println(set.size());
    }
    // 순열
    static void makePermutation(int toSelect,int[] selected,boolean[] visited){
        if(toSelect == K){
            // int[] 배열 int 하나로 합치기
            // 1. String으로 변환
            String s = "";
            for(int j=0;j<K;j++) s += selected[j];
            set.add(Integer.parseInt(s));
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                selected[toSelect] = arr[i];
                visited[i] = true;
                makePermutation(toSelect+1,selected,visited);
                // 백트래킹
                visited[i] = false;
            }

        }

    }
}
