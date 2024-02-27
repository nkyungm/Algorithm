import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static List<Box> conveyor;
    static List<Box> tempArr;
    static int ans =1;
    static class Box{
        boolean robot;
        int a;
        public Box(boolean robot, int a) {
            this.robot = robot;
            this.a = a;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //내리는 위치
        K = Integer.parseInt(st.nextToken()); //종료 조건

        conveyor = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*N; i++) {
            conveyor.add(new Box(false,Integer.parseInt(st.nextToken())));
        }

        conveyorBelt();
        System.out.println(ans);
    }

    static void conveyorBelt(){
        while(true){
            // 내리는 위치에 도달하면 바로 내림
            if(conveyor.get(N-1).robot) conveyor.get(N-1).robot = false;

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전
            rotate();
            if(conveyor.get(N-1).robot) conveyor.get(N-1).robot = false;

            // 2. 컨베이어 벨트 위에 있는 로봇 한칸 이동
            for (int i = N-2; i >=0; i--) {
                if(! conveyor.get(i).robot) continue;
                if(conveyor.get(i+1).robot || conveyor.get(i+1).a< 1) continue;
                conveyor.get(i+1).robot = true;
                conveyor.get(i+1).a -=1;
                conveyor.get(i).robot = false;
            }

            //3. 올리는 위치에 있는 칸 내구도 0 아니면 올리는 위치에 로봇 올림
            if(conveyor.get(0).a != 0) {
                conveyor.get(0).robot =true;
                // 내구도 -1
                conveyor.get(0).a --;
            }

            //4. 내구도가 0인 칸의 개수가 K이상이면 과정 종료, 아니면 1번으로 돌아감
            int cnt =0;
            for (int i = 0; i < 2*N; i++) {
                if(conveyor.get(i).a ==0) cnt++;
            }
            if(cnt >= K) break;
            else ans++;
        }
    }

    static void rotate(){
        Box b = conveyor.get(2*N-1);
        conveyor.remove(2*N-1);

        conveyor.add(0,b);
    }
}
