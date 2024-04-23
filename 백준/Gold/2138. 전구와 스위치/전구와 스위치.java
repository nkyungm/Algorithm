import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] arr;
    static char[] resultArr;
    static char[] arr1,arr2;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        resultArr = br.readLine().toCharArray();

        arr1 = new char[N];
        arr2 = new char[N];

        for (int i = 0; i <N ; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i];
        }

        // 1. 0번 전구를 누르지 않는 경우
        go(arr1,0);

        // 2. 0번 전구를 누르는 경우
        arr2 = push(0,arr2);
        go(arr2,1);

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
    static void go(char[] arr,int cnt) {

        // 1번 전구부터 파악하기
        for (int i = 1; i < N; i++) {

            // i-1번째가 다른지, 같은지 확인
            // 같으면 넘어감
            if (arr[i - 1] == resultArr[i - 1]) continue;

            // 다른 경우 i-1,i,i+1 변경
            arr = push(i, arr);
            cnt++;
        }

        if (arr[N - 1] == resultArr[N - 1]) {
            ans = Math.min(ans, cnt);
        }
    }

    // 누르는 함수
    static char[] push(int num,char[] tempArr){

        for (int i = num-1; i <=num+1 ; i++) {
            if(i<0 || i>=N) continue;

            if(tempArr[i] == '0') tempArr[i] = '1';
            else tempArr[i] = '0';
        }

        return tempArr;
    }

}
