import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Permutation(0,new int[M]);
        System.out.println(sb);
    }
    static void Permutation(int toSelect,int[] selected){
        if(toSelect == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            selected[toSelect] = i+1;
            Permutation(toSelect+1,selected);
        }
    }
}
