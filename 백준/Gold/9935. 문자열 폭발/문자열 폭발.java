import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String str2 = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            stack.push(c);
            if (stack.size() < str2.length()){
                continue;
            }

            if (c == str2.charAt(str2.length() - 1)) {
                boolean flag = true;
                int idx = stack.size() - 1;
                int idx2 = str2.length() - 1;
                for (int j = 1; j < str2.length(); j++) {
                    int id = idx - j;
                    if (str2.charAt(idx2 - j) != stack.get(id)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < str2.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            for (Character c : stack) {
                sb.append(c);
            }
        } else {
            sb.append("FRULA");
        }
        System.out.println(sb);
    }
}