import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Person implements Comparable<Person> {
        int i,age;
        String name;

        public Person(int i, int age, String name) {
            this.i = i;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if(this.age == o.age){
                return this.i - o.i;
            }
            return this.age - o.age;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        int N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];

        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            Person p = new Person(i,Integer.parseInt(st.nextToken()),st.nextToken());
            arr[i] = p;
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            Person p = arr[i];
            System.out.println(p.age+" "+p.name);
        }
    }
}
