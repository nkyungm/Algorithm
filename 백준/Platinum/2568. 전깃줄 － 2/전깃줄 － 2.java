import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Node[] A;
	static int[] memo;
	static int[] idxList;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(br.readLine());
		A = new Node[N];
		memo = new int[500_001];
		idxList = new int[500_001];
		Arrays.fill(idxList, -1);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[i] = new Node(a,b);
			idxList[a] = 1;
		}
		Arrays.sort(A);

		// System.out.println(Arrays.toString(A));
		
		// LIS 길이 탐색
		int len =0;
		int maxIdx = 0;
		for (int i = 0; i < N; i++) {
			Node n = A[i];
			if(n.b > memo[len]) {
				memo[++len] = n.b;
				idxList[n.a] = len;
				maxIdx = i;
			}else {
				int idx = lower_bound(0,len,n.b);
				memo[idx] = n.b;
				idxList[n.a] = idx;
			}
		}
		sb.append(N-len).append("\n");
		
		// 제거할 전깃줄 배열 구하기
		List<Integer> deleteList = new ArrayList<>();
		int n = idxList[A[maxIdx].a];
		for (int i = A.length-1; i >=0; i--) {
			if(idxList[A[i].a] == n) n--;
			else deleteList.add(A[i].a);
		}
		Collections.sort(deleteList);
		
		for (int i = 0; i < deleteList.size(); i++) {
			sb.append(deleteList.get(i)).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	static int lower_bound(int left, int right, int key) {
		int mid = 0;
		while(left < right) {
			mid = (left + right)/2;
			if(memo[mid] < key) {
				left = mid +1;
			}else {
				right = mid;
			}
		}
		return left;
	}
	static class Node implements Comparable<Node>{
		int a,b;
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Node o) {
			return this.a - o.a;
		}
		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + "]";
		}
		
	}
}
