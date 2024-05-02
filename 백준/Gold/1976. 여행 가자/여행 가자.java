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

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N+1];

        makeSet();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) union(i,j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M-1; i++) {
            int next = Integer.parseInt(st.nextToken());
            int sRoot= findSet(now);
            int eRoot= findSet(next);
            if(sRoot != eRoot) {
                System.out.println("NO");
                return;
            }
            now = next;
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
