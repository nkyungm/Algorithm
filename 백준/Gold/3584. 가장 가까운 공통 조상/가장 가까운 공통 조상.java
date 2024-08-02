import java.util.*;
import java.io.*;


public class Main{
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N= Integer.parseInt(br.readLine());
            arr = new int[N+1];
            for(int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                arr[child] = parent; //바로 위의 부모 노드 저장
            }
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            sb.append(search(num1,num2)).append("\n");
        }
        System.out.println(sb);
    }
    static int search(int n1,int n2){
        //1. set 각자 2개 만들어서 끝까지 넣기
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int idx = n1;
        while(arr[idx] > 0){
            arr1.add(idx);
            idx = arr[idx];
        }arr1.add(idx);
        idx = n2;
        while(arr[idx] > 0){
            arr2.add(idx);
            idx = arr[idx];
        }arr2.add(idx);
        //2. 교집합
        arr1.retainAll(arr2);
        return arr1.get(0);
    }
}