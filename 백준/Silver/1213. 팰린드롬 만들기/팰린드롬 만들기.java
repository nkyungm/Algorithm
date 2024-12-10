import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] arr = new int[26];
        int hol = -1;

        for(char c : s.toCharArray()){
            arr[c-'A']++;
        }

        for(int i=0;i<26;i++){
            if(arr[i]==0) continue;
            char alphabet = (char)(i+'A');
            String sub = Character.toString(alphabet);
            sb.append(sub.repeat(arr[i]/2));
            if(arr[i]%2!=0){ // 홀수인 경우
                if(hol > -1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                hol = i;
            }
        }

        String start = sb.toString();
        String end = sb.reverse().toString();

        System.out.print(start);
        // 홀수 넣기
        if(hol > -1) {
            System.out.print((char)(hol + 'A'));
        }
        System.out.print(end);
    }
}
