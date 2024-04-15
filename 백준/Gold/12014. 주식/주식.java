import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] Arr = new int[N];
            memo = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Arr[i] = Integer.parseInt(st.nextToken());
            }

            // LIS 탐색 시작
            int len =0;
            for (int i = 0; i < N; i++) {
                if(memo[len] < Arr[i]) memo[++len] = Arr[i];
                else{
                    int idx = lower_bound(0,len,Arr[i]);
                    memo[idx] = Arr[i];
                }
            }

            sb.append("Case #"+(t+1)).append("\n");
            sb.append((len >= K)? "1":"0").append("\n");
        }
        System.out.println(sb);
    }
    static int lower_bound(int left,int right,int key){
        int mid = 0;
        while(left < right){
            mid = (left+right)/2;
            if(memo[mid] < key) left = mid+1;
            else right = mid;
        }
        return left;
    }
}
