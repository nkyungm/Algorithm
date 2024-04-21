import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][K+1];
        int[][] list = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int w = list[i][0]; //물건의 무게
            int v = list[i][1]; //물건의 가치
            for (int j = 1; j <= K; j++) {
                if(j < w) {
                    arr[i][j] = arr[i-1][j];
                }else{
                    arr[i][j] = Math.max(arr[i-1][j],v+arr[i-1][j-w]);
                }
            }
        }
        System.out.println(arr[N][K]);
    }
}
