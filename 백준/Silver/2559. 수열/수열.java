import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer =0;
        int[] arr = new int[N];
        int temp = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += temp;
            temp = arr[i];
        }

        answer = arr[K-1];
        for(int i=K;i<N;i++){
            answer =  Math.max(answer,arr[i]-arr[i-K]);
        }

        System.out.println(answer);
    }
}
