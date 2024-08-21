import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        // 개수 저장 배열
        int[] arr = new int[10];
        int answer =0;

        for(char c: s.toCharArray()){
            // 개수 저장하기
            int num = Character.getNumericValue(c);

            // 6이나 9면 적은거에 저장
            if(num ==6 || num ==9){
                if(arr[6]<arr[9]) arr[6]++;
                else arr[9]++;
            }
            else arr[num]++;
        }

        for(int i=0;i<10;i++){
            if(arr[i]==0) continue;
            answer = Math.max(answer,arr[i]);
        }

        System.out.println(answer);
    }
}
