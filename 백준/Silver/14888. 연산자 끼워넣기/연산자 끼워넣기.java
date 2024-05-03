import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    // Deque 사용 문제 + 백트래킹

    static int N;
    static int[] ops;
    static Deque<Integer> deque;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        N = Integer.parseInt(br.readLine());
        ops = new int[4];
        deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            deque.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);
        System.out.println(max);
        System.out.println(min);
    }
    static void backtracking(int cnt){
        // 기저 조건
        if(cnt == N-1){
            int sum = deque.poll();
            min = Math.min(min,sum);
            max = Math.max(max,sum);
            deque.addFirst(sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(ops[i] <=0) continue;
            ops[i] --;
            int num1 = deque.pollFirst();
            int num2 = deque.pollFirst();
            int result = caculate(num1,num2,i);

//            System.out.println(num1 + " "+ num2+ " "+i);
//            System.out.println(deque);
            deque.addFirst(result);
            backtracking(cnt+1);

            deque.pollFirst();
            deque.addFirst(num2);
            deque.addFirst(num1);
            ops[i]++;
        }
    }
    static int caculate(int num1,int num2,int i){
        switch (i){
            case 0:
                return num1+num2;
            case 1:
                return num1-num2;
            case 2:
                return num1*num2;
            case 3:
                return num1/num2;
        }
        return 0;
    }
}
