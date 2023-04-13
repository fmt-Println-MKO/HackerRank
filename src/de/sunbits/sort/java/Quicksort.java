package de.sunbits.sort.java;

public class Quicksort {


  private static int counter =0;
  public static void main(String[] args) {
    // 7(10), 13(20), 19(30),24(40), 30 (50)
    int[] unsorted = new int[]{10, 7, 4, 2, 1, 3, 6, 5, 8, 9,10, 7, 4, 2, 1, 3, 6, 5, 8, 9,10, 7, 4, 2, 1, 3, 6, 5, 8, 9,10, 7, 4, 2, 1, 3, 6, 5, 8, 9,10, 7, 4, 2, 1, 3, 6, 5, 8, 9};

    int[] sorted = quicksort(unsorted);

    for (int i = 0; i < sorted.length; i++) {
      System.out.print("," + sorted[i]);
    }
    System.out.println("");

    System.out.println("Counts: " + counter);


  }


  public static int[] quicksort(int[] array) {

    int length = array.length;
//    System.out.println("--------_> left:" + length);
    if (length == 2) {
      counter++;
//      System.out.println("Just 2 Left: " + array[0] + "-- " + array[1]);
      if (array[0] > array[1]) {
        return new int[]{array[1], array[0]};
      } else {
        return new int[]{array[0], array[1]};
      }
    } else if (length == 1) {
//      System.out.println("1 left:" + array[0]);
      counter++;
      return array;
    } else {

      int middle = array.length / 2;


      int pivot = array[middle];
//      System.out.println("more left:" + length + " middle: " + pivot);
      int[] left = new int[array.length];
      int[] right = new int[array.length];

      int cLeft = 0;
      int cRight = 0;
      for (int i = 0; i < length; i++) {
        if (array[i] > pivot) {
          right[cRight] = array[i];
          cRight++;
        } else if (array[i] < pivot) {
          left[cLeft] = array[i];
          cLeft++;
        } else {
          if (cLeft < cRight) {
            left[cLeft] = array[i];
            cLeft++;
          } else {
            right[cRight] = array[i];
            cRight++;
          }
        }
      }

//      if (cLeft < length && cRight < length) {
      int[] trimmedLeft = new int[cLeft];
      int[] trimmedRight = new int[cRight];

      for (int i = 0; i < cLeft; i++) {
        trimmedLeft[i] = left[i];
      }
      for (int i = 0; i < cRight; i++) {
        trimmedRight[i] = right[i];
      }

      int[] sortedLeft = quicksort(trimmedLeft);
//      System.out.print("Sorted Left: [");
//      for (int i = 0; i < sortedLeft.length; i++) {
//        System.out.print("," + sortedLeft[i]);
//      }
//      System.out.println("]");
      int[] sortedRight = quicksort(trimmedRight);
//      System.out.print("Sorted RIGHT: [");
//      for (int i = 0; i < sortedRight.length; i++) {
//        System.out.print("," + sortedRight[i]);
//      }
//      System.out.println("]");
      int[] sorted = new int[sortedRight.length + sortedLeft.length];
      int cSorted = 0;
      for (int i = 0; i < sortedLeft.length; i++) {
        sorted[cSorted] = sortedLeft[i];
        cSorted++;

      }
      for (int i = 0; i < sortedRight.length; i++) {
        sorted[cSorted] = sortedRight[i];
        cSorted++;
      }
      return sorted;
//      } else {
//        System.out.println(">>>>>>>>>>>" + cLeft +" <<<<<<<< " + cRight);
//        if (cLeft == length) {
//          return left;
//        } else {
//          return right;
//        }
//      }
    }
  }

}