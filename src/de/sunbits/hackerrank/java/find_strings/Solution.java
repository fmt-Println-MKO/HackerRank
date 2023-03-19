package de.sunbits.hackerrank.java.find_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'findStrings' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY w
   *  2. INTEGER_ARRAY queries
   */

  public static List<String> findStrings(List<String> w, List<Integer> queries) {
    // Write your code here
    long start1 = System.currentTimeMillis();

    Set<String> tree = new TreeSet<>();
    Set<String> tree2 = new TreeSet<>();

    for (String word : w) {
      int size = word.length();
      for (int i = 0; i <= size; i++) {
        for (int j = i + 1; j <= size; j++) {
          tree2.add(word.substring(i, j));
        }
        tree.add(word.substring(i, size));
      }
    }

    Object[] suffix1 = (tree.toArray());
    String suffix[] = new String[suffix1.length];

    for (int l = 0; l < suffix.length; l++) {
      suffix[l] = (String) suffix1[l];
//      System.out.println(suffix[l]);
    }

    //make suffix-length and lpc array
    int len[] = new int[suffix.length];
    int lcp[] = new int[suffix.length];
    len[0] = suffix[0].toString().length();
    lcp[0] = 0;

    //go to all substrings suffixes
    for (int j = 1; j < suffix.length; j++) {
      int count = 0;
      try {
        while (true) {
          if (suffix[j - 1].charAt(count) == suffix[j].charAt(count)) {
            count++;
          } else {
            break;
          }
        }
      } catch (StringIndexOutOfBoundsException e) {
//        System.out.println("ERROR: " + e.getMessage());
//        System.out.println("ERROR: " + suffix[j].length() +" -- "+ count);
      }
      len[j] = suffix[j].length() - count;
      lcp[j] = count;
    }
    long end1 = System.currentTimeMillis();

    System.out.print("LEN [");
    for (int i = 0; i < len.length; i++) {
      System.out.print(len[i]);
      if (i < len.length - 1) {
        System.out.print(",");
      }
    }
    System.out.println("]");
    System.out.print("LCP [");
    for (int i = 0; i < len.length; i++) {
      System.out.print(lcp[i]);
      if (i < len.length - 1) {
        System.out.print(",");
      }
    }
    System.out.println("]");

    List<String> result = new ArrayList<>();

    long end2 = System.currentTimeMillis();

    for (int i = 0; i < queries.size(); i++) {
      int a = queries.get(i);
      int a1 = 0;
      int j = 0;
      int count = 0;
      try {
        while (j < a) {
          a1 = j;
          j = j + len[count++];
        }
        count--;
        System.out.println("Found substring: " + count + " a: " + a + " a1: " + a1 + " lcp(count): " + lcp[count] + "-- a-a1:" + (a - a1) + " ----> " + (lcp[count] + a - a1));
        result.add(suffix[count].substring(0, lcp[count] + a - a1));
      } catch (ArrayIndexOutOfBoundsException e) {
        result.add("INVALID");
      }
    }

    List<String> list = new ArrayList<>(tree);
    List<String> list2 = new ArrayList<>(tree2);
    List<String> result2 = new ArrayList<>();

    System.out.println(list);
    System.out.println(list2);

    for (Integer q : queries) {
      if (q - 1 >= list.size()) {
        result2.add("INVALID");
      } else {
        result2.add(list.get(q - 1));
      }
    }

    long end3 = System.currentTimeMillis();

    System.out.println(result);
    System.out.println(result2);


    System.out.println("Creation: " + ((end1 - start1) / 1000));
    System.out.println("Sorting: " + ((end2 - end1) / 1000));
    System.out.println("Searching: " + ((end3 - end2) / 1000));


    return result;
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int wCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> w = IntStream.range(0, wCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .collect(toList());

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

    List<String> result = Result.findStrings(w, queries);

//    bufferedWriter.write(
//            result.stream()
//                    .collect(joining("\n"))
//                    + "\n"
//    );

    bufferedReader.close();
//    bufferedWriter.close();
  }
}