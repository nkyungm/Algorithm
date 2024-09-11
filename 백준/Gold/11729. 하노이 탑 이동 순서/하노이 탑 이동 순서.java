import java.util.*;
import java.io.*;
public class Main {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb.append((1<<N)-1).append("\n");
        hanoi(1,3,N);
        System.out.println(sb);

    }
    // 하노이탑 이동 함수
    static void hanoi(int a,int b,int n){
        //base condition
        if(n==1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        // 재귀식
        //1 . n-1개 원판을 기둥 a에서 6-a-b로 옮긴다
        // 6-a-b인 이유 : 1+2+3 =6 이기 때문
        hanoi(a,6-a-b,n-1);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(6-a-b,b,n-1);
    }
}
