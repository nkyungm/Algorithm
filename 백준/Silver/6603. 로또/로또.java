import java.util.*;
import java.io.*;
public class Main {
    static int K;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K==0) break;

            arr = new int[K];
            for(int i=0;i<K;i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            Combination(0,new int[6],0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void Combination(int cnt,int[] selected,int selectNum){
        if(cnt == 6){
            for(int i=0;i<6;i++){
                sb.append(selected[i]).append(" ");
            }sb.append("\n");
            return;
        }
        for(int i=selectNum;i<K;i++){
            selected[cnt] = arr[i];
            Combination(cnt+1,selected,i+1);
        }
    }
}
