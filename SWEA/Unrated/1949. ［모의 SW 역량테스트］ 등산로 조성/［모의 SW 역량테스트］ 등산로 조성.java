import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	static int N,K;
    static int[][] map;
    static List<Node> arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ansMAX = Integer.MIN_VALUE;
    static class Node{
        int x,y,d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            arr = new ArrayList<>();
            int maxValue = 0;
            ansMAX = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxValue = Math.max(maxValue,map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(maxValue == map[i][j]) arr.add(new Node(i,j,1));
                }
            }

            for (int i = 0; i < arr.size(); i++) {
                ansMAX= Math.max(ansMAX,DFS(arr.get(i),false,new boolean[N][N]));
            }

            System.out.println("#"+(t+1)+" "+ansMAX);
        }
    }
    static int DFS(Node n,boolean k,boolean[][] visited){
        visited[n.x][n.y] = true;

        int MAX = n.d;
        for (int i = 0; i < 4; i++) {
            int xi = n.x + dx[i];
            int yi = n.y + dy[i];
            if(xi <0 || xi >= N || yi <0 || yi>=N ) continue;
            if(visited[xi][yi]) continue;
            if(map[n.x][n.y] < map[xi][yi]) {
                if(k) continue;
                if(map[xi][yi]-K >= map[n.x][n.y]) continue;
                //K 쓰는 경우
                int value = map[xi][yi];
                map[xi][yi] = map[n.x][n.y]-1;
                k = true;
                MAX = Math.max(MAX,DFS(new Node(xi,yi,n.d+1),k,visited));
                map[xi][yi] = value;
                k = false;
                visited[xi][yi] = false;
            }
            // 지형 깎는 경우
            else if(map[n.x][n.y] == map[xi][yi]){
                // k를 이미 쓴 경우
                if(k) continue;
                //K 쓰는 경우
                map[xi][yi]--;
                k = true;
                MAX = Math.max(MAX,DFS(new Node(xi,yi,n.d+1),k,visited));
                map[xi][yi]++;
                k = false;
                visited[xi][yi] = false;

            }else{
                MAX = Math.max(MAX,DFS(new Node(xi,yi,n.d+1),k,visited));
                visited[xi][yi] = false;
            }
        }
        return MAX;
    }
}