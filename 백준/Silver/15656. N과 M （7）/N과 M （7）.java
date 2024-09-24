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

        Permutation(0, new int[M], new boolean[N]);
        System.out.println(sb);
    }
    static void Permutation(int cnt,int[] selected,boolean[] visited){
        if(cnt == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            visited[i] = true;
            selected[cnt] = arr[i];
            Permutation(cnt+1,selected,visited);
            visited[i] = false;
        }
    }

}
