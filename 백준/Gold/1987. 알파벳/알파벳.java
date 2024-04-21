import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] board;
	static boolean[] selected, visited[];
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	static int R, C, result = 1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		selected = new boolean[27];
		visited = new boolean[R][C];
		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j) - 'A';
			}
		}
		selected[board[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(result);
	}
	
	static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			if (valid(a, b)) {
				int k = board[a][b];
				if (!selected[k]) {
					selected[k] = true;
					result = Math.max(result, cnt+1);
					dfs(a, b, cnt+1);
					selected[k] = false;
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
