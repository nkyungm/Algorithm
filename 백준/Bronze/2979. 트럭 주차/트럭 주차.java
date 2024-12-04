import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        int answer = 0;

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j=start;j<end;j++){
                arr[j]++;
            }
        }

        for(int i=0;i<101;i++){
            if(arr[i]==0) continue;
            if(arr[i]==1) answer+= A;
            else if(arr[i]==2) answer+= 2*B;
            else if(arr[i]==3) answer+= 3*C;
        }

        System.out.println(answer);
    }
}
