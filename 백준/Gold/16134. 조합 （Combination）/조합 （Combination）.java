import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long P = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long R = Integer.parseInt(st.nextToken());
		
		long bottom = (factorial(R)*factorial(N-R))%P;
		long reBottom = power(bottom,P-2)%P;
		long ans = (factorial(N) * reBottom)%P;
		System.out.println(ans);
		
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
