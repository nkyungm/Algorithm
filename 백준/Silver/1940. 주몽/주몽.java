import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] notVisited =  new boolean[M];
        int[] arr = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] >= M) continue;
            notVisited[arr[i]] = true;
        }
        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            if(M/2 < arr[i]) break;
            if(!notVisited[arr[i]] || !notVisited[M-arr[i]] || arr[i] == M-arr[i]) continue;
            answer++;
        }

        System.out.println(answer);
    }
}
