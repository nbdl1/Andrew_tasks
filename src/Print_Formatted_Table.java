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
        //doIt(sortMerge(new String[]{"5","1","4","2"}));
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

    /////todo Implement MergeSort algorithm
    private static String[] sortMerge(String[] inputArray){
        String[] workArray=new String[inputArray.length];
        copyArray(inputArray,0, inputArray.length,workArray);
        splitArrayAndMergeSortedParts(workArray,0,workArray.length,inputArray);
        return inputArray;
    }
    private static void splitArrayAndMergeSortedParts(String[] workArray,int from,int to,String[] resultArray){
        if(to-from<=1){return;}
        String[] leftArray=new String[workArray.length/2+workArray.length%2];
        //System.out.println("leftArray.length = "+leftArray.length);
        copyArray(workArray,0,workArray.length/2+workArray.length%2,leftArray);
        //System.out.println("leftArray.length after copy = "+leftArray.length);
        String[] rightArray=new String[workArray.length/2];
       // System.out.println("rightArray.length = "+rightArray.length);
        copyArray(workArray,workArray.length/2+workArray.length%2,workArray.length,rightArray);
       // System.out.println("rightArray.length after copy = "+leftArray.length);
        //System.out.println("leftArray.length = "+leftArray.length);
        //System.out.println("workArray.length = "+workArray.length);
        if(leftArray.length>2){
            splitArrayAndMergeSortedParts(leftArray,from,to/2+to%2,resultArray);
        }else{
            System.out.println("leftArray size is = "+leftArray.length);
            for(String s: leftArray){
                System.out.print(s+"\s");
            }
            sortTwoStringsArray(leftArray);
            copyArray(leftArray,arrayPairCount,arrayPairCount+2,resultArray);
            arrayPairCount=arrayPairCount+2;
            System.out.print("Result Array at the moment is: ");
            for(String s: resultArray){
                System.out.print(s+"\s");
            }
            splitArrayAndMergeSortedParts(workArray,from+2,to,resultArray);
        }

        if(rightArray.length>2){
            splitArrayAndMergeSortedParts(rightArray,(to/2+to%2)-1,to,resultArray);
        }else{
            sortTwoStringsArray(rightArray);
            copyArray(rightArray,arrayPairCount,arrayPairCount+1,resultArray);
            arrayPairCount=arrayPairCount+2;
            System.out.print("Result Array at the moment is: ");
            for(String s: resultArray){
                System.out.print(s+"\s");
            }
            splitArrayAndMergeSortedParts(workArray,from+2,to,resultArray);
        }
    }

    private static void sortTwoStringsArray(String[] array){
        if(array.length!=2){return;}
        String workingString;
        if(array[0].compareTo(array[1])>0){
            workingString=array[0];
            array[0]=array[1];
            array[1]=workingString;
            System.out.println("Sorted array pair is "+array[0]+" and "+array[1]);
        }
    }

    private static void copyArray(String[] source,int from,int to,String[] dest){
        //System.out.println("source length "+source.length);
       // System.out.println("dest length "+dest.length);
       // System.out.println("from = "+from);
       // System.out.println("to = "+to);
        System.out.println("Source is ");
        for (String s:source){
            System.out.print(s+" ");
        }
        System.out.println("dest is ");
        for (String s:dest){
            System.out.print(s+" ");
        }
        for(int i=0;i<dest.length-to;i++){
            System.out.println("source[from] "+source[from]);
            System.out.println("dest[i] "+dest[i]);
            dest[i]=source[from];
            from++;
        }
    }
}
