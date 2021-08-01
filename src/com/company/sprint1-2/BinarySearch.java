import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrayWithNumbers = {3, 2, 1, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(arrayWithNumbers);
        System.out.print(binarySearch(arrayWithNumbers, 1));
    }

    public static int binarySearch(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (number > array[middle]) {
                left = middle + 1;
            } else if (number < array[middle]) {
                right = middle - 1;
            } else if (number == array[middle]) {
                return array[middle];
            }
        }
        return -1;
    }
}
