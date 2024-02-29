
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//갈수 없는 경우 : 0
public class Main {
	static int N;
	static int[][] W;
	static int minAns = Integer.MAX_VALUE;
	static int start;
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = null;
		 
		 N = Integer.parseInt(br.readLine());
		 W = new int[N][N];
		 for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		 
		for (int i = 0; i < N; i++) {
			start = i;
			boolean[] visited = new boolean[N];
			visited[i] = true;
			minAns= Math.min(minAns, TSP(i,0, visited,0));
		}
		System.out.println(minAns);
	}
	//재귀
	static int TSP(int city, int cnt,boolean[] visited,int length) {
		if(cnt == N-1) {
			if(W[city][start] ==0) return Integer.MAX_VALUE;
			return length+W[city][start];
		}
		//같은 depth에서 minSum 비교
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			if(W[city][i] == 0) continue;
			visited[i] = true;
			//재귀 사용하는 경우 맨 마지막 다 끝난 기저조건의 return후 계산됨!!
			minSum = Math.min(minSum,TSP(i,cnt+1, visited,length+W[city][i]));
			visited[i] = false;
		}
		return minSum;
	}
}
