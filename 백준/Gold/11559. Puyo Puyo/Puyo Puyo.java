import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] board;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	static int temp;
	static int tempI;
	static class Puyo{
		int x,y;
		public Puyo(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		boolean flag = true;
		int round = 0;
		while(flag) {
			visited = new boolean[12][6];
			flag = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(board[i][j] == '.' || visited[i][j]) continue;
					// System.out.println(i+ " " + j);
					if(BFS(new Puyo(i, j))) {
						flag = true;
					}
				}
			}
			if(flag) {
				round++; //연쇄 추가
				downPuyo();
//				for (int i = 0; i < 12; i++) {
//					System.out.println(Arrays.toString(board[i]));
//				}
			}
		}
		System.out.println(round);
	}
	static boolean BFS(Puyo p) {
		Queue<Puyo> queue = new ArrayDeque<>(); //탐색할 때 사용 큐
		List<Puyo> arr = new ArrayList<>();
		
		queue.add(p);
		visited[p.x][p.y] = true;
		
		while(!queue.isEmpty()) {
			Puyo n = queue.poll();
			arr.add(n);
			for (int i = 0; i < 4; i++) {
				int xi = dx[i] + n.x;
				int yi = dy[i] + n.y;
				
				if(xi <0 || xi >= 12 || yi <0 || yi >=6) continue;
				if(visited[xi][yi] || board[n.x][n.y] != board[xi][yi]) continue;
				
				queue.add(new Puyo(xi, yi));
				visited[xi][yi] = true;
			}
		}
		// System.out.println("사이즈:"+arr.size());
		if(arr.size()>=4) {
			// 뿌요 없애기
			deletePuyo(arr);
			return true;
		}
		return false;

	}
	static void deletePuyo(List<Puyo> arr) {
		for (int i = 0; i < arr.size(); i++) {
			Puyo p = arr.get(i);
			board[p.x][p.y] = '.';
		}
	}
	// 뿌요 내리기
	static void downPuyo() {
		for (int j = 0; j < 6; j++) { //y좌표
			for (int i = 10; i >=0; i--) { //x좌표
				if(board[i][j] == '.') continue;
				
				// 밑으로 내려가기
				temp = i;
				for (int k = i+1; k < 12; k++) {
					if(board[k][j] !='.') break;
					temp = k;
				}
				//swap하기
				if(temp == i) continue;
				board[temp][j] = board[i][j];
				board[i][j] = '.';
			}

		}
	}
}
