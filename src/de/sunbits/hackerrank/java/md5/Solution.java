package de.sunbits.hackerrank.java.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    Scanner in = new Scanner(System.in);
    String word = in.next();
    String md5Hash = null;
    try {
      // for MD5
//      MessageDigest md = MessageDigest.getInstance("SHA-256");
      //for SHA-256
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte[] hashBytes = md.digest(word.getBytes());
      StringBuilder sb = new StringBuilder();
      for (byte b : hashBytes) {
        sb.append(String.format("%02x", b));
      }
      md5Hash = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    System.out.println(md5Hash);
  }
}