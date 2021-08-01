import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListQueue {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());
        if (commandCount > 1000) {
            throw new Exception();
        }
        LinkedList<Integer> linkedQueue = new LinkedList<>();
        for (int i = 0; i < commandCount; i++) {
            String command = reader.readLine();
            if (command.contains("put")) {
                int number = findNumberInCommand(command);
                linkedQueue.add(number);
            }
            if (command.equals("size")) {
                System.out.println(linkedQueue.size());
            }
            if (command.equals("get")) {
                if (linkedQueue.size() == 0) {
                    System.out.println("error");
                }
                else {
                    System.out.println(linkedQueue.poll());
                }
            }
        }
    }

    public static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }
}
