import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        List<Student> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int ko = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int ma = Integer.parseInt(st.nextToken());
            list.add(new Student(name,ko,en,ma));
        }

        list.sort((o1,o2)->{
            if(o1.ko == o2.ko){
                if(o1.en==o2.en){
                    if(o1.ma==o2.ma){
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.ma - o1.ma;
                }
                return o1.en-o2.en;
            }
            return o2.ko - o1.ko;
        });

        for(int i=0;i<N;i++){
            sb.append(list.get(i).name).append("\n");
        }

        System.out.println(sb);
    }
    static class Student{
        String name;
        int ko;
        int en;
        int ma;

        Student(String name,int ko,int en,int ma){
            this.name= name;
            this.ko = ko;
            this.en= en;
            this.ma =ma;
        }
    }
}
