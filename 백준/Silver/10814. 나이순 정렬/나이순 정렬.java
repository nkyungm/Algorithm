import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Person[] list = new Person[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int pOld = Integer.parseInt(st.nextToken());
            String pName = st.nextToken();
            list[i] = new Person(i,pOld,pName);
        }
        Arrays.sort(list,(o1,o2)-> (o1.old == o2.old) ? (o1.idx - o2.idx) : (o1.old - o2.old));

        for(int i=0;i<N;i++){
            sb.append(list[i].old);
            sb.append(" ");
            sb.append(list[i].name);
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static class Person{
        int idx;
        int old;
        String name;

        public Person(int idx,int old,String name){
            this.idx = idx;
            this.old = old;
            this.name = name;
        }
    }
}
