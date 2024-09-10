import java.util.*;
import java.io.*;

public class Main {
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A =  Integer.parseInt(st.nextToken());
        B =  Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());

        System.out.println(fpow(B));
    }
    static long fpow(int n){
        if(n==1){
            return A%C;
        }
        long x = fpow(n/2);
        if(n%2==0) return x*x%C;
        return (x*x%C)*A%C;
    }
}
