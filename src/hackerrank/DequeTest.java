package hackerrank;

import java.util.*;
    public class DequeTest {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            int countM = 0;

            int maxUnique =0;

            HashSet<Integer> uniqueCounter = new HashSet<>();

            int count =0;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (!uniqueCounter.contains(num)) {
                    count++;
                    uniqueCounter.add(num);
                }
                deque.add(num);
                countM++;
                if (countM == m) {
                    if (count > maxUnique) {
                        maxUnique = count;
                    }
                    Integer first = deque.getFirst();
                    deque.removeFirst();
                    if (!deque.contains(first)) {
                        uniqueCounter.remove(first);
                        count--;
                    }
                    countM--;
                }

            }
            System.out.println(maxUnique);
        }
    }