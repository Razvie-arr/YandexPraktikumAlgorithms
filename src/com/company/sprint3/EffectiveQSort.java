/*
https://contest.yandex.ru/contest/23815/run-report/52622049/

-- ПРИНЦИП РАБОТЫ --
Реализован класс Participant, который позволяет держать в себе имя, количество очков и штрафов участника олимпиады.
Используется компаратор comp, который осуществляет сравнение по количеству очков и штрафов.
Реализован рекурсивный метод quickSort, который принимает в себя обьект класса Participant, стартовый индекс и конечный индекс.


-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Временная сложность как у обычной быстрой сортировки - в среднем 0(n log(n)), в худшем O(n2)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Благодаря модификации быстрой сортировки in-place, алгоритм позволяет не использовать O(n), памяти, но из-за О(log n),
рекурсивных вызовов, потребляет O(log n) памяти
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class EffectiveQSort {
    public static class Participant {
        private final String name;
        private final int score;
        private final int penalty;

        public Participant(String name, int score, int penalty) {
            this.name = name;
            this.score = score;
            this.penalty = penalty;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public int getPenalty() {
            return penalty;
        }
    }

    public static Comparator<Participant> comp =
            Comparator.comparingInt(Participant::getScore).reversed()
                    .thenComparingInt(Participant::getPenalty).thenComparing(Participant::getName);

    public static void quickSort(List<Participant> aList, int start,
                                 int end) {

        if (end - start > 1) {
            int p = partition(aList, start, end);
            quickSort(aList, start, p);
            quickSort(aList, p + 1, end);
        }
    }

    public static int partition(List<Participant> aList, int start,
                                int end) {
        Participant pivot = aList.get(start);
        int i = start + 1;
        int j = end - 1;
        while (true) {
            while (i <= j && comp.compare(aList.get(i), pivot) < 0) {
                i++;
            }
            while (i <= j && comp.compare(aList.get(j), pivot) >= 0) {
                j--;
            }
            if (i <= j) {
                Collections.swap(aList, i, j);
            } else {
                Collections.swap(aList, start, j);
                return j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 100000) {
            throw new Exception("invalid n");
        }
        List<Participant> participants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] participant = reader.readLine().split(" ");
            int score = Integer.parseInt(participant[1]);
            int penalty = Integer.parseInt(participant[2]);
            participants.add(new Participant(participant[0], score, penalty));
        }
        quickSort(participants, 0, participants.size());
        participants
                .forEach(par -> System.out.println(par.getName()));
    }
}
