import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static int[][] water;
	static int R, C, mintime;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	static Queue<int[]> wqueue;
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		wqueue = new ArrayDeque<>();
		visited = new boolean[R][C];
		water = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(water[i], INF);
		}
		mintime = INF;
		
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '*') {
					wqueue.offer(new int[] {i, j, 1});
					water[i][j] = 1;
				}
				if (map[i][j] == 'S') {
					x = i;
					y = j;
				}
			}
		}
		
		bfswater();
		bfs(x, y);
		System.out.println(mintime != INF ? mintime : "KAKTUS");
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y, 1});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = current[0] + dx[i];
				int b = current[1] + dy[i];
				if (valid(a, b) && map[a][b] == 'D') {
					mintime = Math.min(mintime, current[2]);
				}
				if (valid(a, b) && !visited[a][b] && map[a][b] == '.' && water[a][b] > current[2]+1) {
					map[current[0]][current[1]] = '.';
					map[a][b] = 'S';
					visited[a][b] = true;
					queue.offer(new int[] {a, b, current[2]+1});
				}
			}
		}
	}
	
	static void bfswater() {
		while(!wqueue.isEmpty()) {
			int[] current = wqueue.poll();
			for (int i = 0; i < 4; i++) {
				int a = current[0] + dx[i];
				int b = current[1] + dy[i];
				if (valid(a, b) && water[a][b] == INF && map[a][b] == '.') {
					water[a][b] = current[2]+1;
					wqueue.offer(new int[] {a, b, current[2]+1});
				}
			}
		}
	}
	
	static boolean valid(int x, int y) {
		if (x > -1 && x < R && y > -1 && y < C)
			return true;
		else
			return false;
	}
	
}
