import java.util.*;
import java.io.*;
public class Main {
    static int[][] graph;
    static int zero=0;
    static int one=0;
    static int minus=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count_graph(0,0,N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
    static void count_graph(int r,int c,int n){
        if(check(r,c,n)){
            if(graph[r][c]==1) one++;
            else if(graph[r][c]==0) zero++;
            else minus++;
            return;
        }
        count_graph(r,c,n/3);
        count_graph(r,c+(n/3),n/3);
        count_graph(r,c+(n/3*2),n/3);
        count_graph(r+(n/3),c,n/3);
        count_graph(r+(n/3),c+(n/3),n/3);
        count_graph(r+(n/3),c+(n/3*2),n/3);
        count_graph(r+(n/3*2),c,n/3);
        count_graph(r+(n/3*2),c+(n/3),n/3);
        count_graph(r+(n/3*2),c+(n/3*2),n/3);

    }
    static boolean check(int r,int c,int n){
        int color = graph[r][c];
        for(int i=r;i<r+n;i++){
            for(int j=c;j<c+n;j++){
                if(color!=graph[i][j]) return false;
            }
        }
        return true;
    }
}
