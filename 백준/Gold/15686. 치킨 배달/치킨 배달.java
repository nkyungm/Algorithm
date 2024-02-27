import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static List<int[]> chicken;
	static boolean[] isSelected;
	static List<int[]> chickenSet;
	static int ans =Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		chicken = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 치킨 집 저장
				if(arr[i][j] ==2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		isSelected = new boolean[chicken.size()];
		minChickenLoad(0, isSelected,0);
		
		System.out.println(ans);
	}
	
	static void minChickenLoad(int cnt, boolean[] isSelected,int m) {
		
		// 기저 조건
		if(cnt == chicken.size()) {
			if(m>0 && m <= M) {
				chickenSet = new ArrayList<>();
				for (int i = 0; i < chicken.size(); i++) {
//					if(isSelected[i]) {
//						System.out.print("치킨좌표 : "+chicken.get(i)[0]+" "+chicken.get(i)[1]+" ");
//						System.out.println();
//						System.out.print(i +" ");
//					}
					if(isSelected[i]) {
						chickenSet.add(chicken.get(i));
					}
					if(calculateChickenLoad(chickenSet)>0) {
						ans = Math.min(calculateChickenLoad(chickenSet),ans);
					}
					
				}
				
//				for (int i = 0; i < chickenSet.size(); i++) {
//					System.out.println(chickenSet.get(i)[0]+ " "+chickenSet.get(i)[1]);
//				}System.out.println();
				
				// 경우의 수별로 치킨 거리 계산 함수
				
				// ans = Math.min(calculateChickenLoad(chickenSet),ans);
//				System.out.println();
			}
			return;
		}
		
		isSelected[cnt] = true;
		minChickenLoad(cnt+1,isSelected,m+1);
		isSelected[cnt] = false;
		minChickenLoad(cnt+1,isSelected,m);
	}
	
	static int calculateChickenLoad(List<int[]> chicken2) {
		int total =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집인 경우
				if(arr[i][j] ==1) {
					int minNum = Integer.MAX_VALUE;
					for (int j2 = 0; j2 < chicken2.size(); j2++) {
						minNum = Math.min(minNum, Math.abs(i-chicken2.get(j2)[0])+Math.abs(j-chicken2.get(j2)[1]));
					}
					// System.out.println("min: "+minNum);
					total += minNum;
				}
				
			}
		}
		
		return total;
	}
}
