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

        // 실수한 부분 : arr[i] 와 arr[M-arr[i]]가 같은 숫자일때 체크를 안해줌..
        for(int i=0;i<N;i++){
            if(M/2 < arr[i]) break;
            if(!notVisited[arr[i]]) continue;
            if(!notVisited[M-arr[i]]) continue;
            if(arr[i] == M-arr[i]) continue;
            answer++;
            notVisited[arr[i]] = false;
            notVisited[M - arr[i]] = false;
        }

        System.out.println(answer);

    }
}
