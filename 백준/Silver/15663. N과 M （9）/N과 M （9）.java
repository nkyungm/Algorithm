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
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Permutation(0, new int[M],new boolean[N]);
        System.out.println(sb);
    }
    static void Permutation(int cnt,int[] selected,boolean[] visited){
        if(cnt == M){
            // selected를 string으로 변환해서 hashSet에 넣고 중복 제거
            StringBuilder s = new StringBuilder();
            for(int i=0;i<M;i++){
                s.append(selected[i]).append(" ");
            }
            if(!set.contains(s.toString())){
                set.add(s.toString());
                for(int i=0;i<M;i++){
                    sb.append(selected[i]).append(" ");
                }sb.append("\n");
            }
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = arr[i];
                Permutation(cnt+1,selected,visited);
                visited[i] = false;
            }
        }
    }
}
