import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int score=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i+1][0] = Integer.parseInt(st.nextToken()); // T
            arr[i+1][1] = Integer.parseInt(st.nextToken()); // P
        }

        DFS(1,0);
        System.out.println(score);

    }
    private static void DFS(int day, int profit){
        // 종료조건
        if(day >= N+1){
            score = Math.max(score,profit);
            return;
        }

        //상담 하는 경우
        if(day + arr[day][0] <= N+1){
            DFS(day+ arr[day][0],profit+arr[day][1]);
        }
        //상담 안하는 경우
        DFS(day+1,profit);
    }

}
