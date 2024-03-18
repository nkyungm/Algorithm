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
        int[] A = new int[N+1];
        memo = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int len =0;
        for (int i = 1; i <= N; i++) {
            if(A[i] > memo[len]) {
                memo[++len] = A[i];
            }else{
                int idx = binarySearch(0,len,A[i]);
                memo[idx] = A[i];
            }
        }
        System.out.println(len);
    }
    static int binarySearch(int left,int right, int key){
        int mid = 0;
        while(left < right){
            mid = (left+right) /2;
            if(memo[mid] < key) left = mid+1;
            else right = mid;
        }
        return right;
    }
}

