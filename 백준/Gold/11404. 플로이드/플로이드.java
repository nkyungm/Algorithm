import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(graph[i], 100000*n+1);
			graph[i][i] =0;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[start][end] = Math.min(graph[start][end],cost);
 		}
		
		floyd();
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <= n; j++) {
				if(graph[i][j] == 100000*n+1) System.out.print(0 + " ");
				else System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
				}
			}
		}
	}
}
