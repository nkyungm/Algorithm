import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for(int i=0;i<N;i++){
            String name = br.readLine();
            arr[name.charAt(0)-97] ++;
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] < 5) continue;
            sb.append((char)(i+97));
        }

        if(sb.toString().isEmpty()) sb.append("PREDAJA");

        System.out.println(sb);

    }
}
