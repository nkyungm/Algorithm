import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] LCS;
    static char[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int cnt = LCS_cnt(str1,str2);
        result = new char[cnt];

        System.out.println(cnt);
        LCS_str(str1,str2);
        for (int i = result.length-1; i >=0 ; i--) {
            System.out.print(result[i]);
        }

    }
    // LCS 길이 구하는 함수
    static int LCS_cnt(String str1, String str2){
        LCS = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length() ; i++) {
            char nowC = str1.charAt(i-1);
            for (int j = 1; j <= str2.length() ; j++) {
                // 문자가 동일할 경우
                if(nowC == str2.charAt(j-1)) {
                    LCS[i][j] = LCS[i-1][j-1] +1;
                }else{ // 문자가 동일하지 않을 경우
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        return LCS[str1.length()][str2.length()];
    }

    // LCS가 되는 문자열 구하는 함수
    static void LCS_str(String str1, String str2){
        // 가장 마지막 값에서 시작
        int i = str1.length();
        int j = str2.length();
        int idx = 0;

        // 0이기 전까지 반복
        while(LCS[i][j] > 0){
            if(LCS[i][j] == LCS[i-1][j]){
                i--;
            }
            else if(LCS[i][j] == LCS[i][j-1]){
                j--;
            }else{
                result[idx++] = str1.charAt(i-1);
                i--; j--;
            }
        }
    }
}
