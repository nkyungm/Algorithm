import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Permutation(0,new int[M],new boolean[N]);
        System.out.println(sb);
    }
    static void Permutation(int toSelect,int[] selected,boolean[] visited){
        if(toSelect == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                selected[toSelect] = i+1;
                Permutation(toSelect+1,selected,visited);
                visited[i] = false;
            }
        }
    }
}
