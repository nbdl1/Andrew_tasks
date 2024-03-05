import org.w3c.dom.ls.LSOutput;

public class MergeSort {

    public static String[] doSort(String[] inputArray){
        String[] sortedArray = new String[inputArray.length];
        copyArray(inputArray,0, inputArray.length,0,sortedArray.length,sortedArray);
        splitArrayAndMergeSortedParts(sortedArray,0,sortedArray.length,inputArray);
        return sortedArray;
    }

    private static void splitArrayAndMergeSortedParts(String[] workArray,int from,int to,String[] resultArray){
        int middleIndex = workArray.length/2+workArray.length%2;
        String[] leftArray = new String[middleIndex];
        String[] rightArray = new String[workArray.length/2];
        copyArray(workArray,from,middleIndex,0,leftArray.length,leftArray);
        copyArray(workArray,middleIndex,workArray.length,0, rightArray.length, rightArray);
        //получили левую и правую половину массива
        //рекурсией проходим влево
        if(leftArray.length>2){
            splitArrayAndMergeSortedParts(leftArray,from,leftArray.length,workArray);
        }
        //сортируем, когда дошли до массива из двух элементов слева
        sortTwoStringsArray(leftArray);
        //рекурсией проходим вправо
        if(rightArray.length>2){
            splitArrayAndMergeSortedParts(rightArray,from,rightArray.length,workArray);
        }
        //сортируем, когда дошли до массива из двух элементов справа
        sortTwoStringsArray(rightArray);
        //сортируем и сливаем два массива по два элемента
        int k=0;
        int i=0;
        int j= 0;
        while(i<leftArray.length&&j<rightArray.length){
            if(leftArray[i].compareTo(rightArray[j])<0){
                workArray[k]=leftArray[i];
                i++;
            }else{
                workArray[k]=rightArray[j];
                j++;
            }
            k++;
        }
        while (i<leftArray.length){
            workArray[k]=leftArray[i];
            i++;
            k++;
        }
        while (j<rightArray.length){
            workArray[k]=leftArray[j];
            j++;
            k++;
        }

        System.out.println("workArray array:");
        printArray(workArray);
    }

    private static void sortTwoStringsArray(String[] array){
        if(array.length!=2){return;}
        String workingString;
        try{
            int leftElement=Integer.parseInt(array[0]);
            int rightElement=Integer.parseInt(array[1]);
            if(leftElement>rightElement){
                workingString=array[0];
                array[0]=array[1];
                array[1]=workingString;
            }
        }catch (IllegalArgumentException e){
            System.out.println("Value is a String");
            if(array[0].compareTo(array[1])>=0){
                workingString=array[0];
                array[0]=array[1];
                array[1]=workingString;
            }
        }
    }

    private static void copyArray(String[] source,int fromSrc,int toSrc,int fromDst,int toDst,String[] dest){
        for(int i=fromDst;i<toDst;i++){
            if(toSrc-fromSrc>toDst-fromDst){
                return;
            }
            dest[i]=source[fromSrc];
            fromSrc++;
        }
    }

    public static void printArray(String[] input){
        System.out.println("Printing array:");
        for (String s:input){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}

