public class InsertionSort {
    public static String[] doSort(String[] inputArray){
        for(int i=1;i<inputArray.length;i++){
             int k=i-1;
            while (inputArray[k].compareTo(inputArray[i])>0){
                if(inputArray[k].compareTo(inputArray[i])>0){
                    moveLeft(inputArray,i,k);
                    i--;
                }
                if(k>0)
                k--;
            }
        }
        return inputArray;
    }

    private static void moveLeft(String[] inputArray,int from,int to){
        String temp;
        temp=inputArray[to];
        inputArray[to]=inputArray[from];
        inputArray[from]=temp;
    }
}
