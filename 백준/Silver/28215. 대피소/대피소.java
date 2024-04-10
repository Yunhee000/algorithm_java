import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<int[]> home;
	static int N, K, result;
	static boolean visited[];
	static int[] num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<>();
		visited = new boolean[N];
		num = new int[K];
		result = 1_000_000_000;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			home.add(new int[] {a, b});
		}
		
		comb(0, 0);
		System.out.println(result);
	}
	
	static void comb(int idx, int cnt) {
		if (cnt == K) {
			int maxcalc = calc();
			result = Math.min(maxcalc, result);
			return;
		}
		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				num[cnt] = i;
				visited[i] = true;
				comb(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	
	static int calc() {
		int maxc = 0;
		for (int i = 0; i < N; i++) {
			int a = 1_000_000_000;
			int[] h = home.get(i);
			for (int j = 0; j < K; j++) {
				int[] p = home.get(num[j]);
				int b = Math.abs(h[0] - p[0]) + Math.abs(h[1] - p[1]);
				a = Math.min(a,  b);
			}
			maxc = Math.max(a, maxc);
		}
		return maxc;
	}
}
