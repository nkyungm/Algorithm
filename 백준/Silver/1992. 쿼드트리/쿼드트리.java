import java.util.*;
import java.io.*;
public class Main {
    static int[][] graph;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                char c = s.charAt(j);
                if(c=='1') graph[i][j] = 1;
                else graph[i][j] = 0;
            }
        }
        quadtree(0,0,N);
        System.out.println(sb);
    }
    static void quadtree(int r, int c,int n){
        if(check(r,c,n)){
            sb.append(graph[r][c]);
            return;
        }
        sb.append("(");
        quadtree(r,c,n/2);
        quadtree(r,c+n/2,n/2);
        quadtree(r+n/2,c,n/2);
        quadtree(r+n/2,c+n/2,n/2);
        sb.append(")");
    }
    static boolean check(int r, int c, int n){
        int result = graph[r][c];
        for(int i=r;i<r+n;i++){
            for(int j=c;j<c+n;j++){
                if(result!=graph[i][j]) return false;
            }
        }
        return true;
    }
}
