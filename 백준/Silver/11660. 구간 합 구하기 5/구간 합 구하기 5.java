import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken())+(arr[i-1][j] + arr[i][j-1] -arr[i-1][j-1]);
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            calculate(x1,y1,x2,y2);
        }
        System.out.println(sb);
    }
    static void calculate(int x1,int y1,int x2, int y2){
        int result = arr[x2][y2]-(arr[x2][y1-1]+arr[x1-1][y2]-arr[x1-1][y1-1]);
        sb.append(result).append("\n");
    }
}
