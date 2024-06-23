import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] numbers;
    static List<Integer> nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (nums.contains(n)) continue;
            nums.add(n);
        }

        Collections.sort(nums);
        numbers = new int[M];
        num(0, 0);
        System.out.println(sb);
    }

    static void num(int n, int cnt){
        if (cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = n; i < nums.size(); i++) {
            numbers[cnt] = nums.get(i);
            num(i, cnt + 1);
        }
    }
}
