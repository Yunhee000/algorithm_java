import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean flag;
	static int[] home, festival;
	static Pair[] pairs;
	static boolean[] list;
	
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			list = new boolean[N];
			pairs = new Pair[N];
			
			st = new StringTokenizer(br.readLine());
			home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Pair p = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				pairs[i] = p;
			}
			
			st = new StringTokenizer(br.readLine());
			festival = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			flag = false;
			bfs(home);
			
			sb.append(flag ? "happy" : "sad").append("\n");
		}
		System.out.print(sb);
	}
	
	static void bfs(int[] start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			if (Math.abs(festival[0] - current[0]) + Math.abs(festival[1] - current[1]) <= 1000) {
				flag = true;
				return;
			}
			for (int i = 0; i < N; i++) {
				Pair p = pairs[i];
				if (Math.abs(p.x - current[0]) + Math.abs(p.y - current[1]) <= 1000) {
					if (!list[i]) {
						queue.offer(new int[] {p.x, p.y});
						list[i] = true;
					}
				}
				
			}
		}
	}
	
	

}
