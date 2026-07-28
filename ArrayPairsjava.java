public class ArrayPairs {
    public static void printAllPairs(int[] arr) {
        int n = arr.length;
        // Outer loop selects the first element
        for (int i = 0; i < n; i++) {
            // Inner loop selects the second element from the beginning
            for (int j = 0; j < n; j++) {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printAllPairs(arr);
    }
}