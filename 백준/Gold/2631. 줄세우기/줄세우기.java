import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] A;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        memo = new int[N+1];

        for (int i = 1; i <=N ; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int len =0;
        for (int i = 1; i <=N ; i++) {
            if(A[i] > memo[len]) memo[++len]=A[i];
            else{
                int idx = lower_bound(0,len,A[i]);
                memo[idx] = A[i];
            }
        }
        System.out.println(N-len);
    }
    static int lower_bound(int left,int right,int key){
        int mid = 0;
        while(left < right){
            mid = (left + right)/2;
            if(memo[mid] < key){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
