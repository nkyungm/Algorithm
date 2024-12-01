import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer =0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        answer = arr[K-1];
        for(int i=K;i<N;i++){
            answer =  Math.max(answer,arr[i]-arr[i-K]);
        }

        System.out.println(answer);
    }
}
