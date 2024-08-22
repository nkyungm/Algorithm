import java.util.*;
import java.io.*;

// 스택 사용으로 변경 -> 스택 2개 사용해서 커서 앞,뒤 나누기
// LinkedList에서 시간 초과 나는 이유 : 끝이나 처음에 넣는것이 아니면 O(N)이 걸리기 때문에 시간초과남

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();
        // 명령 개수
        int M = Integer.parseInt(br.readLine());

        // 스택 2개 생성
        Deque<Character> beforeStack = new ArrayDeque<Character>();
        Deque<Character> afterStack = new ArrayDeque<Character>();

        // 커서 전 스택에 s 값 넣기
        for(char c : s.toCharArray()) beforeStack.add(c);

        // 명령 시작
        for(int i=0;i<M;i++){
            String commend = br.readLine();
            StringTokenizer st = new StringTokenizer(commend);
            switch(st.nextToken()) {
                case "L": //커서 왼쪽으로 한칸 옮김(맨앞이면 무시)
                    if(beforeStack.isEmpty()) continue;
                    // 뒤에 있는거 커서이후 스택에 넣기
                    afterStack.add(beforeStack.pollLast());
                    break;
                case "D": // 커서 오른쪽으로 한칸 옮김(맨 뒤면 무시)
                    if(afterStack.isEmpty()) continue;
                    // 앞에 있는거 커서 이전 스텍에 넣기
                    beforeStack.add(afterStack.pollLast());
                    break;
                case "B": // 커서 왼쪽에 있는 문자 삭제(커서 문장 맨앞이면 무시)
                    if(beforeStack.isEmpty()) continue;
                    // 커서 전 스택의 맨 마지막 삭제
                    beforeStack.pollLast();
                    break;
                case "P": // 커서 왼쪽에 추가
                    char c = st.nextToken().charAt(0);
                    beforeStack.add(c);
                    break;
            }
        }
        while(!beforeStack.isEmpty()){
            sb.append(beforeStack.pollFirst());
        }
        while(!afterStack.isEmpty()){
            sb.append(afterStack.pollLast());
        }
        System.out.println(sb);
    }
}
