import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;
    static int[] Aarr;
    static int[] Barr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            Aarr = new int[A];
            Barr = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<A;i++) Aarr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(Aarr);
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<B;i++) Barr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(Barr);

            // 깨달은점
            // 오름차순으로 정렬했기 떄문에 한번 걸러진 것은 처음부터 시작안해도 된다.
            int idx = 0;
            for(int i=0;i<A;i++){
                int target = Aarr[i];
                while(idx < B && Barr[idx] < target) idx++;
                if(idx <= B) answer+= idx;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}
