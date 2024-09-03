import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static boolean[][] graph;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static List<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new boolean[N][N];
        visited = new boolean[N][N];
        queue = new ArrayDeque<>();
        list = new ArrayList<>();

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                int c = s.charAt(j);
                graph[i][j] = c=='0'? false:true;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!graph[i][j] || visited[i][j]) continue;
                queue.add(new int[]{i,j});
                visited[i][j] = true;
                bfs();
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    static void bfs(){
        int cnt = 1;
        while(!queue.isEmpty()){
            int[] v =queue.poll();
            for(int i=0;i<4;i++){
                int xi = v[0] + dx[i];
                int yi = v[1] + dy[i];
                if(xi<0 || xi>=N || yi<0 || yi>=N) continue;
                if(!graph[xi][yi] || visited[xi][yi]) continue;
                queue.add(new int[]{xi,yi});
                visited[xi][yi] = true;
                cnt++;
            }
        }
        list.add(cnt);
    }
}
