import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[], N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int count = 1;
		boolean flag = false;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i+1] == arr[i]) {
				if (i == N-2)
					flag = true;
				count++;
			} else {
				hmap.put(arr[i], count);
				count = 1;
			}
		}
		if (flag == true) {
			hmap.put(arr[N-1], count);
		} else {
			hmap.put(arr[N-1], 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
//			int c = binarysearch(num, 0, N-1);
			int result = 0;
			if (hmap.get(num) != null) result = hmap.get(num);
			sb.append(result).append(" ");
		}
		System.out.print(sb);
	}
	
	static int binarysearch(int key, int low, int high) {
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
}
