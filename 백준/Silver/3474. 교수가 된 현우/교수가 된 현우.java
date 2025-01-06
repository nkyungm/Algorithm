import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int num = Integer.parseInt(br.readLine());
            int answer = num / 5;
            int divNum = 25;
            while(divNum <= num){
                answer += num / divNum;
                divNum *=5;
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
