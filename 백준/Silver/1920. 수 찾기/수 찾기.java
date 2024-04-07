import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(binarysearch(key, 0, N-1) != -1 ? 1 : 0).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int binarysearch(int key, int low, int high) {
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				low = mid+1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
