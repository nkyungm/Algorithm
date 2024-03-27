

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int sum;
		public Node(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
		@Override
		public int compareTo(Node o) {
			return this.sum - o.sum;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int t=1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			sb.append("Problem "+t+": "+BFS()+"\n");
			t++;
		} 
		System.out.println(sb);
	}
	
	// 다익스트라 알고리즘 = (BFS + DP)
	// 다익스트라는 갔던 경로 또 갈 수 있음! -> visited 체크 안함
	static int BFS() {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[][] costs = new int[N][N]; // DP 메모이제이션
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(costs[i], Integer.MAX_VALUE);
		}
		
		queue.add(new Node(0,0,map[0][0]));
		costs[0][0] = map[0][0];
		
		while(!queue.isEmpty()) {
			Node v= queue.poll();
			
			if(v.x == N-1 && v.y == N-1) return v.sum;
			
			for (int i = 0; i < 4; i++) {
				int xi = v.x+ dx[i];
				int yi = v.y+ dy[i];
				
				if(xi <0 || xi >=N || yi <0 || yi >=N) continue;
				
				// 새로운 경로의 cost가 기존에 저장된 cost보다 작을 경우 값을 갱신해준다.
				if(costs[xi][yi] > v.sum + map[xi][yi]) {
					// 기존의 값보다 더 작은 것만 큐에 넣어주기
					costs[xi][yi] = v.sum + map[xi][yi];
					queue.add(new Node(xi,yi,v.sum+map[xi][yi]));
				}
			}
		}
		return -1;
	}
}
