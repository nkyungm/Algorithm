import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] graph;
	static int[][] tempGraph;
	static List<Node> setNode;
	static Queue<Node> queue;
	static boolean[][] visited;
	static int MAX = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];
		setNode = new ArrayList<>();
		queue = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				// 빈칸인 것 리스트에 다 넣기
				if(graph[i][j] == 0) setNode.add(new Node(i,j));
				if(graph[i][j] ==2) {
					queue.add(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		if(queue.size()==0) {
			MAX = setNode.size();
		}else setNodeFunc(0,new Node[3],0);
		
		System.out.println(MAX);
	}
	// 벽 3개를 선택하는 순열 함수
	static void setNodeFunc(int cnt,Node[] arr,int start) {
		if(cnt ==3) {
			int[][] tempGraph = new int[N][M];
			visited = new boolean[N][M];
			//깊은 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tempGraph[i][j] = graph[i][j];
					if(graph[i][j] ==2) {
						queue.add(new Node(i,j));
						visited[i][j] = true;
					}
				}
			}
			
			// 선택된 3개를 벽으로 만듬
			for (Node node : arr) {
				tempGraph[node.x][node.y] = 1;
			}
			
			// bfs로 바이러스 퍼지기
			bfs(tempGraph);
			
			// 안전영역 크기 구하기
			MAX = Math.max(MAX,countSafe(tempGraph));
			
			return;
		}
		for (int i = start; i < setNode.size(); i++) {
			arr[cnt] = setNode.get(i);
			setNodeFunc(cnt+1, arr,i+1);
		}
	}
	
	// bfs로 바이러스 퍼지기
	static void bfs(int[][] arr) {
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int xi = n.x + dx[i];
				int yi = n.y + dy[i];
				
				if(xi < 0 || xi >= N || yi < 0 || yi >= M) continue;
				if(arr[xi][yi] != 0 || visited[xi][yi] ) continue;
				
				queue.add(new Node(xi,yi));
				visited[xi][yi] = true;
				arr[xi][yi] =2; // 바이러스로 변경
			}
		}
	}
	
	// 안전영역 크기 구하기
	static int countSafe(int[][] arr) {
		int total =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) total++;
			}
		}
		return total;
	}
}
