import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, W, H, map[][], number[], map2[][];
	static int minmarble;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			number = new int[N];
			
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minmarble = 1_000_000_000;
			perm(0);
			sb.append(minmarble).append("\n");
		}
		System.out.print(sb);
	}
	
	static void perm(int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(number));
			marble();
			return;
		}
		for (int i = 0; i < W; i++) {
			number[cnt] = i;
			perm(cnt+1);
		}
	}
	
	static void marble() {
		map2 = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
//			System.out.println(number[i]);
			int y = number[i];
			int x = -1;
			for (int j = 0; j < H; j++) {
				if (map2[j][y] != 0) {
					x = j;
					break;
				}
			}
			if (x == -1) continue;
//			System.out.println(x + " " + y);
			hit(x, y);
//			System.out.println(Arrays.deepToString(map2));
			move();
//			System.out.println(Arrays.deepToString(map2));
		}
		minmarble = Math.min(minmarble, count());
	}
	
	static int count() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map2[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}
	
	static void move() {
		int[][] m = new int[H][W];
		for (int i = 0; i < W; i++) {
			int[] a = new int[H];
			int idx = 0;
			for (int j = H-1; j >= 0; j--) {
				if (map2[j][i] != 0)
					a[idx++] = map2[j][i];
			}
			for (int j = 0; j < H; j++) {
				m[j][i] = a[H-1-j];
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map2[i][j] = m[i][j];
			}
		}
	}
	
	static void hit(int x, int y) {
		int tmp = map2[x][y];
		map2[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < tmp; j++) {
				int a = x + dx[i] * j;
				int b = y + dy[i] * j;
				if (valid(a, b) && map2[a][b] != 0) {
					hit(a, b);
				}
			}
			
		}
	}
	
	static boolean valid(int x, int y) {
		if (x > -1 && x < H && y > -1 && y < W)
			return true;
		else
			return false;
	}
}
