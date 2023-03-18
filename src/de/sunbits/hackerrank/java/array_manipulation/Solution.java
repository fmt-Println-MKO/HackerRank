package de.sunbits.hackerrank.java.array_manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'arrayManipulation' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here

    long[] array = new long[n+1];

    for (List<Integer> query : queries) {
      int value = query.get(2);
      int startPos = query.get(0);
      int endPos = query.get(1);

      array[startPos] += value;
      if (endPos < n) {
        array[endPos+1] -= value;
      }
    }

    long max = 0;
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += array[i];
      max = Math.max(max, sum);
    }
    return max;
//    long biggestNumber = 0;

//    long[] array = new long[n];
//    for (int i = 0; i < queries.size(); i++) {
//      int value = queries.get(i).get(2);
//      int startPos = queries.get(i).get(0);
//      int endPos = queries.get(i).get(1);
//
//      for (int j = startPos - 1; j < endPos; j++) {
//        array[j] += value;
//        if (array[j] > biggestNumber) {
//          biggestNumber = array[j];
//        }
//      }
//    }
//    return biggestNumber;
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, m).forEach(i -> {
      try {
        queries.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    long result = Result.arrayManipulation(n, queries);

    System.out.println("Result: " + result + " Check: " + (7542539201l == result));

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();

    bufferedReader.close();
//    bufferedWriter.close();
  }
}