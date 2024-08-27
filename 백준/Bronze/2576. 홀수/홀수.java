import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MIN = 100;
        int answer = 0;
        for(int i=0;i<7;i++){
            int N = Integer.parseInt(br.readLine());
            if(N%2==0) continue;
            answer+=N;
            MIN = Math.min(MIN,N);
        }
        if(MIN == 100){
            System.out.println(-1);
        }else{
            System.out.println(answer);
            System.out.println(MIN);
        }
    }

}
