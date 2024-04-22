import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Box{
		int idx;
		int W,H2,H;
		public Box(int idx, int w, int h2, int h) {
			super();
			this.idx = idx;
			W = w;
			H2 = h2;
			H = h;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> W = new ArrayList<>();
		int[] H = new int[N];
		int[][] wh = new int[N][2];
		// memo 배열
		int[][] memo = new int[N][2];
		Box[] boxs = new Box[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			boxs[i] = new Box(i, w, h2, h);
			
		}
		// 무게별 정렬
		Arrays.sort(boxs, (o1, o2) -> {
			return o1.W - o2.W;
		});
		
		for (int i = 0; i < N; i++) {
			W.add(boxs[i].idx);
		}
		
		// 넓이별 정렬
		Arrays.sort(boxs, (o1, o2) -> {
			return o1.H - o2.H;
		});
		
		for (int i = 0; i < N; i++) {
			H[i]=boxs[i].idx;
			wh[i][0] = H[i];
			wh[i][1] = W.indexOf(H[i]);
			
			//해당 인덱스에서의 자신의 높이 저장
			memo[i][1] = boxs[i].H2;
		}
		
		//LIS
		//무게를 기준으로 잡고 넓이 보기
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < N; i++) {
			
			int num = wh[i][1];
			//memo[i][0] : 높이 최대일때의 그 바로 앞 인덱스 저장
			memo[i][0] = i; //초기화
			int length = memo[i][1];
			int idx = i;
			
			for (int j = 0; j < i; j++) {
				if(num < wh[j][1]) continue;
				
				//최대 높이 구해주기
				if(length+memo[j][1] > memo[i][1]) {
					memo[i][1] = length+memo[j][1];
					idx = j;
				}
			}
			memo[i][0] = idx;
			max = Math.max(max, memo[i][1]);
			if(max <= memo[i][1]) maxIdx = i;
		}
		
		List<Integer> arr = new ArrayList<>();
		
		int idx = maxIdx;
		while(true) {
			int n = memo[idx][0];
			arr.add(H[idx]+1);
			if(n == idx) {
				break;
			}
			idx = n;
		}

		sb.append(arr.size()).append("\n");
		for (int i = arr.size()-1; i >=0; i--) {
			sb.append(arr.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
}

