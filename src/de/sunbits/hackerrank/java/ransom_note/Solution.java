package de.sunbits.hackerrank.java.ransom_note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'checkMagazine' function below.
   *
   * The function accepts following parameters:
   *  1. STRING_ARRAY magazine
   *  2. STRING_ARRAY note
   */

  public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here

    boolean canUse = true;

    for (String word : note) {
      if (!magazine.contains(word)) {
        canUse = false;
        break;
      } else {
        magazine.remove(word);
      }
    }
    if (canUse) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int m = Integer.parseInt(firstMultipleInput[0]);

    int n = Integer.parseInt(firstMultipleInput[1]);

    List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

    List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

    Result.checkMagazine(magazine, note);

    bufferedReader.close();
  }
}