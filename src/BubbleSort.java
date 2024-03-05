public class BubbleSort {
    public static String[] doSort(String[] inputArray) {
        int swapQty = 0;
        while (swapQty > 0) {
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i].compareTo(inputArray[i + 1]) > 0) {
                    swapElements(inputArray, i, i + 1);
                }
            }
        }
        return inputArray;
    }

    private static void swapElements(String[] inputArray, int from, int to) {
        String temp;
        temp = inputArray[to];
        inputArray[to] = inputArray[from];
        inputArray[from] = temp;
    }
}
