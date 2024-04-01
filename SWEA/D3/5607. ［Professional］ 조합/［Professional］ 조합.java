
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int P = 1234567891;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long R = Integer.parseInt(st.nextToken());
			
			long bottom = (factorial(R)*factorial(N-R))%P;
			long reBottom = power(bottom,P-2)%P;
			long ans = (factorial(N) * reBottom)%P;
			// long ans = factorial(N) * power(factorial(N-R),P-2)%P * power(factorial(R),P-2) % P;
			System.out.println("#"+(t+1)+" "+ans);
		}
	}
	static long factorial(long N) {
		long n = 1;
		for (int i = 2; i <N+1; i++) {
			n = (n*i)%P;
		}
		return n;
	}
	//거듭제곱을 구하기 위한 함수
	//분할정복
	static long power(long N,long E) {
		if(E==0) return 1;
		else if(E==1) return N;
		else {
			long td = power(N, E/2);
			if(E%2==0) return (td*td)%P;
			else return ((td*td)%P)*N%P;
		}
	}
}