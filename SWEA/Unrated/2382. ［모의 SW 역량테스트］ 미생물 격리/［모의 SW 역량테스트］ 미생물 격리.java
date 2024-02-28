import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Solution
{
	    static int N,M,K;
    static int[][] graph;
    static List<Node> arr;
    static int[] dx= {0,-1,1,0,0}; //상,하,좌,우
    static int[] dy= {0,0,0,-1,1};
    static class Node implements Comparable<Node>{
        int x,y,cnt,d;

        public Node(int x, int y, int cnt, int d) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            // 행 -> 열순으로 오름차순
            if(this.x == o.x) return this.y-o.y;
            return this.x - o.x;
        }

        // 좌표 같을 경우 체크
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //가로세로
            M = Integer.parseInt(st.nextToken()); //종료시간
            K = Integer.parseInt(st.nextToken()); //미생물 군집 개수

            graph = new int[N][N];
            arr = new ArrayList<>();
            // 1. 최초 미생물 저장
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                arr.add(new Node(x,y,cnt,d));
            }

            for (int i = 0; i < M; i++) {
                // 미생물이 없는 경우 종료 조건 추가해주기
                if(arr.size() ==0) break;
                Collections.sort(arr);
                moveMicrobe();
            }
            int totalCnt = 0;
            for(Node m : arr){
                totalCnt+=m.cnt;
            }
            sb.append("#").append(t+1).append(" ").append(totalCnt).append("\n");
        }
        System.out.println(sb);
    }
    static void moveMicrobe(){
        List<Node> tempArr = new ArrayList<>();
        Set<Node> duplicationArr = new HashSet<Node>();
        // 이동방향이 있는 다음 셀로 좌표 이동
        for (int i = 0; i < arr.size(); i++) {
            Node n = arr.get(i);
            // 이동방향따라 좌표 이동
            Node v = new Node(n.x+dx[n.d],n.y+dy[n.d],n.cnt,n.d);
            // 1. 약품 칠해진 셀인 경우 -> 미생물수/2, 이동방향 반대로
            if(n.x+dx[n.d] ==0 || n.x+dx[n.d] == N-1 || n.y+dy[n.d] == 0 || n.y+dy[n.d]==N-1) {
                if (n.cnt == 1) continue; //군집 미생물 1이면 군집 사라짐!
                int direction = n.d;
                // 이동방향 반대로
                if (n.d % 2 == 0) direction--;
                else direction++;
                v = new Node(n.x + dx[n.d], n.y + dy[n.d], n.cnt / 2, direction);
            }else if(tempArr.contains(v)) {
                // 이동방향 v랑 mi 비교하면 안되고 각각 비교해야함!! (합친거 비교하면 안됨)
                duplicationArr.add(new Node(v.x,v.y,0,0));

                // 2) 그대로 tempArr에 넣어줌!
            }
            // 그냥 이동하는 경우
            tempArr.add(v);
        }

        Collections.sort(tempArr);

        // 중복 체크
        Iterator iter = duplicationArr.iterator();	// Iterator 사용
        while(iter.hasNext()) {//값이 있으면 true 없으면 false
            Node n = (Node) iter.next();
            List<Integer> idxList = new ArrayList<>();
            int cntSum = 0;
            for (int i = 0; i < tempArr.size(); i++) {
                if(tempArr.get(i).x == n.x && tempArr.get(i).y == n.y){
                    idxList.add(i);
                    cntSum+=tempArr.get(i).cnt;
                }
            }
            int maxIdx = 0;
            for (int i = 1; i < idxList.size(); i++) {
                maxIdx = (tempArr.get(idxList.get(i)).cnt > tempArr.get(idxList.get(maxIdx)).cnt) ? i : maxIdx;
            }
            int direction = tempArr.get(idxList.get(maxIdx)).d;
            for (int i = 0; i < idxList.size(); i++) {
                tempArr.remove(n);
            }
            tempArr.add(new Node(n.x,n.y,cntSum,direction));
        }
        // 2. 2개 이상의 군집이 한 셀에 모이는 경우 -> 군집 합침(cnt:미생물총합, 이동방향:미생물 수 제일 많은 군집 이동방향)

        Collections.sort(tempArr);
        arr = tempArr;

        // System.out.println(arr.toString());
    }
}