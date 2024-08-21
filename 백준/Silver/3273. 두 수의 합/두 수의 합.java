import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];
        int[] numArr = new int[N];
        int answer = 0;

        // 값들 넣기
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numArr[i] = Integer.parseInt(st.nextToken());
            arr[numArr[i]] = true;
        }

        int X = Integer.parseInt(br.readLine());

        // 만족하는 쌍의 개수 구하기
        for(int i=0;i<N;i++){
            int num = numArr[i];
            // 이미 한거는 넘기기
            if(!arr[num]) continue;
            // X보다 같거나 커도 넘기기
            if(num >=X) continue;
            // 나머지 쌍 있는지 확인
            // 틀린 부분 : 자기자신이 똑같으면 안된다
            if(X-num == num) continue;
            if(arr[X-num]){
                arr[num] = false;
                arr[X-num] = false;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
