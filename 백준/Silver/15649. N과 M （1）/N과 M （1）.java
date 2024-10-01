import java.util.*;
import java.io.*;
// 순열
// permutation(int cnt,int[] selected,boolean[] visited)
public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        permutation(0,new int[M],new boolean[N]);
        System.out.println(sb);
    }
    static void permutation(int cnt,int[] selected,boolean[] visited){
        if(cnt == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]+1).append(" ");
            }sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = i;
                permutation(cnt+1,selected,visited);
                visited[i] = false;
            }
        }
    }
}
