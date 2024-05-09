import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] note1;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			note1 = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(note1);
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int a = Integer.parseInt(st.nextToken());
				int ans = binarysearch(a);
				sb.append(ans != -1 ? 1 : 0).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static int binarysearch(int key) {
		int start = 0;
		int end = N-1;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if (note1[mid] > key) {
				end = mid - 1;
			} else if (note1[mid] < key) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
