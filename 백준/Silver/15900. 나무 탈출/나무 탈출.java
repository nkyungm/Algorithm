import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int ans=0;
    static class Node{
        int x,d,parent;

        public Node(int x, int d,int parent) {
            this.x = x;
            this.d = d;
            this.parent = parent;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(new Node(1,0,-1));
        if(ans%2==0) System.out.println("No");
        else System.out.println("Yes");
    }

    static void DFS(Node n){
        if(tree[n.x].size()==1 && tree[n.x].get(0) == n.parent){
            ans += n.d;
            return;
        }
        visited[n.x] = true;

        for(int num : tree[n.x]){
            if(num == n.parent) continue;
            DFS(new Node(num,n.d+1,n.x));
        }
    }
}
