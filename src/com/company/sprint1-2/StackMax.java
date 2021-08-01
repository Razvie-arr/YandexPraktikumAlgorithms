import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackMax {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 10000) {
            throw new Exception();
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.equals("get_max")) {
                System.out.println(getMax(stack));

            }
            else if (command.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println("error");
                }
                else {
                    stack.pop();
                }
            }
            else if (command.contains("push")) {
                int number = findNumberInCommand(command);
                stack.push(number);
            }
        }
    }
    public static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }

    public static String getMax(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return "None";
        }
        else {
            Integer max = stack.get(0);
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) > max) {
                    max = stack.get(i);
                }
            }
            return max.toString();
        }
    }

}
