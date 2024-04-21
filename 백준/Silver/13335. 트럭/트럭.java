import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,W,L;
    static PriorityQueue<Truck> pq = new PriorityQueue<>();
    static class Truck implements Comparable<Truck>{
        int idx,x,len;

        public Truck(int idx, int x, int len) {
            this.idx = idx;
            this.x = x;
            this.len = len;
        }

        @Override
        public int compareTo(Truck o) {
            return this.idx - o.idx;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", len=" + len +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            pq.add(new Truck(i,t,W+1));
        }

        go();
    }
    static void go(){
        int Time = 0;
        List<Truck> list;
        while(!pq.isEmpty()){
            Time++;
            int SUM = 0;
            list = new ArrayList<>();

            // 맨앞에 있는 트럭
            Truck t = pq.poll();

            //이 트럭이 처음 다리를 건너는 경우
            if(t.len == W+1) {
                // System.out.println(Time + " "+t.x);
                if(t.len-1==0) continue;
                pq.add(new Truck(t.idx,t.x,t.len-1));
                continue;
            }

            //처음이 아닌 경우
            int LEN = Math.min(pq.size(), (W+1)-(t.len-1));
            if(t.len-1 !=0) {
                list.add(new Truck(t.idx, t.x, t.len - 1));
                SUM += t.x;
            }

            for (int i = 0; i < LEN; i++) {
                Truck t2 = pq.peek();
                // 무게 초과할 경우
                if(SUM+t2.x > L) break;
                // 무게 초과하지 않을 경우
                t2 = pq.poll();
                SUM+=t2.x;
                if(t2.len-1 !=0) list.add(new Truck(t2.idx,t2.x,t2.len-1));
                if(t2.len==W+1) break;
            }

            // System.out.println(Time +" " +list.toString());

            // list에 담긴 트럭 다시 pq에 추가
            for (int i = 0; i < list.size(); i++) {
                pq.add(list.get(i));
            }
        }
        System.out.println(Time);
    }
}
