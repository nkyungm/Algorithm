import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());
        if(nowY >0) arr.add(nowY);

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            if(nowY < nextY) {
                if(nextY > 0) arr.add(nextY);
            }else if(nowY > nextY) {
                // arrayList 다중 삭제
                arr.removeIf(item -> {
                    if (item > nextY) {
                        cnt++;
                        return true;
                    }
                    return false;
                });

                if(!arr.contains(Integer.valueOf(nextY)) && nextY >0) arr.add(nextY);
            }
            nowY = nextY;
        }
        System.out.println(cnt + arr.size());
    }
}
