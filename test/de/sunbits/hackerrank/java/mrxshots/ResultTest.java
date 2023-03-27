package de.sunbits.hackerrank.java.mrxshots;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultTest {
    @Test
    void testSolve9() {
        List<List<Integer>> xshots = new ArrayList<>();
        List<List<Integer>> players = new ArrayList<>();


        xshots.add(Arrays.asList(1, 2));
        xshots.add(Arrays.asList(2, 3));
        xshots.add(Arrays.asList(4, 5));
        xshots.add(Arrays.asList(6, 7));
        players.add(Arrays.asList(1, 5));
        players.add(Arrays.asList(2, 3));
        players.add(Arrays.asList(4, 7));
        players.add(Arrays.asList(5, 7));

        int strength = Result.solve(xshots,players);

        Assert.assertEquals(9, strength);
    }

    @Test
    void testSolve1621() {
        List<List<Integer>> xshots = new ArrayList<>();
        List<List<Integer>> players = new ArrayList<>();

        xshots.add(Arrays.asList(16, 52));
        xshots.add(Arrays.asList(92, 177));
        xshots.add(Arrays.asList(46, 139));
        xshots.add(Arrays.asList(91, 146));
        xshots.add(Arrays.asList(43, 139));
        xshots.add(Arrays.asList(83, 118));
        xshots.add(Arrays.asList(65, 77));
        xshots.add(Arrays.asList(11, 12));
        xshots.add(Arrays.asList(41, 66));
        xshots.add(Arrays.asList(99, 188));
        xshots.add(Arrays.asList(67, 86));
        xshots.add(Arrays.asList(28, 37));
        xshots.add(Arrays.asList(76, 125));
        xshots.add(Arrays.asList(61, 79));
        xshots.add(Arrays.asList(28, 93));
        xshots.add(Arrays.asList(75, 154));
        xshots.add(Arrays.asList(81, 146));
        xshots.add(Arrays.asList(90, 114));
        xshots.add(Arrays.asList(84, 173));
        xshots.add(Arrays.asList(17, 112));
        xshots.add(Arrays.asList(94, 130));
        xshots.add(Arrays.asList(31, 66));
        xshots.add(Arrays.asList(75, 128));
        xshots.add(Arrays.asList(55, 137));
        xshots.add(Arrays.asList(38, 89));
        xshots.add(Arrays.asList(38, 47));
        xshots.add(Arrays.asList(86, 116));
        xshots.add(Arrays.asList(43, 56));
        xshots.add(Arrays.asList(75, 103));
        xshots.add(Arrays.asList(91, 183));
        xshots.add(Arrays.asList(28, 94));
        xshots.add(Arrays.asList(17, 77));
        xshots.add(Arrays.asList(47, 66));
        xshots.add(Arrays.asList(39, 86));
        xshots.add(Arrays.asList(29, 56));
        xshots.add(Arrays.asList(43, 135));
        xshots.add(Arrays.asList(24, 103));
        xshots.add(Arrays.asList(13, 50));
        xshots.add(Arrays.asList(78, 131));
        xshots.add(Arrays.asList(34, 48));
        xshots.add(Arrays.asList(68, 134));
        xshots.add(Arrays.asList(16, 25));
        xshots.add(Arrays.asList(71, 138));
        xshots.add(Arrays.asList(82, 144));
        xshots.add(Arrays.asList(37, 121));
        xshots.add(Arrays.asList(39, 48));
        xshots.add(Arrays.asList(12, 58));
        xshots.add(Arrays.asList(46, 79));
        xshots.add(Arrays.asList(78, 139));

        players.add(Arrays.asList(73, 120));
        players.add(Arrays.asList(61, 118));
        players.add(Arrays.asList(38, 41));
        players.add(Arrays.asList(93, 101));
        players.add(Arrays.asList(77, 124));
        players.add(Arrays.asList(78, 106));
        players.add(Arrays.asList(95, 177));
        players.add(Arrays.asList(43, 132));
        players.add(Arrays.asList(95, 97));
        players.add(Arrays.asList(39, 104));
        players.add(Arrays.asList(35, 92));
        players.add(Arrays.asList(19, 94));
        players.add(Arrays.asList(33, 109));
        players.add(Arrays.asList(8, 62));
        players.add(Arrays.asList(46, 87));
        players.add(Arrays.asList(35, 37));
        players.add(Arrays.asList(42, 133));
        players.add(Arrays.asList(34, 35));
        players.add(Arrays.asList(38, 78));
        players.add(Arrays.asList(54, 137));
        players.add(Arrays.asList(63, 109));
        players.add(Arrays.asList(89, 147));
        players.add(Arrays.asList(24, 81));
        players.add(Arrays.asList(72, 163));
        players.add(Arrays.asList(17, 93));
        players.add(Arrays.asList(88, 180));
        players.add(Arrays.asList(20, 109));
        players.add(Arrays.asList(73, 145));
        players.add(Arrays.asList(84, 166));
        players.add(Arrays.asList(53, 121));
        players.add(Arrays.asList(69, 154));
        players.add(Arrays.asList(6, 78));
        players.add(Arrays.asList(88, 140));
        players.add(Arrays.asList(54, 59));
        players.add(Arrays.asList(19, 25));
        players.add(Arrays.asList(89, 105));
        players.add(Arrays.asList(58, 82));
        players.add(Arrays.asList(5, 92));
        players.add(Arrays.asList(39, 43));
        players.add(Arrays.asList(90, 184));
        players.add(Arrays.asList(51, 141));
        players.add(Arrays.asList(93, 142));
        players.add(Arrays.asList(66, 105));
        players.add(Arrays.asList(45, 104));
        players.add(Arrays.asList(62, 112));
        players.add(Arrays.asList(94, 96));
        players.add(Arrays.asList(3, 28));
        players.add(Arrays.asList(5, 55));
        players.add(Arrays.asList(1, 14));
        players.add(Arrays.asList(1, 56));

        int strength = Result.solve(xshots,players);

        Assert.assertEquals(1621, strength);
    }
}