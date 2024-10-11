import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Person(i,Integer.parseInt(st.nextToken()),st.nextToken()));
        }
        Collections.sort(list,(o1,o2)
                ->(o1.age == o2.age) ? o1.idx-o2.idx : o1.age - o2.age);

        for(int i=0;i<N;i++){
            sb.append(list.get(i).age).append(" ").append(list.get(i).name);
            sb.append("\n");
        }
        System.out.println(sb);


    }
    static class Person{
        int idx;
        int age;
        String name;
        Person(int idx,int age,String name){
            this.idx =idx;
            this.age =age;
            this.name =name;
        }
    }
}
