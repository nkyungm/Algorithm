import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] S = new int[N];
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		int MAX = 1;
		
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(S[i] <= S[j]) continue;
				dp1[i] = Math.max(dp1[i],dp1[j]+1);
			}
		}
		
		for (int i = N-1; i >=0; i--) {
			for (int j = N-1; j > i; j--) {
				if(S[i] <= S[j]) continue;
				dp2[i] = Math.max(dp2[i],dp2[j]+1);
			}
			MAX = Math.max(MAX,dp1[i] + dp2[i]);
		}
		
		System.out.println(MAX-1);
	}
}
