import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A;
	static int[] memo;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		String s;
		while((s=br.readLine())!=null) {
			s =s.trim();
			int N = Integer.parseInt(s);
			A = new int[N];
			memo = new int[100_001];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			//LIS 길이 탐색
			int len =0;
			for (int i = 0; i < N; i++) {
				if(A[i] > memo[len]) memo[++len] = A[i];
				else {
					int idx = lower_bound(0,len,A[i]);
					memo[idx] = A[i];
				}
			}
			sb.append(len).append("\n");
		}
		System.out.println(sb);
	}
	static int lower_bound(int left,int right,int key) {
		int mid = 0;
		while(left < right) {
			mid = (left + right)/2;
			if(memo[mid] < key) left = mid+1;
			else right = mid;
		}
		return left;
	}
}
