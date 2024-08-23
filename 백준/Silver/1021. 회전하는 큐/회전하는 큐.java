import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        // arrayList로 저장
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++) list.add(i);
        st = new StringTokenizer(br.readLine());
        // M 입력받음
        for(int i=0;i<M;i++) {
            int findNum = Integer.parseInt(st.nextToken());
            // 인덱스 반보다 더 큰경우 -> 3번 적용
            if(list.size()/2 < list.indexOf(findNum)){
                while(list.get(0) != findNum){ //맨앞에 findNum일때까지 진행
                    list.add(0,list.remove(list.size()-1));
                    answer++;
                }
                list.remove(0);
            }else{ // 더 작거나 같은경우 -> 2번 적용
                while(list.get(0) != findNum){ //맨앞에 findNum일때까지 진행
                    list.add(list.remove(0));
                    answer++;
                }
                list.remove(0);
            }
        }
        System.out.println(answer);
    }
}
