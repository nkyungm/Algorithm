import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());
        int answer = 0;
        int start = 1;
        int end = M;

        while(J --> 0){
            int apple = Integer.parseInt(br.readLine());
            int diff;
            if(apple > end){
                diff = apple - end;
                start+=diff;
                end+=diff;
                answer+=diff;
            }else if(apple < start){
                diff = start - apple;
                start-=diff;
                end-=diff;
                answer+=diff;
            }
        }
        System.out.println(answer);
    }
}
