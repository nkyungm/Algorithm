import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,L;
    static int[] restArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
        M = Integer.parseInt(st.nextToken()); // 더 지으려는 휴게소 개수
        L = Integer.parseInt(st.nextToken()); // 고속도록 길이

        restArea = new int[N+2];
        restArea[0] = 0; // 맨 처음 지점
        restArea[N+1] = L; // 맨 끝 지점
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            restArea[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(restArea);

        System.out.println(lower_bound(1,L-1,M));
    }
    // 이분 탐색(최저점 찾기)
    static int lower_bound(int min,int max,int key){
        int mid = 0;
        while(min < max){
            mid = (min+max)/2;

            if(count(mid) <= key){ //max 내리기
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }
    // 휴게소 설치 가능한 개수 구하는 함수
    static int count(int mid) {
        int cnt = 0;
        for (int i = 1; i < restArea.length; i++) {
            int diff = restArea[i] - restArea[i-1];
            if(diff <= mid) continue;
            // 휴게소 세우기
            for (int current = restArea[i-1]; current < restArea[i] ;) {
                int next = current+mid;

                if(next < restArea[i]) cnt+=1;
                current = next;
            }

        }
        return cnt;
    }
}
