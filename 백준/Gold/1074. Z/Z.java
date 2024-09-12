import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
    static int sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(z_go(r,c,N));
    }
    static int z_go(int r,int c,int n){
        if(n==1){
            if(r==0){
                if(c==0) return 0;
                else if(c==1) return 1;
            }else if(r==1){
                if(c==0) return 2;
                else if(c==1) return 3;
            }
        }
        int m = (int)Math.pow(2,n-1);
        if(r<m){
            if(c<m){
                 return z_go(r,c,n-1);
            }
            return m*m+z_go(r,c-m,n-1);
        }else{
            if(c<m){
                return m*m*2+z_go(r-m,c,n-1);
            }
            return m*m*3+z_go(r-m,c-m,n-1);
        }
    }
}
