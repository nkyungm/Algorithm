import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // 중복 제거를 위한 set
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        Object[] arr = set.toArray();
        Arrays.sort(arr,(o1,o2)-> {
            if(o1.toString().length() == o2.toString().length()){
                return o1.toString().compareTo(o2.toString());
            }
            return o1.toString().length() - o2.toString().length();
        });
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
