package de.sunbits.hackerrank.java.mrxshots;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


enum PointType {
  XShot,
  YShot,
  XPlayer,
  yPlayer,
}

class Point implements Comparable<Point> {

  public int v;
  public PointType type;

  public int i;

  public Point(final int v, final PointType type, final int i) {
    this.v = v;
    this.type = type;
    this.i = i;
  }

  @Override
  public int compareTo(@NotNull final Point o) {
    if (v < o.v) {
      return -1;
    }
    if (v == o.v) {
      if (type == PointType.XShot || type == PointType.XPlayer) {
        return -1;
      } else {
        return 1;
      }
    }

    return 1;
  }
}

class Result {

  /*
   * Complete the 'solve' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. 2D_INTEGER_ARRAY shots
   *  2. 2D_INTEGER_ARRAY players
   */


  public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
    // Write your code here

    int strength = 0;

    int sum =0;
    Collections.sort(shots, (a, b) -> {
      if (a.get(0) > b.get(0)) {
        return 1;
      } else {
        return -1;
      }
    });
    Collections.sort(players, (a, b) -> {
      if (a.get(0) > b.get(0)) {
        return 1;
      } else {
        return -1;
      }
    });

    int count =0;

    for (List<Integer> player : players) {

      System.out.println("----- Play" + player );

      Iterator<List<Integer>> iter = shots.iterator();

      while (iter.hasNext()) {
        List<Integer> shot = iter.next();
        count++;
        if (player.get(1) < shot.get(0)) {
          break;
        } else if (shot.get(1) < player.get(0)) {
          System.out.println("----- REMOVE" + shot );
          iter.remove();
        } else {
          sum++;
        }
      }
    }
//    return sum;
    strength = sum;


//    TreeSet<Point> line = new TreeSet<>();
//
//    int aS = a.size();
//    int bS = b.size();
//
//    int i = 0, j = 0;
//    while (i < aS) {
//
//      line.add(new Point(a.get(i).get(0), PointType.XShot, i));
//      line.add(new Point(a.get(i).get(1), PointType.YShot, i));
//      i++;
//    }
//    while (j < bS) {
//
//      line.add(new Point(b.get(j).get(0), PointType.XPlayer, j));
//      line.add(new Point(b.get(j).get(1), PointType.yPlayer, j));
//      j++;
//    }
//
//
//    int currentOpenS = -1;
//    int currentOpenP = -1;
//    boolean addedS = false;
//    boolean addedP = false;
//    int count = 0;
//
//    int index = 0;
//    for (Point point : line) {
//      if (point.type == PointType.XShot || point.type == PointType.XPlayer) {
//        if (currentOpenP == -1 && point.type == PointType.XPlayer ) {
//          currentOpenP = point.i;
//          addedP = false;
//        }
//        if (currentOpenS == -1 && point.type == PointType.XShot) {
//          currentOpenS = point.i;
//          addedS = false;
//        }
//
//
//        if (currentOpenS >= 0 && point.type == PointType.XPlayer) {
//          int bufferI = point.i;
//          count++;
//          if (!addedS) {
//            count++;
//            addedS = true;
//          }
//          if (a.get(bufferI).get(1) > a.get(currentOpenS).get(1)) {
//            currentOpenS = bufferI;
//            addedS = true;
//          }
//        }
//
//        if (currentOpenP >= 0 && point.type == PointType.XShot) {
//          int bufferI = point.i;
//          count++;
//          if (!addedP) {
//            count++;
//            addedP = true;
//          }
//          if (b.get(bufferI).get(1) > b.get(currentOpenS).get(1)) {
//            currentOpenP = bufferI;
//            addedP = true;
//          }
//        }
//      } else {
//        if (point.i == currentOpenS) {
//          currentOpenS = -1;
//          addedS = false;
//        }
//
//        if (point.i == currentOpenP) {
//          currentOpenP = -1;
//          addedP = false;
//        }
//      }
//      index++;
//    }
//
//    strength = count;
//

//        List<List<Integer>> intervals = new ArrayList<>(shots);
//        intervals.addAll(players);
//        intervals.sort(Comparator.comparingInt(i -> i.get(0)));
//
//        // Sweep through the intervals and track overlaps
//
//        int overlaps = 0;
//        int count = 0;
//
//        for (List<Integer> interval : intervals) {
//            int start = interval.get(0);
//            int end = interval.get(1);
//
//            if (count > 0 && start > overlaps) {
//                overlaps += Math.min(end, count) - overlaps;
//            }
//
//            count += end - start;
//        }

//        List<List<Integer>> common = new ArrayList<>();
//        for (List<Integer> intervalA : shots) {
//            for (List<Integer> intervalB : players) {
//                int start = Math.max(intervalA.get(0), intervalB.get(0));
//                int end = Math.min(intervalA.get(1), intervalB.get(1));
//                if (start <= end) {
//                    common.add(Arrays.asList(start, end));
//                }
//            }
//        }
    // Calculate the total overlap
//        int overlap = 0;
//        for (List<Integer> interval : common) {
//            overlap += interval.get(1) - interval.get(0);
//        }


//        Collections.sort(a, Comparator.comparingInt(o -> o.get(0)));
//        Collections.sort(b, Comparator.comparingInt(o -> o.get(0)));
//
//        int overlap = 0;
//        int i = 0, j = 0;
//        int start = 0, end = 0;
//
//        // Traverse the intervals in a and b in order
//        while (i < a.size() && j < b.size()) {
//            List<Integer> intervalA = a.get(i);
//            List<Integer> intervalB = b.get(j);
//
//            // If there is an overlap, update the start and end of the common interval
//            if (intervalA.get(1) >= intervalB.get(0) && intervalB.get(1) >= intervalA.get(0)) {
//                start = Math.max(intervalA.get(0), intervalB.get(0));
//                end = Math.min(intervalA.get(1), intervalB.get(1));
//                overlap += end - start;
//            }
//
//            // Move to the next interval in a or b
//            if (intervalA.get(1) < intervalB.get(1)) {
//                i++;
//            } else {
//                j++;
//            }
//        }

//
//        int overlap = 0;
//
//        for (List<Integer> intervalA : a) {
//            for (List<Integer> intervalB : b) {
//                // Check if there is an overlap between intervalA and intervalB
//                int start = Math.max(intervalA.get(0), intervalB.get(0));
//                int end = Math.min(intervalA.get(1), intervalB.get(1));
//                if (start <= end) {
//                    overlap += end - start + 1;
//                }
//            }
//        }


//    int overlap = 0;
//
//    for (List<Integer> intervalA : a) {
//      int startA = intervalA.get(0);
//      int endA = intervalA.get(1);
//
//      for (List<Integer> intervalB : b) {
//        int startB = intervalB.get(0);
//        int endB = intervalB.get(1);
//
//        if ((startB >= startA && startB <= endA) || (endB >= startA && endB <= endA)) {
//          // There is an overlap
//          int startOverlap = Math.max(startA, startB);
//          int endOverlap = Math.min(endA, endB);
//          overlap += endOverlap - startOverlap + 1;
//        }
//      }
//    }


//    strength = overlap;
//    int xSize = shots.size();
//    int[][] xShots = new int[xSize][2];
//
//    for (int i =0; i < xSize; i++) {
//        xShots[i] = shots.get(i).stream().mapToInt(Integer::intValue).toArray();
//    }
//    shots=null;
//
//    int pSize = players.size();
//    int[][] pShots = new int[pSize][2];
//
//    for (int i =0; i < pSize; i++) {
//        pShots[i] = players.get(i).stream().mapToInt(Integer::intValue).toArray();
//    }
//    players=null;
//
//    int strength =0;
//
//Arrays.sort(pShots, (a, b) -> a[0] - b[0]); // sort pShots by start position
//Arrays.sort(xShots, (a, b) -> a[0] - b[0]); // sort xShots by start position
//
//System.out.println( "-------------------");
//for (int[] x : xShots) {
//    System.out.println( x[0]+":"+x[1]);
//}
//System.out.println( "-------");
//for (int[] x : pShots) {
//    System.out.println( x[0]+":"+x[1]);
//}
//int count =0;
//int i = 0, j = 0;
//while (i < pSize && j < xSize) {
//    int start = Math.max(pShots[i][0], xShots[j][0]);
//    int end = Math.min(pShots[i][1], xShots[j][1]);
//    count++;
//    if (start <= end) { // there is an overlap
////        System.out.println(" Match: " + start + "-- " + end);
//        strength++;
//    }
//        if (pShots[i][1] < xShots[j][1]) {
//            i++;
////        } else if (pShots[i][1] > xShots[j][1]) {
////            j++;
//        } else { // pShots[i][1] == xShots[j][1]
////            i++;
//            j++;
//        }
//    } else { // no overlap
//        System.out.println("---NO  Match: " + start + "-- " + end);
//        if (pShots[i][1] < xShots[j][1]) {
//            i++;
//        } else {
//            j++;
//        }
//    }
//}


//        for (int i =0; i < pSize;i++) {
//            int j =0;
//            int k =xShots.length-1;
//            int s = -1;
//            int e = -1;
//
//            while (s <0) {
//                if (pShots[i][0]<=xShots[j][0] || pShots[i][0]<=xShots[j][1]) {
//                    s =j;
//                }
//                j++;
//            }
//            while (e <0) {
//                if (pShots[i][1]>=xShots[k][1] ) {
//                    e =k;
//                }
//                k--;
//            }
//            strength+=e-s;


//            for (int j = 0; j< xSize;j++) {
//                if (pShots[i][1]<xShots[j][0]) {
//                    break;
//                }
//             count++;
//                if ( (pShots[i][0] >= xShots[j][0] && pShots[i][0] <= xShots[j][1]) || (pShots[i][1] >= xShots[j][0] && pShots[i][1] <= xShots[j][1]) ||(pShots[i][0] < xShots[j][0] && pShots[i][1] > xShots[j][1]) )
//                    strength++;
//            }
//        }
    System.out.println("S: " + strength);
        System.out.println("Count: " +count);
    return strength;
  }

}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> shots = new ArrayList<>();

    IntStream.range(0, n).forEach(i -> {
      try {
        shots.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    List<List<Integer>> players = new ArrayList<>();

    IntStream.range(0, m).forEach(i -> {
      try {
        players.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int result = Result.solve(shots, players);

    // bufferedWriter.write(String.valueOf(result));
    // bufferedWriter.newLine();

    bufferedReader.close();
    // bufferedWriter.close();
  }
}