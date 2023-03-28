package de.sunbits.hackerrank.java.minimum_loss;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultTest {

  @Test
  void minimumLoss2() {

    Long[] prices = new Long[]{5l, 10l, 3l};

    int min = Result.minimumLoss(Arrays.asList(prices));
    Assert.assertEquals(2, min);
  }

  @Test
  void minimumLoss22() {

    Long[] prices = new Long[]{20l, 7l, 8l, 2l, 5l};

    int min = Result.minimumLoss(Arrays.asList(prices));
    Assert.assertEquals(2, min);
  }


}