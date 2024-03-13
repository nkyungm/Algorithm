import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		//Top - Down
//		int ret = Integer.MAX_VALUE;
//		for (int i = 0; i < 3; i++) {
//			ret = Math.min(ret,DP_TopDown(N-1, i));
//		}
//		System.out.println(ret);
		
		//Botton - Up
		System.out.println(DP_BottomUp(1));
	}
	
	//Botton - Up
	static int DP_BottomUp(int n){
		cost[n][0] += Math.min(cost[n-1][1],cost[n-1][2]);
		cost[n][1] += Math.min(cost[n-1][0],cost[n-1][2]);
		cost[n][2] += Math.min(cost[n-1][0],cost[n-1][1]);
		if(n == N-1) {
			 return Math.min(cost[n][0],Math.min(cost[n][1],cost[n][2]));
		}else {
			return DP_BottomUp(n+1);
		}
	}
	
	//Top - Down
	static int DP_TopDown(int n,int idx){
		if(n==0) {
			return dp[n][idx] = cost[n][idx];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(idx == i) continue;
			min = Math.min(min,DP_TopDown(n-1, i)+cost[n][idx]);
		}
		return min;
	}
}
