import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp,1);
        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(A[j] <= A[i]) continue;
                dp[i] = Math.max(dp[j]+1,dp[i]);
            }
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
