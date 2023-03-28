package de.sunbits.hackerrank.java.minimum_loss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'minimumLoss' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts LONG_INTEGER_ARRAY price as parameter.
   */

  public static int minimumLoss(List<Long> price) {
    // Write your code here
    TreeMap<Long, Integer> sorted = new TreeMap<>();

    int i = 0;
    for (Long aPrice : price) {
      sorted.put(aPrice, i);
      i++;
    }

    long minLoss = Long.MAX_VALUE;

    Map.Entry<Long, Integer> last = sorted.pollLastEntry();

    for (Map.Entry<Long, Integer> current : sorted.descendingMap().entrySet()) {
//      System.out.println("CHECK: " + last +" ---> " + current);
      if (last.getValue() < current.getValue()) {
        minLoss = Math.min(minLoss, last.getKey() - current.getKey());
      }
      last = current;
    }

    return Math.toIntExact(minLoss);
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

    int result = Result.minimumLoss(price);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}