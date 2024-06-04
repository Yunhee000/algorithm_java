import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        arr = new int[21];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")){
                for (int j = 1; j <= 20; j++){
                    arr[j] = 1;
                }
                continue;
            } else if (str.equals("empty")){
                for (int j = 1; j <= 20; j++){
                    arr[j] = 0;
                }
                continue;
            }
            int a = Integer.parseInt(st.nextToken());
            if (str.equals("add")){
                arr[a] = 1;
            } else if (str.equals("remove")){
                arr[a] = 0;
            } else if (str.equals("check")){
                sb.append(arr[a] == 1 ? 1 : 0).append("\n");
            } else if (str.equals("toggle")){
                if (arr[a] == 1) arr[a] = 0;
                else arr[a] = 1;
            }
        }
        System.out.println(sb);
    }
}
