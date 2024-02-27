import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N,answer;
    static int[] startTeam, linkTeam;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        startTeam = new int[N/2];
        linkTeam = new int[N/2];
        isSelected = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        madeTeam(0,0);
        System.out.println(answer);
    }
    private static void madeTeam(int cnt,int start){
        //기저 조건
        if(cnt == N/2){
            int cnt2 = 0;
            for (int i = 0; i < N; i++) {
                if(!isSelected[i]) linkTeam[cnt2++] = i;
            }
            minPower(startTeam,linkTeam);
            return;
        }

        // 조합
        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            startTeam[cnt] = i;
            madeTeam(cnt+1,i+1);
            isSelected[i] = false;
        }
    }

    private static void minPower(int[] start,int[] link){
        int totalStartPower = 0;
        int totalLinkPower = 0;

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < N/2; j++) {
                if(i==j) continue;
                totalStartPower += arr[start[i]][start[j]];
                totalLinkPower += arr[link[i]][link[j]];
            }
        }

        answer = Math.min(Math.abs(totalStartPower-totalLinkPower),answer);
    }
}
