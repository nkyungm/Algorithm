import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            char[] s = br.readLine().toCharArray();
            for(int j=0;j<N;j++) arr[i][j] = s[j]-'0'; // 시간 줄임
        }

        quadtree(0,0,N);
        System.out.println(sb);
    }
    static void quadtree(int x,int y,int size){
        if(check(x,y,size)) {
            sb.append(arr[x][y]);
            return;
        }
        sb.append("(");
        quadtree(x,y,size/2);
        quadtree(x,y+size/2,size/2);
        quadtree(x+size/2,y,size/2);
        quadtree(x+size/2,y+size/2,size/2);
        sb.append(")");
    }
    static boolean check(int x,int y,int size){
        int color = arr[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(color == arr[i][j]) continue;
                return false;
            }
        }
        return true;
    }
}
