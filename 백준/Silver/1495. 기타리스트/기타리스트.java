import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,S,M;
    static int[] V;
    static boolean[][] dp;

    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        V = new int[N+1];
        dp = new boolean[51][1001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        
        dp[0][S] = true;
        // Bottom-Up 방식
        for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				if(!dp[i-1][j]) continue;
				if(j-V[i-1] >=0) dp[i][j-V[i-1]] = true;
				if(j+V[i-1] <=M) dp[i][j+V[i-1]] = true;
			}
		}
        
        int ans =-1;
        for (int i = 0; i <= M; i++) {
			if(dp[N][i]) ans = i;
		}
        System.out.println(ans);
	}
	

}
