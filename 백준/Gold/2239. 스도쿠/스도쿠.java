import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int[][] sudoku;
	static List<int[]> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		sudoku = new int[9][9];
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = str.charAt(j) - '0';
				if (sudoku[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		
		play(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static boolean play(int idx) {
		if (idx == list.size()) {
			return true;
		}
		int a = list.get(idx)[0];
		int b = list.get(idx)[1];
		for (int i = 1; i <= 9; i++) {
			if (check(a, b, i)) {
				sudoku[a][b] = i;
				boolean flag = play(idx+1);
				if (flag) {
					return true;
				}
				sudoku[a][b] = 0;
			}
		}
		return false;
	}
	
	private static boolean check(int x, int y, int value) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == value)
				return false;
			if (sudoku[i][y] == value)
				return false;
		}
		int a = x/3*3;
		int b = y/3*3;
		for (int i = a; i < a+3; i++) {
			for (int j = b; j < b+3; j++) {
				if (sudoku[i][j] == value)
					return false;
			}
		}
		return true;
	}
}
