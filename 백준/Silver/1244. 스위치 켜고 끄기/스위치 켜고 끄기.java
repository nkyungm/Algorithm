import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int S = Integer.parseInt(br.readLine());
		boolean[] graph = new boolean[S+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= S; i++) {
			graph[i] = (st.nextToken().equals("1")?true:false);
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine());
			 int gender = Integer.parseInt(st.nextToken());
			 int num = Integer.parseInt(st.nextToken());
			 
			 if(gender ==1) {
				 for (int j = 1; j < graph.length; j++) {
					if(j%num==0) {
						graph[j] = !graph[j];
					}
				}
				 
			 }else if(gender ==2) {
				 int idx =0;
				 for (int j = 0; j < graph.length; j++) {
					if(((num-idx)>0 && (num+idx<=S)) && graph[num-idx] == graph[num+idx]) {
						idx++;
					}else {
						break;
					}
				}
				 for(int j=0;j<idx;j++) {
					 if(j==0) {
						 graph[num+j] = !graph[num+j];
					 }else {
						 graph[num+j] = !graph[num+j];
						 graph[num-j] = !graph[num-j];
					 }
				 }
			 }
			
		 }
		 for (int i = 1; i < graph.length; i++) {
			 System.out.print((graph[i]==true?1:0));
			if(i%20==0) {
				System.out.println();
			}else {
				System.out.print(" ");
			}
			
		}
	}
}
