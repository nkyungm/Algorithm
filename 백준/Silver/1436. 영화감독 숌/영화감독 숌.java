import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb;

        int cnt = 1;
        int num = 666;

        while(cnt < N){
            num++;
            sb = new StringBuilder();
            String s = sb.append(num).toString();
            if(s.contains("666")) cnt++;
        }

        System.out.println(num);

    }
}
