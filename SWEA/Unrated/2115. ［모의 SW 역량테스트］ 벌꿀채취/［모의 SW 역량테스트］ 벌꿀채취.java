import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Solution
{
	static int N,M,C;
    static int[][] map;
    static int MAX = 0;
    static Queue<Node> pq = new PriorityQueue<>();
    static class Node implements Comparable<Node>{
        int x,y,honey;

        public Node(int x, int y, int honey) {
            this.x = x;
            this.y = y;
            this.honey = honey;
        }

        @Override
        public int compareTo(Node o) {
            // 내림차순
            return o.honey - this.honey;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", honey=" + honey +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); //벌통 개수
            C = Integer.parseInt(st.nextToken()); //채취 꿀 최대 양
            MAX = 0;
            map = new int[N][N];
            pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                getHoney(i); //행별로 탐색하면서 큐에 넣기
            }

            // 최대 값 빼주기
            Node firstValue = pq.poll();

            while(!pq.isEmpty()){
                Node secondValue = pq.poll();
                if(firstValue.x == secondValue.x){
                    if(firstValue.y + M > secondValue.y) continue;
                }
                MAX = firstValue.honey + secondValue.honey;
                break;
            }
            System.out.println("#"+(t+1)+" "+MAX);
        }
    }
    static void getHoney(int i){
        for (int j = 0; j <= N-M; j++) {
            List<Integer> arr= new ArrayList<>();
            for (int k = 0; k < M; k++) {
                arr.add(map[i][j+k]);
            }

            // arr의 채취 수익 계산
            pq.add(new Node(i,j,calculate(arr)));
        }
    }
    static int calculate(List<Integer> arr){
        // 내림차순 정렬
        Collections.sort(arr,Collections.reverseOrder());
        // C되는 것 최대 경우의 수 찾기
        int cValue = C;
        int honey = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            cValue = C; honey = 0;
            for (int j = i; j < arr.size(); j++) {
                if(cValue < arr.get(j)) continue;
                honey += (arr.get(j) * arr.get(j));
                cValue -= arr.get(j);
            }
            max= Math.max(max,honey);
        }
        return max;
    }
}