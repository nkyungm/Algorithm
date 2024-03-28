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

        DP(0,S);
        int ans =-1;
        for (int i = 0; i <= M; i++) {
			if(dp[N][i]) ans = i;
		}
        System.out.println(ans);
	}
	
	static void DP(int idx,int volum) {
		if(idx > N) return;
		if(dp[idx][volum]) return;
		
		dp[idx][volum] = true;
		
		if(volum-V[idx] >=0) {
			DP(idx+1,volum-V[idx]);
		}
		if(volum+V[idx] <=M) {
			DP(idx+1,volum+V[idx]);
		}
		return;
	}
}
