import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K,S;
	static boolean[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			map[x1][x2] = true;
		}
		floyd();
		
		S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(map[start][end]) System.out.println(-1);
			else {
				if(map[end][start]) System.out.println(1);
				else System.out.println(0);
			}
		}
		
	}
	// 플로이드 워샬
	static void floyd() {
		for (int k = 1; k <=N ; k++) {
			for (int i = 1; i <=N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][k] && map[k][j]) map[i][j] = true;
				}
			}
		}
	}
}
