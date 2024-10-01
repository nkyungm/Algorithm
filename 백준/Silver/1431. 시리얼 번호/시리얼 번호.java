import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(br.readLine());
        }

        Collections.sort(list,(o1,o2) ->{
            if(o1.length() == o2.length()){
                // 길이 같으면 숫자만 다 더해서 더 작은거
                int aSum = 0;
                int bSum = 0;
                for(int i=0;i<o1.length();i++){
                    if(o1.charAt(i) >= 'A' && o1.charAt(i) <= 'Z') continue;
                    aSum += Character.getNumericValue(o1.charAt(i));
                }
                for(int i=0;i<o2.length();i++){
                    if(o2.charAt(i) >= 'A' && o2.charAt(i) <= 'Z') continue;
                    bSum += Character.getNumericValue(o2.charAt(i));
                }
                if(aSum == bSum){
                    return o1.compareTo(o2);
                }
                return aSum - bSum;
            }
            return o1.length() - o2.length();
        }
        );

        for(int i=0;i<N;i++){
           sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
