// 사과 먹으면 뱀 길이 늘어남, 벽 또는 자기자신의 몸에 부딪히면 게임 끝남
// NxN, 보드의 상하좌우 끝에 벽이 있음
// 게임 시작할때 뱀은 맨위 맨좌측(0,0)에 위치, 뱀 길이 1, 처음에 오른쪽 향함

// 이동 규칙
// 1. 뱀은 몸 길이를 늘려 머리를 다음칸에 위치시킨다.
// 2. 만약 벽이나 자기자신의 몸과 부딪히면 게임 끝남
// 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과 없어지고 꼬리 움직이지X
// 4. 만약 이동한 칸에 사과 X -> 몸길이를 줄여서 꼬리가 위치한 칸 비워준다.(몸길이 변하지X)

// 게임 끝나는 시간 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K,L;
	static int[][] graph;
	static Direction[] commendArr;
	static int snakeLength = 1;
	static int count =0;
	static int direction = 0;
	static Queue<Node> queue = new ArrayDeque<>();
	static Node tail = new Node(0,0);
	static int[] dx = {0,1,0,-1}; //오, 아래, 왼, 위
	static int[] dy = {1,0,-1,0};
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class Direction{
		int x;
		char d;

		public Direction(int x, char d) {
			super();
			this.x = x;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); //보드 크기
		K = Integer.parseInt(br.readLine()); //사과 개수
		graph = new int[N][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			graph[x1-1][y1-1] = 2; //사과 저장
		}
		
		L = Integer.parseInt(br.readLine()); //방향 변환 횟수
		commendArr = new Direction[L];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			commendArr[i] = new Direction(x, direction);
		}
		
		//게임 시작
		direction =0;
		play(new Node(0,0));
		System.out.println(count+1);
	}
	
	static void play(Node n) {
		
		if(checkDirection(count)!= 'E') {
			char com = checkDirection(count);
			if(com == 'D') { //오른쪽 90도 회전
				if(direction == 3) direction = 0;
				else direction++;
			}else if(com == 'L') { //왼쪽 90도 회전
				if(direction==0) direction=3;
				else direction--;
			}
		}
		
		graph[n.x][n.y] = 1;
		int xi = n.x + dx[direction];
		int yi = n.y + dy[direction];
		
		// 2. 만약 벽이나 자기자신의 몸과 부딪히면 게임 끝남
		if(xi < 0 || xi >= N || yi <0 || yi >= N) return;
		if(graph[xi][yi] ==1 ) return;
		
		// 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과 없어지고 꼬리 움직이지X
		if(graph[xi][yi] ==2) {
			//꼬리 저장해아함!!
			queue.add(new Node(n.x,n.y));
			snakeLength++;
			count++;
			play(new Node(xi,yi));
		}
		// 4. 만약 이동한 칸에 사과 X -> 몸길이를 줄여서 꼬리가 위치한 칸 비워준다.(몸길이 변하지X)
		else {
			count++;
			if(snakeLength > 1) {
				Node tail = queue.poll();
				graph[tail.x][tail.y] = 0;
				queue.add(new Node(n.x,n.y));
			}else {
				graph[n.x][n.y] = 0;
			}
			play(new Node(xi,yi));
		}
	}
	
	static char checkDirection(int count) {
		for (int i = 0; i < commendArr.length; i++) {
			if(commendArr[i].x == count) {
				return commendArr[i].d;
			}
		}
		return 'E';
	}
}
