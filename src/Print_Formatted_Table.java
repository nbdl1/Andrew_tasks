import javax.sound.midi.Soundbank;

public class Print_Formatted_Table {
    public static int arrayPairCount = 0;
/* todo
Required part:
●	Complete the Print Formatted Table task
●	Implement MergeSort algorithm
Additional part:
●	Implement the Insertion Sort
●	Implement the Bubble Sort
●	Implement the Merge Sort
●	Measure the time for various datasets and build a graphic for Time Complexity on the same chart (so you can visually compare three algorithms).

    Given an array of strings of unspecified length, write a function that will print its contents in 5 columns. The minimum distance between columns is 4 spaces.

    Please take a look at the following example. Assume the array is called "input" and is passed into the function.

    Input:
    String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};

    Output: (this should be printed to the console)

            1     2     3             x     5
            6     a     porosiatko    c     10
            11    12    13            14    15
            16
*/

    public static void main(String[] args) {
        String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
        doIt(input,2);
        System.out.println("\n----------------------");
        doIt(input,5);
        System.out.println("\n----------------------");
        doIt(input,10);
        System.out.println("\n----------------------");

        String[] sortedArray = MergeSort.doSort(new String[]{"5","9","4","8","7","6","2","3","1"});
        MergeSort.printArray(sortedArray);
    }

    private static void doIt(String[] input,int columns) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + checkSpacesNeeded(i,input,columns));
        }
    }
    private static String checkSpacesNeeded(int position,String[] input,int columns){
        if((position+1)%columns==0){
            return "\n";
        }
        int maxLength = getMaxLengthForThisColumn(position,input,columns);
        return getSpacesString(maxLength,position,input);
    }
    private static String getSpacesString(int maxLength,int position,String[] input){
        String spacesString = "";
        int neededSpaces=4+maxLength-input[position].length();
        for(int k=0;k<neededSpaces;k++){
            spacesString+="\s";
        }
        return spacesString;
    }

    private static int getMaxLengthForThisColumn(int position,String[] input, int columns) {
        int maxLength = input[position].length();
        for(int j=position;j>=0;j=j-columns){
            if(maxLength<input[j].length()){
                maxLength=input[j].length();
            }
        }
        for(int j=position;j<input.length;j=j+columns){
            if(maxLength<input[j].length()){
                maxLength=input[j].length();
            }
        }
        return maxLength;
    }


}
