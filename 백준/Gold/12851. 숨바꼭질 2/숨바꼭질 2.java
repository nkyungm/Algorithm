import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int K;
    static int[] time;
    static Queue<Integer> queue;
    static int cnt;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100001];
        queue = new ArrayDeque<>();

        if(N>=K){
            System.out.println((N-K));
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(min);
        System.out.println(cnt);

    }
    static void bfs(){
        int[] result = new int[3];
        queue.add(N);
        time[N] = 1;

        while(!queue.isEmpty()){
            int v = queue.poll();

            if(min < time[v]) continue;

            result[0] = v *2;
            result[1] = v -1;
            result[2] = v +1;

            for(int i=0;i<3;i++){
                // 범위 밖이거나, 이미 방문한 지점인데 기존 소요시간보다 오래걸린다면X
                if(result[i]<0 || result[i]> 100000) continue;

                if(result[i]==K) {
                    min = time[v];
                    cnt++;
                }

                if(time[result[i]]==0 ||  time[result[i]] == time[v]+1 ){
                    time[result[i]] = time[v]+1;
                    queue.add(result[i]);
                }
            }
        }
    }
}
