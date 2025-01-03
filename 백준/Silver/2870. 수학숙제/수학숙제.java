import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<String> answer = new ArrayList<>();

        while(N --> 0){
            char[] arr = br.readLine().toCharArray();
            for(int i=0;i<arr.length;i++){
                // 소문자인 경우
                if(arr[i] >= 'a' && arr[i] <= 'z'){
                    // sb에 숫자 있으면 배열에 넣기
                    String num = sb.toString();
                    if(num.isEmpty()) continue;
                    char[] c = num.toCharArray();
                    // 1. size가 1인경우 그냥 넣기
                    // if(c.length == 1) answer.add(num);
                    // 2. 0빼고 맨 앞의 인덱스 찾기
                    // 중요 : 다 0인 경우 고려
                    int idx = 0;
                    for(int j=0;j<c.length;j++){
                        if(c[j] == '0') continue;
                        idx = j;
                        break;
                    }
                    if(c[idx] == '0') answer.add("0");
                    else answer.add(num.substring(idx,c.length));

                    sb = new StringBuilder();
                }else{
                    sb.append(arr[i]);
                }
            }
            String num = sb.toString();
            if(!num.isEmpty()) {
                char[] c = num.toCharArray();
                int idx = 0;
                for(int j=0;j<c.length;j++){
                    if(c[j] == '0') continue;
                    idx = j;
                    break;
                }
                if(c[idx] == '0') answer.add("0");
                else answer.add(num.substring(idx,c.length));
            }
            sb = new StringBuilder();
        }
        // 정렬
        Collections.sort(answer,(a1,a2) ->{
            if(a1.length() == a2.length()) return a1.compareTo(a2);
            else return a1.length() - a2.length();
        });

        // 출력
        for(int i=0;i<answer.size();i++) sb.append(answer.get(i)).append("\n");

        System.out.println(sb);
    }
}
