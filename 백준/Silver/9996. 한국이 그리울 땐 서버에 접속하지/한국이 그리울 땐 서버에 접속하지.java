import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        // 별표 앞 뒤로 나누기
        String[] split = s.split("\\*");
        String start = split[0];
        String end = split[1];

        for(int i=0;i<N;i++){
            String s1 = br.readLine();
            // 맞는지 체크
            if(s1.startsWith(start) && s1.endsWith(end) && s1.length() >= start.length()+end.length())
                sb.append("DA\n");
            else sb.append("NE\n");
        }

        System.out.println(sb);
    }
}
