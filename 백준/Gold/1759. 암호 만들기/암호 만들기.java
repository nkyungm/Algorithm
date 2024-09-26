import java.util.*;
import java.io.*;
public class Main {
    static int L;
    static int C;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        Combination(0,new char[L],0);
        System.out.println(sb);

    }
    // 조합
    static void Combination(int cnt,char[] selected,int selectNum){
        if(cnt == L){
            if(check(selected)){
                for(int i=0;i<L;i++){
                    sb.append(selected[i]);
                }sb.append("\n");
            }
            return;
        }
        for(int i=selectNum;i<C;i++){
            selected[cnt] = arr[i];
            Combination(cnt+1,selected,i+1);
        }
    }
    static boolean check(char[] selected){
        int aCnt = 0; // 모음(최소1개)
        int bCnt = 0; // 자음(최소2개)
        for(char c : selected){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                aCnt++;
            }else bCnt++;
        }
        if(aCnt < 1 || bCnt < 2) return false;
        return true;
    }
}
