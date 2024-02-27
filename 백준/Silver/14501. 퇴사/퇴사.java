import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static List<Integer> list;

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        setCall(0);
        System.out.println(ans);
    }
    private static void setCall(int day){
        // 기저 조건
        if(day >= N){
            calculateMaxValue(list);
            return;
        }

        for (int i = day; i < N; i++) {
            if(i+arr[i][0] <= N) {
                list.add(i);
                setCall(i+arr[i][0]);
                list.remove(list.indexOf(i));
            }
            setCall(i+arr[i][0]);
        }
    }

    private static void calculateMaxValue(List<Integer> list){
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total+= arr[list.get(i)][1];
        }
        ans = Math.max(ans,total);
    }
}
