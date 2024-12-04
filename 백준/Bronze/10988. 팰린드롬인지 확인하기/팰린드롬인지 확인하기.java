import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        for(int i=0;i<n/2;i++) {
            if (s.charAt(i) == s.charAt(n - i - 1)) continue;
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }
}
