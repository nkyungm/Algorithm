import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while((s = br.readLine()) != null && !s.isEmpty()){
            int n = Integer.parseInt(s);
            int k =0;
            for (int i=1;;i++) {
                k = k*10 +1;
                k = k%n;
                if (k==0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
