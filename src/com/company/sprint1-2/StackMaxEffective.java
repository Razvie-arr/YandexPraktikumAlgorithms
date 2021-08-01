//https://stackoverflow.com/questions/45072627/what-is-the-fastest-way-to-search-the-maximum-element-in-a-stack-in-java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackMaxEffective {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 100000) {
            throw new Exception();
        }
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.equals("get_max")) {
                if (stack.size() == 0) {
                    System.out.println("None");
                }
                else {
                    System.out.println(stackMax.peek());
                }
            }
            else if (command.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println("error");
                }
                else {
                    stack.pop();
                    stackMax.pop();
                }
            }
            else if (command.contains("push")) {
                int number = findNumberInCommand(command);
                stack.push(number);
                if (stack.size() == 1) {
                    stackMax.push(number);
                }
                if (stackMax.peek() < number) {
                    stackMax.push(number);
                }
                else {
                    stackMax.push(stackMax.peek());
                }
            }
        }
    }
    public static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }

}
