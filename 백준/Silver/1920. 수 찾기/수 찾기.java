import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
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
			int ans = BinarySearch(0, N-1, Integer.parseInt(st.nextToken()));
			if(ans == -1) sb.append(0).append("\n");
			else sb.append(1).append("\n");
		}
		System.out.println(sb);
	}
	static int BinarySearch(int left,int right,long key) {
		int mid = 0;
		while(left <= right) {
			mid = (left + right)/2;
			if(arr[mid] == key) return mid;
			else if(arr[mid] > key) right = mid-1;
			else left = mid+1;
		}
		return -1; //탐색 실패
	}
}
