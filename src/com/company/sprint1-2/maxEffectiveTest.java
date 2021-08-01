import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class maxEffectiveTest {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.equals("get_max")) {
                System.out.println(max());
            }
            else if (command.equals("pop")) {
                if (pop().equals("error")) {
                    System.out.println("error");
                }
            }
            else if (command.contains("push")) {
                int number = StackMaxEffective.findNumberInCommand(command);
                push(number);
            }
        }
    }
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static void push(int value){
        String max = max();
        if (!max.equals("None") && value >= Integer.parseInt(max)) {
            s2.push(value);
        }
        s1.push(value);
    }

    public static String pop() {
        if (s1.size() == 0) {
            return ("error");
        }
        else {
            Integer value = s1.pop();
            if (!max().equals("None") && value == Integer.parseInt(max())) {
                s2.pop();
            }
            return value.toString();
        }
    }

    public static String max() {
        if (s2.isEmpty()) {
            return "None";
        } else {
            return s2.peek().toString();
        }
    }
} 