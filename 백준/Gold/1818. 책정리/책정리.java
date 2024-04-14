import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        // 입력된 값을 저장할 배열
        int[] A = new int[N+1];
        // 증가수열을 저장할 배열
        memo = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int len =0;
        // LIS 탐색
        for (int i = 1; i <= N; i++) {
            // 확인하는 숫자가 증가수열의 마지막 수보다 큰 경우
            // 배열에 추가해줌
            if(A[i] > memo[len]) {
                memo[++len] = A[i];
            }else{ // 확인하는 숫자가 증가수열의 마지막 수보다 작은 경우
                // 이진탐색으로 들어갈 위치 찾기
                int idx = binarySearch(0,len,A[i]);
                memo[idx] = A[i];
            }
        }
        System.out.println(N-len);
    }

    // lower_bound 이분탐색
    static int binarySearch(int left,int right, int key){
        int mid = 0;
        while(left < right){
            mid = (left+right) /2;
            if(memo[mid] < key) left = mid+1;
            else right = mid;
        }
        return left;
    }
}

