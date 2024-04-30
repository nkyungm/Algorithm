import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static char[][] map2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Bead R,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        map2 = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                map2[i][j] = map[i][j];
                // 빨간 구슬 저장
                if(map[i][j] == 'R') {
                    R = new Bead(i,j);
                    map2[i][j] = '.';
                }
                // 파란 구술 저장
                else if(map[i][j] == 'B') {
                    B = new Bead(i,j);
                    map2[i][j] = '.';
                }
            }
        }
        int ans = BFS(new Beads(R,B,0));
        System.out.println(ans);
    }
    static int BFS(Beads beads){
        Queue<Beads> queue = new ArrayDeque<>();
        queue.add(beads);

        while(!queue.isEmpty()){
            Beads next = queue.poll();

            Bead r = next.R;
            Bead b = next.B;

            // 반복
            for (int i = 0; i < 4; i++) {
                map2[r.x][r.y] = 'R';
                map2[b.x][b.y] = 'B';

                int dxR = r.x + dx[i];
                int dyR = r.y + dy[i];

                // 상하좌우 이동할 수 있는지 확인
                // R과 B 둘다 이동할 수 없으면 continue

                // 1. 방향 별로 R,B가 같은 선상에 있는지 확인
                int checkNum = check(i, r, b);
                Bead moveR = r;
                Bead moveB = b;


                // R먼저 실행
                if(checkNum ==0){
                    // R 먼저 실행
                    moveR = goR(i,dxR,dyR);
                    if(moveR.x != -1) {
                        if(moveR.x!= r.x || moveR.y != r.y) swap(r,moveR,'R');
                    }else{
                        map2[r.x][r.y] = '.';
                    }
                    //B 실행
                    if(b.x+dx[i] <0 || b.x+dx[i] >=N || b.y+dy[i] <0 || b.y+dy[i] >=M) {
                        moveB = b;
                    }else{
                        moveB = goB(i,b.x+dx[i],b.y+dy[i]);
                        if(moveB.x != -1){
                            if(moveB.x != b.x || moveB.y!= b.y) swap(b,moveB,'B');
                        }else map2[b.x][b.y] = '.';
                    }

                    // 종료 조건
                    if(moveR.x == -1) {
                        if(moveB.x != -1) return next.cnt+1;
                    }

                }else{ //B먼저 실행(이 로직이 중요!!)
                    if(b.x+dx[i] <0 || b.x+dx[i] >=N || b.y+dy[i] <0 || b.y+dy[i] >=M
                            || map2[b.x+dx[i]][b.y+dy[i]]=='#') {
                        moveB = b;
                    }else{
                        moveB = goB(i,b.x+dx[i],b.y+dy[i]);
                        //B가 먼저 구멍에 들어가는 경우!! -> 그래프 변경없이 다음으로 넘어가야함
                    }

                    if(moveB.x != -1){
                        if(moveB.x != b.x || moveB.y!= b.y){
                            swap(b,moveB,'B');
                        }

                        //R 실행
                        moveR = goR(i,dxR,dyR);
                        if(moveR.x != -1){
                            if(moveR.x!= r.x || moveR.y != r.y) {
                                swap(r,moveR,'R');
                            }
                        }else{
                            map2[r.x][r.y] = '.';
                            return next.cnt+1;
                        }
                    }else map2[b.x][b.y] = '.';
                }

                //map2 지우기
                if(moveR.x != -1){
                    map2[moveR.x][moveR.y] = '.';
                }
                if(moveB.x != -1){
                    map2[moveB.x][moveB.y] = '.';
                }
                if(moveB.x == -1) continue;
                //종료 조건 1) 움직이는 횟수가 10 초과한 경우
                if(next.cnt+1 == 10) continue;

                //큐에 넣기
                queue.add(new Beads(moveR,moveB, next.cnt+1));
            }
        }
        return -1;
    }
    //R 구슬 굴리기
    static Bead goR(int d,int dxR,int dyR){
        while(true){
            //종료 조건
            if(map2[dxR][dyR] == '#' || map2[dxR][dyR] == 'B') {
                return new Bead(dxR-dx[d],dyR-dy[d]);
            }
            //구멍을 만난 경우
            if(map2[dxR][dyR] == 'O') {
                return new Bead(-1,-1);
            }

            if(dxR + dx[d] <0 || dxR + dx[d]>=N || dyR + dy[d] <0 || dyR + dy[d] >=M)  {
                return new Bead(dxR,dyR);
            }
            //이동하기
            dxR += dx[d];
            dyR += dy[d];
        }
    }
    //B 구슬 굴리기
    static Bead goB(int d,int dxB,int dyB){
        while(true){
            //종료 조건
            if(map2[dxB][dyB] == '#' || map2[dxB][dyB] == 'R') {
                return new Bead(dxB-dx[d],dyB-dy[d]);
            }
            //구멍을 만난 경우
            if(map2[dxB][dyB] == 'O') {
                return new Bead(-1,-1);
            }
            if(dxB + dx[d] <0 || dxB + dx[d]>=N || dyB + dy[d] <0 || dyB + dy[d] >=M)  {
                return new Bead(dxB,dyB);
            }
            //이동하기
            dxB += dx[d];
            dyB += dy[d];
        }
    }
    //swap 함수
    static void swap(Bead A,Bead B,char c){
        map2[B.x][B.y] = c;
        map2[A.x][A.y] = '.';
    }
    // R과 B가 같은 선상에 있는지 확인
    static int check(int d,Bead R,Bead B){
        if(d==0){ //상
            if(R.y != B.y) return 1;
            return (R.x < B.x)? 0:1; //R이 더 앞이면 0, B가 앞이면 1
        }else if(d==1){ //하
            if(R.y != B.y) return 1;
            return (R.x > B.x)? 0:1; //R이 더 앞이면 0, B가 앞이면 1
        }else if(d==2){ //좌
            if(R.x != B.x) return 1;
            return (R.y < B.y)? 0:1; //R이 더 앞이면 0, B가 앞이면 1
        }else{ //우
            if(R.x != B.x) return 1;
            return (R.y > B.y)? 0:1; //R이 더 앞이면 0, B가 앞이면 1
        }
    }
    static class Beads{
        Bead R,B;
        int cnt;

        public Beads( Bead r, Bead b, int cnt) {
            R = r;
            B = b;
            this.cnt = cnt;
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
