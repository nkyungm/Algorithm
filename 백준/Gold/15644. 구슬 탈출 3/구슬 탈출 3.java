import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][][][] visited; //방문처리 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Bead R,B;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[10][10][10][10];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                // 빨간 구슬 저장
                if (map[i][j] == 'R') {
                    R = new Bead(i, j);
                }
                // 파란 구술 저장
                else if (map[i][j] == 'B') {
                    B = new Bead(i, j);
                }
            }
        }
        int ans = BFS(new Beads(R,B,0,""));
        System.out.println(sb);
    }
    static int BFS(Beads beads){
        Queue<Beads> queue = new ArrayDeque<>();
        queue.add(beads);

        while(!queue.isEmpty()){
            Beads next = queue.poll();

            Bead r = next.R;
            Bead b = next.B;

            //방문 처리
            visited[r.x][r.y][b.x][b.y] = true;

            //종료 조건) 움직이는 횟수가 10 초과한 경우
            //BFS의 경우, 순차적으로 탐색하기 때문에 뒤에 10보다 적은 수가
            // 있을 수 없음!!
            if(next.cnt >= 10) {
                sb.append(-1);
                return -1;
            }

            // 반복
            for (int i = 0; i < 4; i++) {
                String log = next.nLong;

                // 1, 파란색 구슬 먼저 굴리기
                Bead moveB = goB(i,b.x,b.y);

                // 2. 빨간색 구슬 굴리기
                Bead moveR = goR(i,r.x,r.y);

                // 방향 로그 저장
                if(i==0) log+="U";
                else if(i==1) log+="D";
                else if(i==2) log+="L";
                else log+="R";

                // 파란색 구슬이 빠졌다면 continue
                if(map[moveB.x][moveB.y] == 'O') continue;

                // 빨간색 구슬만 빠진경우 -> return
                if(map[moveR.x][moveR.y] == 'O'){
                    sb.append(next.cnt+1).append("\n");
                    sb.append(log);
                    return next.cnt+1;
                }


                // 2. 방향 별로 R,B가 같은 선상에 있는지 확인
                if(moveR.x == moveB.x && moveR.y == moveB.y){
                    int[] check = check(i, r, b);
                    if(check[0] == 0){ //R 좌표 변경
                        moveR.x += dx[check[1]];
                        moveR.y += dy[check[1]];
                    }else{
                        moveB.x += dx[check[1]];
                        moveB.y += dy[check[1]];
                    }
                }

                if(visited[moveR.x][moveR.y][moveB.x][moveB.y]) continue;

                //큐에 넣기
                queue.add(new Beads(moveR,moveB, next.cnt+1,log));
            }
        }
        sb.append(-1);
        return -1;
    }
    //R 구슬 굴리기
    static Bead goR(int d,int dxR,int dyR){
        // 종료 조건
        while(map[dxR+dx[d]][dyR+dy[d]] != '#'){
            //이동하기
            dxR += dx[d];
            dyR += dy[d];

            //구멍을 만난 경우
            if(map[dxR][dyR] == 'O') {
                break;
            }
        }
        return new Bead(dxR,dyR);
    }

    //B 구슬 굴리기
    static Bead goB(int d,int dxB,int dyB){
        // 종료 조건
        while(map[dxB+dx[d]][dyB+dy[d]] != '#'){
            //이동하기
            dxB += dx[d];
            dyB += dy[d];

            //구멍을 만난 경우
            if(map[dxB][dyB] == 'O') {
                break;
            }
        }
        return new Bead(dxB,dyB);
    }

    // R과 B가 같은 선상에 있는지 확인
    static int[] check(int d,Bead R,Bead B){
        //2번째는 좌표기준임
        if(d==0){ //상
            return (R.x > B.x)? new int[]{0,1}:new int[]{1,1}; //R이 더 앞이면 0, B가 앞이면 1
        }else if(d==1){ //하
            return (R.x < B.x)? new int[]{0,0}:new int[]{1,0}; //R이 더 앞이면 0, B가 앞이면 1
        }else if(d==2){ //좌
            return (R.y > B.y)? new int[]{0,3}:new int[]{1,3}; //R이 더 앞이면 0, B가 앞이면 1
        }else{ //우
            return (R.y < B.y)? new int[]{0,2}:new int[]{1,2}; //R이 더 앞이면 0, B가 앞이면 1
        }
    }
    static class Beads{
        Bead R,B;
        int cnt;
        String nLong;

        public Beads( Bead r, Bead b, int cnt,String nLong) {
            R = r;
            B = b;
            this.cnt = cnt;
            this.nLong = nLong;
        }
    }
    static class Bead{
        int x,y;

        public Bead(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
