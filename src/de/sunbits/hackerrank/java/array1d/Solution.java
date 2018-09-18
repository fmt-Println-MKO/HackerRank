package de.sunbits.hackerrank.java.array1d;

import java.util.*;

public class Solution {
    private static int _leap;
    private static int[] _game;
    private static int l;

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the _game; otherwise, return false.

        _leap = leap;
        _game = game;
        l = _game.length;

        return possibleWin(0, false, false, 0);
    }

    private static boolean possibleWin(int pos, boolean wasLeapJump, boolean wasBackJump, int backJumps) {

        while (true) {
            if (pos >= l - 1) {
                pos++;
                break;
            }
            if (_leap > 1 && (pos + _leap >= l || _game[pos + _leap] == 0)) {
//                System.out.println("leap; " + pos);
                if (possibleWin(pos + _leap, true, false, 0)) {
                    pos = l;
                    break;
                }
            }
            if (!wasBackJump && _game[pos + 1] == 0) {
//                System.out.println("for; " + pos);
                if (possibleWin(pos + 1, false, false, 0)) {
                    pos = l;
                    break;
                }
            }
            if ((wasLeapJump || wasBackJump) && _game[pos - 1] == 0 && backJumps < _leap-1) {
//                System.out.println("back; " + pos);
                if (possibleWin(pos - 1, false, true, backJumps + 1)) {
                    pos = l;
                    break;
                }
            }
            break;
        }
        return pos >= l;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}