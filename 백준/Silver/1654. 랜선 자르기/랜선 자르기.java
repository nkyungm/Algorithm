import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr= new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		System.out.println(upper_bound(0, arr[K-1]+1L, N)-1);
	}
	static long upper_bound(long min,long max,int key) {
		long mid = 0;
		while(min < max) {
			mid = (max + min) /2;
			if(count(mid) >= key) {
				min = mid +1;
			}else {
				max = mid;
			}
		}
		return min;
	}
	static long count(long mid) {
		long cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += (arr[i]/mid);
		}
		return cnt;
	}
}
