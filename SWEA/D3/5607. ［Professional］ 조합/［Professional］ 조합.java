import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static final long a = 1234567891;
	static long[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			list = new long[N+1];
			list[0] = 1;
			list[1] = 1;
			for (int i = 2; i <= N; i++) {
				long an = list[i-1] * i % a;
				list[i] = an;
			}
			
			long b = list[R];
			long c = list[N-R];
			
			long k = b * c % a;
			long kk = myPow(k, a - 2) % a;
			
			sb.append(list[N] * kk % a).append("\n");
		}
		System.out.print(sb);
	}
	
	private static long myPow(long a, long b) {
		if (b == 0)
			return 1;
		if (b % 2 == 1)
			return (myPow(a, b - 1) % 1234567891) * a % 1234567891;
		else
			return myPow(a * a % 1234567891, b / 2) % 1234567891;
	}
}
