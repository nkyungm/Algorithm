import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =null;

        int T = Integer.parseInt(br.readLine());
        Goal[] arr = new Goal[T];
        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] sArr = st.nextToken().split(":");
            int M = Integer.parseInt(sArr[0]) * 60;
            arr[i] = new Goal(team, M + Integer.parseInt(sArr[1]));
        }
        // 정렬
        Arrays.sort(arr,(o1,o2) -> (o1.time > o2.time) ? o1.time-o2.time: o2.time-o1.time);

        int[] teamArr = new int[3];
        int[] answer = new int[3];

        for(int i = 0;i<arr.length;i++){
            // team에 승점 +1하기
            teamArr[arr[i].team]++;
            // 만약 같으면 그냥 넘어가기
            if(teamArr[1] == teamArr[2]) continue;
            // 어느 한곳이 크면 뒤에꺼 빼기 지금꺼 해서 answer에 넣기
            if(teamArr[1] > teamArr[2]){
                if(i==T-1){ // 마지막인 경우
                    answer[1] += (48*60) - arr[i].time;
                }else answer[1] += arr[i+1].time - arr[i].time;
            }else{
                if(i==T-1){ // 마지막인 경우
                    answer[2] += (48*60) - arr[i].time;
                }else answer[2] += arr[i+1].time - arr[i].time;
            }
        }

        System.out.printf("%02d:%02d\n",answer[1]/60,answer[1]%60);
        System.out.printf("%02d:%02d",answer[2]/60,answer[2]%60);
    }
    static class Goal{
        int team;
        int time;
        Goal(int team, int time){
            this.team = team;
            this.time = time;
        }
    }
}
