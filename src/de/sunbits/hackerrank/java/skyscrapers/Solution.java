package de.sunbits.hackerrank.java.skyscrapers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int solveSimple(List<Integer> arr) {
    int counts =0;

    for (int i =0;i< arr.size();i++) {
      int currentHeight = arr.get(i);
      for (int j = i+1;j < arr.size();j++) {
        int height = arr.get(j);
        if (height > currentHeight) {
          break;
        } else if (currentHeight==height) {
          System.out.println("Found: "+ currentHeight +" at: " + i + ":"+j);
          counts++;
        }
      }
    }
    return counts*2;
  }

  public static long solve(List<Integer> arr) {
    // Write your code here
    long countFlights =0;
    HashMap<Integer,Long> startpoints = new HashMap<Integer,Long>();

    HashMap<Integer,Integer> startpointsCounter = new HashMap<Integer,Integer>();

    TreeMap<Integer,Integer> startLists = new TreeMap<>();

    HashSet<Integer> toDelete = new HashSet<Integer>();

    int lastHeight =0;

    for (int i =0;i< arr.size();i++) {
      int currentHeight = arr.get(i);

      NavigableSet<Integer> keys =  startLists.navigableKeySet();
//      System.out.println("CHECH Size : " + startLists.size());

//      if ( i == 4374 || i == 3840) {
//        System.out.println("FAILED: " + currentHeight +" lists: " + startLists);
//      }

      for (Integer height :  keys ) {
        if (currentHeight > height) {
          toDelete.add(height);

        } else if (currentHeight == height) {
//          System.out.println("found : " + height);
          if (startpoints.containsKey(currentHeight)) {
            int counter = startpointsCounter.get(currentHeight);
            counter++;
            startpointsCounter.put(currentHeight, counter);
            Long val = startpoints.get(currentHeight);
            startpoints.put(currentHeight, val+counter);
//              System.out.println("found : " + height +" - second: " + i);
          } else {
            startpoints.put(currentHeight, 1l);
            startpointsCounter.put(currentHeight, 1);
//              System.out.println("found : " + height +" - first: " + i);
          }
          break;
        } else {
          break;
        }
      }

      for (Integer key : toDelete) {
        if (key.intValue() == 4977) {
//          System.out.println(i+"---DELETE: " + currentHeight +" lists: " + startLists);
        }
        if (startpoints.containsKey(key)) {
          Long val = startpoints.get(key);
          countFlights+=val;
//          startpoints.remove(key);
        }
        startLists.remove(key);
        startpointsCounter.remove(key);
        startpoints.remove(key);
      }
      toDelete.clear();
      startLists.put(currentHeight, i);


//      if ( i == 4374 || i == 3840) {
//        System.out.println("---FAILED: " + currentHeight +" lists: " + startLists);
//      }

    }
    for (Long counts: startpoints.values() ) {
      countFlights += counts;
    }

    return  countFlights *2;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    long result = Result.solve(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}