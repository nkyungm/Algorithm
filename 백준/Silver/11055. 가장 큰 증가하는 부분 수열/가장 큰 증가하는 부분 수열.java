import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		int MAX = 1;
		// Arrays.fill(dp, 1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = A[0];
		
		for (int i = 0; i < N; i++) {
			dp[i] = A[i];
			for (int j = 0; j < i; j++) {
				if(A[i] <= A[j]) continue;
				if(dp[i] >= dp[j]+A[i]) continue;
				dp[i] =Math.max(dp[i],dp[j]+A[i]);
			}
			MAX = Math.max(dp[i],MAX);
		}
		
		System.out.println(MAX);
	}
}
