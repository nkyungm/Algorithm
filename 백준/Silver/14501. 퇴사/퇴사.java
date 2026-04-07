import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] arr;
    static int score=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+2][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i+1][0] = Integer.parseInt(st.nextToken()); // T
            arr[i+1][1] = Integer.parseInt(st.nextToken()); // P
        }

        arr[N+1][0] = 5;
        arr[N+1][1] = 0;

        BFS();
        System.out.println(score);

    }
    private static void BFS(){
        Deque<Job> queue = new ArrayDeque<>();
        queue.add(new Job(1,false,0));
        if(N+1 >= 1+arr[1][0]) queue.add(new Job(1,true,arr[1][1]));

        while(!queue.isEmpty()) {
            Job j = queue.poll();

            // max 체크 && N 체크
            score = Math.max(score, j.score);
            if(j.idx == N) continue;

            int next = j.idx;
            // false인 경우
            if (!j.visited && j.idx + 1 <= N + 1) {
                next = j.idx + 1;
                // idx+1 true
                if (arr[next][0] + next <= N + 1) {
                    queue.add(new Job(next, true, j.score + arr[next][1]));
                }
                // idx+1 false
                queue.add(new Job(next, false, j.score));
            }

            // true인 경우
            if (j.visited && j.idx + arr[j.idx][0] <= N + 1) {
                next = j.idx + arr[j.idx][0];
                // next true
                if (arr[next][0] + next <= N + 1) {
                    queue.add(new Job(next, true, j.score + arr[next][1]));
                }
                // next false
                queue.add(new Job(next, false, j.score));
            }
        }

    }

    static class Job{
        int idx;
        boolean visited;
        int score;

        public Job(int idx,boolean visited,int score){
            this.idx = idx;
            this.visited = visited;
            this.score = score;
        }
    }
}
