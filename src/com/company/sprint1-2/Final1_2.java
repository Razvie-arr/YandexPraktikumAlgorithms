import java.io.BufferedReader;
import java.io.InputStreamReader;

class LimitedDeque2 {
    int[] deque;
    int head;
    int size;
    int maxSize;

    public LimitedDeque2(int maxSize) {
        deque = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push_back(int number) {
        if (size != maxSize) {
            deque[(head + size++) % maxSize] = number;
        }
        else {
            System.out.println("error");
        }
    }

    public void push_front(int number) {
        if (size != maxSize) {
            if (head == 0) {
                deque[(head = maxSize - 1)] = number;
            } else {
                deque[(--head) % maxSize] = number;
            }

            size++;
        }
        else {
            System.out.println("error");
        }
    }

    public int pop_front() {
        int number = deque[head];
        head = (head + 1) % maxSize;
        size--;
        return number;
    }

    public int pop_back() {
        int number = deque[(head + size - 1) % maxSize];
        size--;
        return number;
    }
}

public class Final1_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        validateConditions(n, m);

        LimitedDeque2 deque = new LimitedDeque2(m);

        for (int i = 0; i < n; i++) {
            String command = reader.readLine();

            if (command.contains("push_back")) {
                int value = findNumberInCommand(command);
                validateValue(value);
                deque.push_back(value);
            }

            else if (command.contains("push_front")) {
                int value = findNumberInCommand(command);
                validateValue(value);
                deque.push_front(value);
            }

            else {
                    if (deque.size == 0) {
                        System.out.println("error");
                    }
                    else {
                        switch (command) {
                            case("pop_front"):
                                System.out.println(deque.pop_front());
                                break;
                            case("pop_back"):
                                System.out.println(deque.pop_back());
                                break;
                        }
                    }
                }
            }
        }

    private static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }

    public static void validateConditions(int n, int m) throws Exception {
        if (n > 5000 || m > 1000) {
            throw new Exception();
        }
    }

    public static void validateValue(int value) throws Exception {
        if (Math.abs(value) > 1000) {
            throw new Exception();
        }
    }
}

