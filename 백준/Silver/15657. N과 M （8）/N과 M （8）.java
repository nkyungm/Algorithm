import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static StringBuffer sb = new StringBuffer();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Combination(0, new int[M],0);
        System.out.println(sb);
    }
    static void Combination(int cnt,int[] selected,int s){
        if(cnt==M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }sb.append("\n");
            return;
        }
        for(int i=s;i<N;i++){
            selected[cnt] = arr[i];
            Combination(cnt+1,selected,i);
        }
    }
}
