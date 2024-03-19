import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int S;
    static class Node implements Comparable<Node>{
        int n,board,cnt;

        public Node(int n, int board, int cnt) {
            this.n = n;
            this.board = board;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        System.out.println(BFS());
    }

    static int BFS(){
        Queue<Node> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[2001][2001];
        queue.add(new Node(1,0,0));
        visited[1][0] = visited[0][0] = true;

        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.n == S) return n.cnt;
            // 2번 연산
            if(n.board >0 && n.n+n.board >=0 && n.n+n.board<S+1 && !visited[n.n+n.board][n.board]){
                queue.add(new Node(n.n+n.board,n.board,n.cnt+1));
                visited[n.n+n.board][n.board] = true;
            }
            // 1번 연산
            if(!visited[n.n][n.n]) {
                queue.add(new Node(n.n,n.n,n.cnt+1));
                visited[n.n][n.n] = true;
            }

            // 3번 연산
            if(n.n >= 1 && !visited[n.n-1][n.board]) {
                queue.add(new Node(n.n-1,n.board,n.cnt+1));
                visited[n.n-1][n.board] = true;
            }
        }
        return -1;
    }
}
