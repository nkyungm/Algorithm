import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가수열을 찾되 연속된 수를 가진 증가수열을 찾기!
public class Main {
	static int N;
	static int[] memo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int student = Integer.parseInt(st.nextToken());
			memo[student] = memo[student-1] +1;
			max = Math.max(max,memo[student]);
		}
		System.out.println(N-max);

	}
}
