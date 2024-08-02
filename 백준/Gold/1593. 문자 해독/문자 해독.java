import java.util.*;
import java.io.*;

/**
 * 1. 알파벳별로 list에 개수 넣기
 * 투포인터
 */

public class Main {
    static int g,s;
    static String W,S;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        W = br.readLine();
        S = br.readLine();

        // 52인 이유 : 알파벳 소문자,대문자 총 숫자 52개
        int[] Warr = new int[52];
        int[] Sarr = new int[52];

        // 알파벳 개수 넣기
        for(char c:W.toCharArray()){
            putWord(c,Warr,1);
        }
        // 슬라이딩 윈도우
        int start = 0;
        int cnt = 0;
        int size = 0;
        for(int i=0;i<s;i++){
            char c = S.charAt(i);
            putWord(c,Sarr,1); // 개수 추가
            size++;

            if(size == g){
                // 배열끼리 전체 요소같은지 확인
                if(Arrays.equals(Warr,Sarr)) cnt++;
                putWord(S.charAt(start),Sarr,-1);
                start++;
                size--;
            }
        }
        System.out.println(cnt);

    }
    static void putWord(char c,int[] arr,int diff){
        if(c>='a' && c<='z'){
            arr[c-'a'] += diff;
        }else{
            arr[c-'A'+26] += diff;
        }
    }
}