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

        int ans = BFS();
        System.out.println(ans);

    }
    private static int BFS(){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start,0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int[] v = queue.poll();
            if(v[0] == end) return v[1];

            for(int i=1;i<=N;i++){
                if(arr[v[0]][i] && !visited[i]){
                    visited[i] = true;
                    queue.add(new int[]{i,v[1]+1});
                }
            }
        }
        return -1;
    }
}
