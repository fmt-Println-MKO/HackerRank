package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultNewYearChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */


    public static String calcMinimumBribesBackword(List<Integer> q) {
        int countBribes = 0;
        boolean toChaotic = false;

        HashMap<Integer, Integer> currentPos = new HashMap<>(q.size());

        for (int i = q.size(); i > 0; i--) {
            int orgPos = q.get(i - 1);
            currentPos.put(orgPos, i);
            int change = orgPos - i;
            if (change > 2) {
                toChaotic = true;
                break;
            }
            if (orgPos != i) {
                if (i > orgPos)
                    countBribes += i - orgPos;
            } else if (currentPos.containsKey(orgPos - 1) && i < currentPos.get(orgPos - 1)) {
                countBribes++;
            }
        }

        if (toChaotic) {
            return "Too chaotic";
        } else {
            return "" + countBribes;
        }
    }

    public static int countOnersRec(LinkedList<Integer> neg, int last) {

        int beforeLast = neg.getLast();
        int counter = 0;
//        System.out.println("----Rec: " + last + " -- "+ beforeLast +" --> " + neg);
        if (last < beforeLast) {
            neg.removeLast();
            counter++;
            if (neg.size() > 1) {
                counter += countOnersRec(neg, last);
            }
        } else {
            int newLast = neg.removeLast();
            if (neg.size() > 0) {
                counter += countOnersRec(neg, newLast);
            }
        }
        return counter;

    }

    public static String calcMinimumBribesRec(List<Integer> q) {
        // Write your code here
        int countBribes = 0;
        boolean toChaotic = false;
//        HashMap<Integer,Integer> currentPos = new HashMap<>(q.size());

//        LinkedList<Integer> behindPos = new LinkedList<>();
//        LinkedHashMap<Integer, Integer> switched = new LinkedHashMap<>();
//        LinkedList<Integer> switched2 = new LinkedList<>(q);
//
//        HashSet<Integer> same = new HashSet<>();
        LinkedList<Integer> neg = new LinkedList<>();

//        for (int i = 0; i < q.size(); i++) {
//            int orgPos = q.get(i);
//            currentPos.put(orgPos,i+1);
//            switched.put(i+1,orgPos);
//            switched2.set(orgPos-1,i+1);
//            //            behindPos.add(orgPos);
//            if (orgPos > i+1) {
//                behindPos.add(orgPos);
//            }
//        }

        int negCounter = 0;

        for (int i = 0; i < q.size(); i++) {
            int orgPos = q.get(i);
//            int nextPos = q.get(i + 1);
            int changes = orgPos - i - 1;

//            System.out.println("Check---> i:" + (i+1) +" Val:" +orgPos + " changes: " + changes +" next: " + currentPos.get(orgPos-1) +"-- check: "+ (currentPos.containsKey(orgPos-1) && i+1 < currentPos.get(orgPos-1)) );


            if (changes > 2) {
                toChaotic = true;
                break;
            } else if (changes > 0) {
//                System.out.println("good bribe from: " + orgPos + " on: " + (i + 1) + " is: " + (orgPos - i - 1));
                countBribes += orgPos - i - 1;
                continue;
            }

            if (changes <= 0) {
//                System.out.println("Neg offer: " + orgPos +" count: " + negCounter + "  contains nest: " + neg);
                neg.offer(orgPos);
//                negCounter++;
            }
//            if (changes == 0) {
//                same.add(orgPos);
//
//            }


        }

//        System.out.println("--> neg size: " + neg.size() +" ng: " + neg) ;
        if (!toChaotic) {
            countBribes += countOnersRec(neg, neg.removeLast());
        }

//        for (int i = negCounter;i>0;i--) {
//            System.out.println("-------> neg size: " + neg.size() + " LISTR. " + neg);
//
//
//            int last = neg.removeLast();
//            System.out.println("Neg check: " + last +" contains nest: " + neg.contains(last+1));
//            if (neg.contains(last+1)) {
//                int j = neg.indexOf(last+1);
//                countBribes+= neg.size()-j;
//            }
//            //            neg.removeLast();
//        }

//            System.out.println("Check same---> i:" + (i+1) +" Val:" +orgPos + " changes: " + changes +" next: " + switched2.get(i+1));
////            if ((i < q.size()-1 && switched2.get(i+1)<=orgPos) || (i < q.size() -1 &&  orgPos > q.get(i+1)) ) {
//                if ((i < q.size()-1 && switched2.get(i+1)<=orgPos)  ) {
//                System.out.println("same found: "  + orgPos);
//                countBribes++;
//            }

        //            if (behindPos.indexOf(orgPos) > q.size()-1) {
        //                System.out.println("bribe from: " + orgPos);
        //                countBribes++;
        //
        //            }

//            for (int j  =orgPos; j > 0; j++) {
//                if (behindPos.contains(j)) {
//                    System.out.println("bribe from: " + orgPos + " aiganst: " + j +" i: " + i + " pos J: "+ currentPos.get(j));
//                    countBribes++;
//                    break;
//                }
//            }

//            for (int j = i+1; j < q.size();j++) {
//                System.out.println("checking: " + orgPos +" j: "+ j +" vs: " + currentPos.get(j) +" i: " + (i+1));
//                if (orgPos > q.get(j)) {
//                    System.out.println("bribe from: " + orgPos + " aiganst: " + j +" i: " + i + " pos J: "+ currentPos.get(j));
//                    countBribes++;
//                    break;
//                }
//            }

//            for (int j = orgPos; j > 0; j--) {
////                System.out.println("checking: " + orgPos +" j: "+ j +" vs: " + currentPos.get(j) +" i: " + (i+1));
//                if (currentPos.get(j) != null && currentPos.get(j) > i+1 ) {
////                    System.out.println("bribe from: " + orgPos + " aiganst: " + j +" i: " + i + " pos J: "+ currentPos.get(j));
//                    countBribes++;
//                    break;
//                }
//            }

//            else if (currentPos.containsKey(orgPos-1) &&  i+1 < currentPos.get(orgPos-1) ) {
//                countBribes++;
//            }

//            else if (orgPos > nextPos) {
//                System.out.println("next bribe from: " + orgPos + "/" + nextPos + "  on: " + (i + 1) + " is: " + (orgPos - i - 1));
//                countBribes++;
//            } else if (i < q.size() - 2 && i > 0) {
//                int beforePos = q.get(i - 1);
//                int overNext = q.get(i + 2);
//                if (orgPos > overNext) {
//                    System.out.println("overnext bribe from: " + orgPos + "/" + overNext + "  on: " + (i + 1) + " is: " + (orgPos - i - 1));
//                    countBribes++;
//                } else if (beforePos-orgPos == 1 && beforePos > (i)) {
//                    System.out.println("before bribe from: " + orgPos + "/" + beforePos + "  on: " + (i + 1)+ " is: " + (orgPos - i - 1));
//                    countBribes++;
//                }
//            }

//        }
        if (toChaotic) {
            return "Too chaotic";
        } else {
            return "" + countBribes;
        }
    }

    public static String calcMinimumBribes(List<Integer> want) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= want.size(); i++) {
            list.add(i);
        }
        int ret = 0;
        for (int curr : want) {
            System.out.println("CUrr: " + curr +" list: " + list);
            if (list.size() > 0 && list.get(0) == curr) {
                list.remove(0);
            } else if (list.size() > 1 && list.get(1) == curr) {
                ret++;
                list.remove(1);
            } else if (list.size() > 2 && list.get(2) == curr) {
                ret += 2;
                list.remove(2);
            } else if (list.size() > 2) {
                ret = -1000000000;
                break;
            }
        }
        if (ret < 0) {
            return "Too chaotic";

        }
        return ""+ret;

    }

    public static void minimumBribes(List<Integer> q) {
        System.out.println(ResultNewYearChaos.calcMinimumBribes(q));

    }

}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                ResultNewYearChaos.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
