import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


// 4x4 공간, 물고기(1~16), 물고기 같은 번호 갖는 경우는 없음, 방향(상하좌우, 대각선)
// 청소년 상어는 (0,0)에 있는 물고기 먹고 (0,0) 들어감 -> 상어의 방향 = (0,0) 물고기 방향

//물고기 이동 방법

// 1. 물고기는 번호가 작은 물고기부터 순서대로 이동, 한칸 이동 가능
// 이동 가능한 칸 : 빈칸과 다른 물고기가 있는 칸
// 이동 할 수 없는 칸  : 상어 있는 칸, 공간의 경계를 넘는 칸
// 2. 물고기는 방향이 이동할 수 있는 칸을 향할때까지 45도 반시계 회전 -> 만약 이동할 수 있는 칸 없으면 이동X
// 3. 그 외의 경우에는 그 칸으로 이동 (이동할때 서로의 위치를 바꾸는 방식으로 이동)

// 상어 이동 방법

// 1. 물고기 이동 끝나면 상어가 이동, 방향에 있는 칸으로 이동 가능 (여러개 가능)
// 2. 상어가 물고기 칸으로 이동 -> 그 칸 물고기 먹음, 그 물고기 방향 가짐
// 3. 이동하는 중에 지나가는 칸에 있는 물고기는 먹지 않음, 물고기가 없는 칸으로는 이동할 수 X
// 4. 상어가 이동할 수 있는 칸이 없으면 공간 벗어나 집감
// 5. 상어가 이동한 후에 다시 물고기가 이동하며, 이후 과정 반복
public class Main {
	static Node[][] graph;
	static int[] dx = {-1,-1,0,1,1,1,0,-1}; // 위, 왼위,왼,왼아래, 아래,오른아래,오,오위
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int totalFishNum=0;
	static boolean[] visited;
	static Node shark;
	static Node[] arr;
	
	static class Node implements Comparable<Node>{
		int num,d,x,y;

		public Node(int num, int d) {
			super();
			this.num = num;
			this.d = d;
		}
	
		public Node(int num, int d, int x, int y) {
			super();
			this.num = num;
			this.d = d;
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
		    return Integer.compare(this.num, o.num);
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", d=" + d + ", x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		graph = new Node[4][4];
		arr = new Node[17];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				graph[i][j] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())-1,i,j);
				arr[graph[i][j].num] = new Node(graph[i][j].num, graph[i][j].d,i,j); //우선순위 큐로 x가 적은것부터 정렬
			}
		}
		
		moveSharkDFS(new Node(graph[0][0].num, graph[0][0].d,0,0),0);
		System.out.println(totalFishNum);
		
	}
	static void moveFish() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(graph[i][j] == null) continue;
				if(graph[i][j].num > 0) {
					arr[graph[i][j].num] = new Node(graph[i][j].num, graph[i][j].d,i,j);
				}
			}
		}
		
		for(int t=1;t<arr.length;t++) {
			Node node =arr[t];
			if(node == null||node.num <= 0) continue;
			for (int i = 0; i < 8; i++) { //상하좌우 대각선 탐색하면서 있는지 변경 자리확인
				int di = node.d+i;
				if(di >= 8) di-=8;
				int xi = node.x + dx[di];
				int yi = node.y + dy[di];
				
				if(xi <0 || xi>=4 || yi < 0 || yi >= 4) continue;
				if(graph[xi][yi]!=null && graph[xi][yi].num == -1) continue; //상어 있는 칸
				if(graph[xi][yi]==null) { //빈칸
					graph[xi][yi] = new Node(node.num,di,xi,yi);
					graph[node.x][node.y] = null;
					arr[node.num] = new Node(node.num,di,xi,yi);
				}else {
					swap(new Node(node.num,di,node.x,node.y), new Node(graph[xi][yi].num, graph[xi][yi].d,graph[xi][yi].x,graph[xi][yi].y));
				}
				
				break;
			}
		}
	}
	
	// 상어 이동 구하기
	static void moveSharkDFS(Node n,int sumFish) {
		
		//상어는 x값 -1로 설정
		shark = new Node(-1,graph[n.x][n.y].d,n.x,n.y);
		sumFish+= graph[n.x][n.y].num; //물고기 합 더해주기
		arr[graph[n.x][n.y].num] = null; //num별 좌표저장위함!!
		graph[n.x][n.y]= shark;
		
		
		// 물고기 이동하기
		moveFish();
	

		Node[][] tempArr = new Node[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tempArr[i][j] = graph[i][j];
			}
		}
		
		int xi = n.x;
		int yi = n.y;
		
		for (int i = 0; i < 3; i++) {
			xi += dx[n.d];
			yi += dy[n.d];
			if(xi <0 || xi >=4 || yi<0|| yi >=4) { //종료조건
				totalFishNum = Math.max(totalFishNum, sumFish);
				return;
			}
			if(graph[xi][yi] == null) continue; //물고기가 없는 칸은 이동X
			
			Node v = graph[xi][yi];
			//상어는 x값 -1로 설정
			graph[n.x][n.y] = null;
			
			//상어가 물고기 먹고 다음 진행
			moveSharkDFS(v,sumFish);
			
			//다시 원상복귀
			for (int k = 0; k < 4; k++) {
				for (int j = 0; j < 4; j++) {
					graph[k][j] = tempArr[k][j];
				}
			}
		}
	}
	
	static void swap(Node n1, Node n2) {

		Node temp = n1;
		graph[n1.x][n1.y] = new Node(n2.num, n2.d,n1.x,n1.y);
		arr[n2.num] =  new Node(n2.num, n2.d,n1.x,n1.y);
		graph[n2.x][n2.y] = new Node(temp.num, temp.d,n2.x,n2.y);
		arr[temp.num] =  new Node(temp.num, temp.d,n2.x,n2.y);
	}
}
