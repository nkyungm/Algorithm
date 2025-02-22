import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
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

        Permutation(0, new int[M],0);
        System.out.println(sb);
    }
    static void Permutation(int cnt,int[] selected,int selectNum){
        if(cnt == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(" ");
            }sb.append("\n");
            return;
        }
        int duplication = 0;
        for(int i=selectNum;i<N;i++){
            if(duplication == arr[i]) continue;
            selected[cnt] = arr[i];
            Permutation(cnt+1,selected,i+1);
            duplication = arr[i];

        }
    }
}
