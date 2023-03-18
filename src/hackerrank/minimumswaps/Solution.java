package hackerrank.minimumswaps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {


    public static int recursiveSelectionSort(int[] array, int startIndex) {

        int minSwaps = 0;
        int n = array.length;

        if (startIndex >= n - 1) {
            return minSwaps;
        }

        int minIndex = startIndex;
        for (int i = startIndex + 1; i < n; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        if (minIndex != startIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[minIndex];
            array[minIndex] = temp;
            minSwaps++;
        }

        minSwaps += recursiveSelectionSort(array, startIndex + 1);
        return minSwaps;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] array) {


        int minSwaps = 0;
//        int n = array.length;
//
//        for (int i = 0; i < n-1; i++) {
//            int minIndex = i;
//
//            for (int j = i+1; j < n; j++) {
//                if (array[j] < array[minIndex]) {
//                    minIndex = j;
//                }
//            }
//
//            if (minIndex != i) {
//                int temp = array[i];
//                array[i] = array[minIndex];
//                array[minIndex] = temp;
//                minSwaps++;
//            }
//        }

        minSwaps = recursiveSelectionSort(array, 0);




//        boolean sorted = false;
//        while(!sorted) {
//            for (int i =0; i< arr.length;i++) {
//
//                int mindistance = 1000000;
//                boolean swapFound = false;
//                int jMin =0;
//
//
//                for (int j = 0; j < arr.length;j++) {
//                    int iPos = arr[i];
//                    int jPos = arr[j];
//                    if (i != j && (iPos-1) != i && (jPos-1) != j) {
//                        int iPosDiff = j - iPos;
//                        if (iPosDiff<0) {
//                            iPosDiff = iPosDiff * -1;
//                        }
//                        int jPosDif = i- jPos;
//                        if (jPosDif < 0) {
//                            jPosDif *=-1;
//                        }
//                        int dif = iPosDiff+jPosDif;
//                        System.out.println("CHeck: i: " + i +" j: "+ j +" dif: " + dif + " minDif: "+ mindistance);
//                        if (dif < mindistance) {
//                            swapFound=true;
//                            jMin = j;
//
//                            mindistance= dif;
//                        }
//                    }
//                }
//                System.out.print("Arr: ");
//                for (int k = 0;k<arr.length;k++) {
//                    System.out.print(" " +arr[k]);
//                }
//                System.out.println("");
//
//                if (swapFound) {
//
//                    System.out.println("SWAP: i: " + i +" j: "+ jMin +" dif: " + mindistance);
//                    minSwaps++;
//                    int t = arr[i];
//                    arr[i] = arr[jMin];
//                    arr[jMin] = t;
//                }
//                System.out.print("Arr: ");
//                for (int k = 0;k<arr.length;k++) {
//                    System.out.print(" " +arr[k]);
//                }
//                System.out.println("");
//            }
//            boolean isSorted=true;
//            for (int k = 0;k<arr.length;k++) {
//                if (arr[k]-1 != k ) {
//                    isSorted = false;
//                    break;
//                }
//            }
//            sorted=isSorted;
//        }
        return minSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}