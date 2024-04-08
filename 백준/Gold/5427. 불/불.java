import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int W,H;
	static char[][] graph;
	static int[][] fire;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static Node person;
	static Queue<Node> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int T= Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			graph = new char[H][W];
			fire = new int[H][W];
			visited = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					graph[i][j] = s.charAt(j);
					if(graph[i][j] == '*') {
						queue.add(new Node(i, j, 1));
						visited[i][j] = true;
						fire[i][j] = 1;
 					}else if(graph[i][j] == '@') person = new Node(i,j,0);
				}
			}
			
			// 불 BFS 탐색
			BFS_fire();
//			for (int i = 0; i < H; i++) {
//				System.out.println(Arrays.toString(fire[i]));
//			}
			int ans = BFS_person(person);
			if(ans == -1) System.out.println("IMPOSSIBLE");
			else System.out.println(ans);
		}
	}
	// 불 BFS
	static void BFS_fire() {
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int xi = n.x + dx[i];
				int yi = n.y + dy[i];
				
				if(xi <0 || xi >= H || yi <0 || yi >=W ) continue;
				if(visited[xi][yi] || graph[xi][yi] == '#') continue;
				
				visited[xi][yi] = true;
				fire[xi][yi] = n.sec+1;
				queue.add(new Node(xi,yi,n.sec+1));
			}
		}
	}
	// 상근 BFS
	static int BFS_person(Node p) {
		visited = new boolean[H][W];
		queue = new ArrayDeque<>();
		queue.add(p);
		visited[p.x][p.y] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int xi = n.x + dx[i];
				int yi = n.y + dy[i];
				
				// 탈출 조건
				if(xi <0 || xi >= H || yi <0 || yi >=W ) {
					// System.out.println(xi + " "+ yi);
					return n.sec+1;
				}
				if(visited[xi][yi] || graph[xi][yi] == '#') continue;
				if(fire[xi][yi] >0 && fire[xi][yi] <= n.sec+2) continue;

				visited[xi][yi] = true;
				queue.add(new Node(xi,yi,n.sec+1));
			}
		}
		return -1;
	}
	
	static class Node{
		int x,y,sec;
		public Node(int x, int y, int sec) {
			super();
			this.x = x;
			this.y = y;
			this.sec = sec;
		}
	}
}
