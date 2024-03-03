import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Solution
{
	    static int N;
    static int[][] map;
    static Node startDessert;
    static int maxAns;
    static int[] dx = {1,1,-1,-1}; //오른쪽 아래, 왼쪽 아래, 왼쪽 위,오른쪽 위
    static int[] dy = {1,-1,-1,1};
    static List<ArrayList<Integer>> directionArr;
    static class Node{
        int x,y,dessert,d;

        public Node(int x, int y, int dessert,int d) {
            this.x = x;
            this.y = y;
            this.dessert = dessert;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxAns = -1;
            directionArr = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 4; i++) {
                directionArr.add(new ArrayList<>());
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    directionArr.get(i).add(i+j);
                }
            }
            directionArr.get(3).add(3);

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    // 오른쪽 아래 시작
                    startDessert = new Node(i,j,map[i][j],0);
                    maxAns = Math.max(maxAns,DFS(startDessert,new ArrayList<>()));
                }
            }
            System.out.println("#"+(t+1)+" "+maxAns);
        }
    }
    static int DFS(Node n,List<Integer> dessertArr){
        dessertArr.add(map[n.x][n.y]); //디저트 넣기

        int MAX = -1;
        for(int d : directionArr.get(n.d)) {
            // n.d==2인 경우, 처음노드의 왼쪽 아래 대각선인 경우에만 d==3으로 가도록!
            // d==2로 계속 가도록 함
            if(n.d==2){
                boolean isCheck = false;
                int xi2 = startDessert.x;
                int yi2 = startDessert.y;
                for (int i = 0; i < N-startDessert.x; i++) {
                    xi2 += dx[1];
                    yi2 += dy[1];
                    if(xi2<0 || xi2 >=N || yi2 <0 ||yi2>=N) continue;
                    if(n.x == xi2 && n.y == yi2) isCheck = true;
                }
                if(!isCheck){
                    if(d==3) continue;
                }else{
                    if(d==2) continue;
                }
            }

            int xi = n.x + dx[d];
            int yi = n.y + dy[d];
            if (xi < 0 || xi >= N || yi < 0 || yi >= N) continue;

            //처음 startDessert 노드인 경우, 0 방향만 가도록 설정
            if (dessertArr.size() == 1 && (startDessert.x == xi && startDessert.y == yi)) {
                if(d==1) continue;
            }

            // 기저조건
            // list안에 최소 4개 이상이 있어야함!! 아니면 -1로 리턴하기
            if (dessertArr.size() > 1 && (startDessert.x == xi && startDessert.y == yi)) {
                if (dessertArr.size() >= 4) {
                    return dessertArr.size();
                }
            }

            // 같은 숫자의 디저트이면 넘어감
            if (dessertArr.contains(map[xi][yi])) continue;

            MAX = Math.max(MAX, DFS(new Node(xi, yi, map[xi][yi], d), dessertArr));

            //맨 마지막 인덱스의 값 빼냄
            dessertArr.remove(dessertArr.size() - 1);
        }
        return MAX;
    }
}