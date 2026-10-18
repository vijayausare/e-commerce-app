import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public int[] getIntegers(int n) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) { // Corrected: use standard for-loop
            arr[i] = s.nextInt();
        }
        return arr;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Corrected: initialize i = 0
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }

    public void sortIntegers(int[] arr) {
        int n = arr.length; // Added: defined 'n' from the array length
        Arrays.sort(arr);

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
