import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        // 입력된 값을 저장할 배열
        int[] A = new int[N + 1];
        // 증가수열을 저장할 배열
        memo = new int[N + 1];
        Arrays.fill(memo,1);
        int MAX = Integer.MIN_VALUE;
        int maxIdx = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i ; j++) {
                if(A[i] > A[j]){
                    memo[i] = Math.max(memo[i],memo[j]+1);
                }
            }
            if(MAX < memo[i]){
                maxIdx = i;
                MAX = memo[i];
            }
        }
        sb.append(MAX).append("\n");

        List<Integer> LISArr = new ArrayList<>();
        LISArr.add(A[maxIdx]);
        int n = MAX-1;
        // LIS 수열 찾기
        for (int i = maxIdx; i >= 1 ; i--) {
            if(n==0) break;
            if(n != memo[i]) continue;
            LISArr.add(A[i]);
            n--;
        }
        for (int i = LISArr.size()-1; i >=0; i--) {
            sb.append(LISArr.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
