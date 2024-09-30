import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Deque<Character> frontStack = new ArrayDeque<>();
        Deque<Character> backStack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            frontStack.addLast(c);
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.charAt(0) == 'P'){
                String target = st.nextToken();
                frontStack.addLast(target.charAt(0));
            }
            else if(com.charAt(0) == 'L'){
                if(frontStack.isEmpty()) continue;
                backStack.addLast(frontStack.pollLast());
            }else if(com.charAt(0) == 'D'){
                if(backStack.isEmpty()) continue;
                frontStack.addLast(backStack.pollLast());
            }else if(com.charAt(0) == 'B'){
                if(frontStack.isEmpty()) continue;
                frontStack.pollLast();
            }
        }

        for(char c : frontStack){
            sb.append(c);
        }

//        for(int i=0;i<backStack.size();i++){
//            char c = backStack.pollLast();
//            System.out.println(c);
//            sb.append(c);
//        }
        while(!backStack.isEmpty()){
            char c = backStack.pollLast();
            sb.append(c);
        }

        System.out.println(sb);
    }
}
