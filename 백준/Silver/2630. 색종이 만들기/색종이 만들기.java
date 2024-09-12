import java.util.*;
import java.io.*;
public class Main {
    static int[][] graph;
    static int B=0;
    static int W=0;
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

        count_color(0,0,N);

        System.out.println(W);
        System.out.println(B);
    }
    static void count_color(int r,int c,int n){
        if(check(r,c,n)){
            if(graph[r][c]==1) B++;
            else W++;
            return;
        }

        count_color(r,c,n/2);
        count_color(r,c+n/2,n/2);
        count_color(r+n/2,c,n/2);
        count_color(r+n/2,c+n/2,n/2);

    }
    static boolean check(int r, int c, int n){
        int color = graph[r][c];
        for(int i=r;i<r+n;i++){
            for(int j=c;j<c+n;j++){
                if(graph[i][j]!= color) return false;
            }
        }
        return true;
    }
}
