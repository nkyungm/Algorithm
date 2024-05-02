import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/* 구현 방법 : 투포인터
- 1. 연속된 부분합 중 s이상인 구간의 길이를 구한다.
- 2. sum < s, 값이 작으므로 end포인터를 늘려준다.
- 3. sum >= s, 값이 크거나 같으므로 start 포인터 위치에 있는 배열값을 빼준다.
- 4. 구한 부분합의 길이 중 가장 짧은 길이를 출력
*/
public class Main {
    static int N,S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        // 투포인터 시작
        // 종료조건 : start와 end 모두 끝에 왔을때!
        while(start<=N && end<=N){
            // S보다 sum이 커질때까지 end++
            if(sum < S) sum += arr[end++];
            else if(sum >= S) {
                min = Math.min(min, end-start);
                sum -= arr[start++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
