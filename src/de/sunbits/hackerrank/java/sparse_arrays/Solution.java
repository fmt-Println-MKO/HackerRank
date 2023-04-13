package de.sunbits.hackerrank.java.sparse_arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'matchingStrings' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY stringList
   *  2. STRING_ARRAY queries
   */

  public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
    // Write your code here
    int[] result = new int[queries.size()];

    int count = 0;
    HashMap<String, Integer> usedQueries = new HashMap<>();
    for (String query : queries) {
      if (usedQueries.containsKey(query)) {
        int counter = usedQueries.get(query);
        result[count] = counter;
      } else {
        while (stringList.contains(query)) {
          stringList.remove(query);
          result[count]++;
        }
        usedQueries.put(query, result[count]);
      }

      count++;
    }

    return IntStream.of(result).boxed().collect(Collectors.toList());
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int stringListCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> stringList = IntStream.range(0, stringListCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .collect(toList());

    int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
              try {
                return bufferedReader.readLine();
              } catch (IOException ex) {
                throw new RuntimeException(ex);
              }
            })
            .collect(toList());

    List<Integer> res = Result.matchingStrings(stringList, queries);

    bufferedWriter.write(
            res.stream()
                    .map(Object::toString)
                    .collect(joining("\n"))
                    + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}