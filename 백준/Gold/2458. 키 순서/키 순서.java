import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static boolean[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		
		for (int i = 1; i <=N; i++) {
			map[i][i] = true;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
		}
		floyd();
		search();

		
		System.out.println(checkStudent());
		
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
	// 반대로 탐색
	static void search() {
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] || map[j][i]) map[i][j] = true;
			}
		}
	}
	// 순서 알수 있는 학생 찾기
	static int checkStudent() {
		int cnt = 0;
		for (int i = 1; i <=N; i++) {
			boolean flag = true;
			for (int j = 1; j <=N; j++) {
				if(!map[i][j]) flag = false;
			}
			if(flag) cnt++;
		}
		return cnt;
	}
}
