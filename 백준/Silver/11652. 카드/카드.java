import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];
        for(int i=0;i<N;i++) arr[i] = (Long.parseLong(br.readLine()));
        Arrays.sort(arr);
        long target = arr[0];
        int cnt = 1;
        int maxCnt =1;
        long maxTarget = arr[0];
        for(int i=1;i<N;i++){
            if(target == arr[i]) cnt++;
            else{
                if(maxCnt < cnt){
                    maxCnt = cnt;
                    maxTarget = target;
                }
                cnt = 1;
                target = arr[i];
            }
        }
        if(maxCnt < cnt){
            maxCnt = cnt;
            maxTarget = target;
        }
        System.out.println(maxTarget);
    }
}
