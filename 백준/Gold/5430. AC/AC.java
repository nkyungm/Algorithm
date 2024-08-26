import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        for(int t= 0;t<T;t++){
            String P = br.readLine();
            char Rtype = 'F'; //뒤집는 타입 설정
            Deque<Integer> deque = new ArrayDeque<>();

            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            // 문자열 가공
            s = s.substring(1,s.length()-1);
            st = new StringTokenizer(s,",");

            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                deque.add(num);
            }

            boolean flag = true;
            for(char p:P.toCharArray()){ //toCharArray 잘 외우기
                if(!flag) break;
                switch(p){
                    case 'R': //타입 변경해주기
                        if(Rtype =='F') Rtype = 'L';
                        else Rtype='F';
                        break;
                    case 'D':
                        if(deque.isEmpty()){
                            flag = false;
                            sb.append("error").append("\n");
                            break; // 여기서 바로 종료됨
                        }
                        if(Rtype=='F') deque.pollFirst();
                        else deque.pollLast();
                        break;
                }
            }
            if(!flag) continue;
            sb.append("[");
            while(!deque.isEmpty()){
                if(Rtype=='F'){
                    if(deque.size()==1) sb.append(deque.pollFirst());
                    else sb.append(deque.pollFirst()).append(",");
                }else {
                    if(deque.size()==1) sb.append(deque.pollLast());
                    else sb.append(deque.pollLast()).append(",");
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}
