import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			int ans = upperBound(0, N, n) - lowerBound(0, N, n);
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}
	
	//lower_bound 이분탐색 함수
	static int lowerBound(int left,int right,long key) {
		int mid = 0;
		// left와 right가 같아질 때까지 반복
		while(left < right) {
			mid = (left + right)/2; // 중간 위치 구함
			if(arr[mid] == key) { 
				// 상한선을 내림
				right = mid;
			}
			else if(arr[mid] > key) right = mid;
			else left = mid+1;
		}
		return left; 
	}
	
	//upper_bound 이분탐색 함수
	static int upperBound(int left,int right,long key) {
		int mid = 0;
		while(left < right) {
			mid = (left + right)/2;
			if(arr[mid] == key) {
				// 하한선을 올림
				left = mid+1;
			}
			else if(arr[mid] > key) right = mid;
			else left = mid+1;
		}
		return left; 
	}
}
