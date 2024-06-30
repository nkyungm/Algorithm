import java.io.IOException;
import java.util.*;
import java.io.*;
import java.lang.*;

// 알고리즘 : DP(냅색)

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K+1][N+1];

        for(int i=1;i<K+1;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); //가치
            int w = Integer.parseInt(st.nextToken()); //무게
            for(int j=1;j<N+1;j++){
                if(j < w) {
                    arr[i][j] = arr[i-1][j];
                    continue;
                }
                arr[i][j] = Math.max(v+arr[i-1][j-w],arr[i-1][j]);
            }
        }

        System.out.println(arr[K][N]);
    }
}
