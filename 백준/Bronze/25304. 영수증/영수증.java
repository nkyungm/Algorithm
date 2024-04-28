import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int totalMoney = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int totalReal=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            totalReal += (money * cnt);
        }

        if(totalMoney == totalReal) System.out.println("Yes");
        else System.out.println("No");

    }
}
