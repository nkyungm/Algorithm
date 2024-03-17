import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[125251];
        long[] nums = new long[125251];

        int idx = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                nums[idx+j] = Integer.parseInt(st.nextToken());
                dp[idx+j] = nums[idx+j];
            }
            idx+=i;
        }

        idx = 0;
        long MAX = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = i; k <= (i+1); k++) {
                    dp[idx+j+k] = Math.max(dp[idx+j+k],nums[idx+j+k]+dp[idx+j]);
                    MAX = Math.max(MAX,dp[idx+j+k]);
                }
            }
            idx+=i;
        }
        System.out.println(MAX);
    }
}
