public class FindIndex {
    public static int findIndex(int[] arr, int target) {
        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element matches the target
            if (arr[i] == target) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if the element is not in the array
    }

    public static void main(String[] args) {
        int[] numbers = {5, 4, 6, 1, 3, 2, 7, 8, 9};
        int targetValue = 3;

        int index = findIndex(numbers, targetValue);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}