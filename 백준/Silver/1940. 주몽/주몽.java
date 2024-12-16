import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 투포인터
        int start= 0,end = N-1;
        int sum;
        while(start!=end){
            sum = arr[start] + arr[end];
            // 합해서 M보다 작으면 start 올리기
            if(sum < M) start++;
            else {
                if(sum == M) answer++;
                end--;
            }
        }

        System.out.println(answer);
    }
}
