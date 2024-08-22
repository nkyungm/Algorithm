import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String s = br.readLine();
            // 스택 2개 생성
            Deque<Character> beforeStack = new ArrayDeque<>();
            Deque<Character> afterStack = new ArrayDeque<>();
            StringBuffer sb = new StringBuffer();

            for(char m : s.toCharArray()){
                // < / > / - / 알파벳인경우
                switch(m) {
                    case '<': //커서 왼쪽 이동
                        if (beforeStack.isEmpty()) continue;
                        afterStack.add(beforeStack.pollLast());
                        break;
                    case '>': //커서 오른쪽 이동
                        if (afterStack.isEmpty()) continue;
                        beforeStack.add(afterStack.pollLast());
                        break;
                    case '-': //백스페이스
                        if (beforeStack.isEmpty()) continue;
                        beforeStack.pollLast();
                        break;
                    default: // 문자 입력
                        beforeStack.add(m);
                }
            }
            while(!beforeStack.isEmpty()) sb.append(beforeStack.pollFirst());
            while(!afterStack.isEmpty()) sb.append(afterStack.pollLast());
            System.out.println(sb);
        }
    }
}
