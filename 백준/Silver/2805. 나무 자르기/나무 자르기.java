import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		System.out.println(upper_bound(0, arr[N-1]+1, M)-1);
	}
	static int upper_bound(int left,int right,int key) {
		int mid = 0;
		while(left < right) {
			mid = (left + right)/2;
			if(getTree(mid) >= key) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return left;
	}
	private static long getTree(int mid) {
		long total =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > mid) total+=arr[i]-mid;
		}
		
		return total;
	}
	
}
