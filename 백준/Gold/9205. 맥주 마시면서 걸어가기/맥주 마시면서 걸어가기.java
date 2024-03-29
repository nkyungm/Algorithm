import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; //편의점 개수
	static ArrayList<Node> nodeArr; //집, 편의점, 페스티벌 위치 저장 배열
	static ArrayList<ArrayList<Integer>> map;
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			nodeArr = new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				st =new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodeArr.add(new Node(x,y));
			}
			
			map = new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				map.add(new ArrayList<>());
			}
			
			// 1000미터 갈 수 있는 노드들 저장(인접리스트 생성), 양방향
			for (int i = 0; i < N+2; i++) {
				Node n1 = nodeArr.get(i);
				for (int j = i+1; j < N+2; j++) {
					Node n2 = nodeArr.get(j);
					if(distance(n1, n2) > 1000) continue;
					map.get(i).add(j);
					map.get(j).add(i);
				}
			}
			
			// 탐색 시작
			if(BFS(0)) sb.append("happy");
			else sb.append("sad");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static boolean BFS(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+2];
		
		queue.add(n);
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == N+1) return true;
			
			for(int next : map.get(now)) {
				if(visited[next]) continue;
				queue.add(next);
				visited[next] = true;
			}
		}
		return false;
	}
	static int distance(Node a, Node b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
	}
}
