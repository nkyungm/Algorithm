import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //Union-Find 알고리즘 활용
    static int N,M;
    static int[] parents;
    static List<Node> arr;
    static int[] arr2;
    static class Node{
        int start,end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        arr = new ArrayList<>();
        arr2=  new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) arr.add(new Node(i,j));
            }
        }

        makeSet();

        for (Node n : arr){
            int start = n.start;
            int end = n.end;
            union(start,end);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M-1; i++) {
            int sRoot= findSet(arr2[i]);
            int eRoot= findSet(arr2[i+1]);
            if(sRoot != eRoot) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }
    static void makeSet(){
        for (int i = 1; i <=N ; i++) {
            parents[i] = i;
        }
    }
    static int findSet(int a){
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union (int a,int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
