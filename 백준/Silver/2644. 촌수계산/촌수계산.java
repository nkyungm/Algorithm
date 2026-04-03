import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[][] arr;
    static boolean[] visited;
    static int start;
    static int end;
    public static void main(String[] args) throws Exception{
        // BFS, DFS
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());
        for(int i=0;i<cnt;i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            arr[p1][p2] = true;
            arr[p2][p1] = true;
        }
        int ans = DFS(start,0);
        System.out.println(ans);

    }
    private static int DFS(int v, int consu){
        visited[v] = true;
        if(v == end) return consu;

        for(int i=1;i<=N;i++){
            if(arr[v][i] && !visited[i]){
                // 값 저장 필요 : 저장하지 않으면 호출한 상위 함수 결과 모름
                int result = DFS(i,consu+1);
                if(result != -1){
                    return result;
                }
            }
        }
        return -1;
    }
}
