import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][][] LCS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        System.out.println(LCS_cnt(str1,str2,str3));
    }
    // 3차원 DP
    static int LCS_cnt(String str1, String str2, String str3){
        LCS = new int[str1.length()+1][str2.length()+1][str3.length()+1];

        for (int i = 1; i <= str1.length() ; i++) {
            char c1 = str1.charAt(i-1);
            for (int j = 1; j <= str2.length(); j++) {
                char c2 = str2.charAt(j-1);

                for (int k = 1; k <= str3.length() ; k++) {
                    char c3 = str3.charAt(k-1);
                    if(c1 == c2 && c2 == c3) {
                        LCS[i][j][k] = LCS[i-1][j-1][k-1] +1;
                    }else if(c1 == c2){
                        LCS[i][j][k] = Math.max(LCS[i-1][j-1][k],LCS[i][j][k-1]);
                    }else if(c2 == c3){
                        LCS[i][j][k] = Math.max(LCS[i][j-1][k-1],LCS[i-1][j][k]);
                    }else if(c1 == c3){
                        LCS[i][j][k] = Math.max(LCS[i-1][j][k-1],LCS[i][j-1][k]);
                    }else{
                        LCS[i][j][k] = Math.max(Math.max(LCS[i - 1][j][k], LCS[i][j - 1][k]), LCS[i][j][k - 1]);
                    }
                }

            }
        }
        return LCS[str1.length()][str2.length()][str3.length()];
    }
}
