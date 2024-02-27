// NxM 지도, 오른쪽(동쪽), 위쪽(북쪽)

// 주사위 설명
// 지도 위에 윗면 1, 동쪽 3 , 놓여져 있는 곳의 좌표 (x,y) , 가장 처음 주사위 모든 면 0
// 1. 주사위 굴려서 이동한 칸에 쓰여있는 수 0 -> 주사위의 바닥면에 쓰여있는 수가 칸에 복사
// 2. 0이 아닌 경우 -> 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수 0이 됨

// 주사위를 놓은 칸에 쓰여 있는 수는 항상 0
// 주사위 이동할때마다 상단(주사위 윗면)에 쓰여 있는 값 구하기
// 지도 밖으로 이동하는 명령은 무시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] graph;
	static Node dice;
	static int[] comArr;
	static int[] dices = {0,0,0,0,0,0};
	static int[] dx = {0,0,-1,1}; //우, 왼, 위,아래
	static int[] dy = {1,-1,0,0};
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M]; 
		// 주사위 처음 좌표
		dice = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		K = Integer.parseInt(st.nextToken()); //명령 개수
		comArr = new int[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			comArr[i] = Integer.parseInt(st.nextToken());
		}
		
		play();
	}
	
	static void play() {
		//명령 개수만큼 주사위 돌리기
		for (int i = 0; i < comArr.length; i++) {
			int com = comArr[i]-1;
			//명령 갈 좌표
			int xi = dice.x + dx[com];
			int yi = dice.y + dy[com];
			
			// 지도 밖으로 이동하는 명령은 무시
			if(xi < 0 || xi >= N || yi <0 || yi >= M) continue;
				
			// 2. 0이 아닌 경우 -> 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수 0이 됨
			if(graph[xi][yi] != 0) {
				// System.out.println("com "+com);
				rotationDice(com);
				dices[5] = graph[xi][yi]; // 바닥면 복사
				graph[xi][yi] =0; // 칸에 쓰여 있는 수 0으로 만들기
				
			}else { // 1. 주사위 굴려서 이동한 칸에 쓰여있는 수 0 -> 주사위의 바닥면에 쓰여있는 수가 칸에 복사
				rotationDice(com);
				graph[xi][yi] = dices[5];
				// dices[5] = 0;
			}
			// System.out.println(Arrays.toString(dices));
			System.out.println(dices[0]);
			dice = new Node(xi, yi);
		}
	}
	
	static void rotationDice(int com) {
		int[] dr = {1,0,4,5};
		int[] dc = {3,0,2};
		int temp = 0;
		switch(com) {
		case 0: // 동쪽 -> 
			temp = dices[dc[2]]; 
			for (int i = 1; i >=0; i--) {
				dices[dc[i+1]] = dices[dc[i]];
			}
			dices[dc[0]] = dices[dr[3]];
			dices[dr[3]] = temp;
			break;
		case 1: // 서쪽 <-
			temp = dices[dc[0]]; 
			for (int i = 0; i < 2; i++) {
				dices[dc[i]] = dices[dc[i+1]];
			}
			dices[dc[2]] = dices[dr[3]];
			dices[dr[3]] = temp;
			break;
		case 2: // 북쪽 ^
			temp = dices[dr[0]]; //1번째
			for (int i = 0; i < 3; i++) {
				dices[dr[i]] = dices[dr[i+1]];
			}
			dices[dr[3]] = temp;
			break;
		case 3: // 남쪽 v
			temp = dices[dr[3]]; //5번째
			for (int i = 2; i >=0; i--) {
				dices[dr[i+1]] = dices[dr[i]];
			}
			dices[dr[0]] = temp;
			break;
		}
	}
}
