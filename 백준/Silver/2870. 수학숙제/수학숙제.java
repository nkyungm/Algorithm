import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sbb = new StringBuilder();
    static ArrayList<Element> answer = new ArrayList<>();

    static class Element implements Comparable<Element> {
        String value;

        Element(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(Element o) {
            if (o.value.length() != this.value.length()) {
                return this.value.length() - o.value.length();
            }
            return this.value.compareTo(o.value);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N --> 0){
            char[] cArr = br.readLine().toCharArray();
            for(char c : cArr){
                // 소문자일 경우 go()
                if(c >='a' && c<='z'){
                    if(sbb.length() != 0) go();
                }
                // 숫자일 경우 sbb에 넣기
                else{
                    sbb.append(c);
                }
            }
            if(sbb.length() != 0) go();
        }
        // 정렬
        Collections.sort(answer);

        // 출력
        for (Element s : answer) sb.append(s.value).append("\n");

        System.out.println(sb);
    }
    // 숫자 배열에 넣는 함수
    static void go() {
        // 1. while문 돌리면서 맨 앞이 0이고 길이가 0보다 클때 맨 앞에 지우기
        while(true){
            if(sbb.length() != 0 && sbb.charAt(0) == '0'){
                sbb.delete(0,1);
            }
            else break;
        }
        // 길이가 0인경우 "0" 넣기
        if(sbb.length()==0) sbb.append("0");
        answer.add(new Element(sbb.toString()));
        sbb =new StringBuilder();
    }
}
