package de.sunbits.hackerrank.java.tree_top_view;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Node {

  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  @Override
  public String toString() {
    return "Node{" +
            "left=" + left +
            ", right=" + right +
            ", data=" + data +
            '}';
  }
}

class Solution {

  static Deque<Integer> result = new ArrayDeque<Integer>();

  static int currentMaxLeft, currentMaxRight = 0;

  public static void solve(Node root, int leftIndex, int rightIndex, boolean walkLeft) {

    if (root.left != null && walkLeft) {
      if (leftIndex + 1 > currentMaxLeft) {
        result.addFirst(root.left.data);
        currentMaxLeft++;
      }
    }

    if (root.right != null && !walkLeft) {
      if (rightIndex + 1 > currentMaxRight) {
        result.addLast(root.right.data);
        currentMaxRight++;
      }
    }

    if (walkLeft) {
      if (root.left != null) {
        solve(root.left, leftIndex + 1, rightIndex - 1, walkLeft);
      }
      if (root.right != null) {
        solve(root.right, leftIndex - 1, rightIndex + 1, walkLeft);
      }
    } else {
      if (root.right != null) {
        solve(root.right, leftIndex - 1, rightIndex + 1, walkLeft);
      }
      if (root.left != null) {
        solve(root.left, leftIndex + 1, rightIndex - 1, walkLeft);
      }

    }

  }

  /*

    class Node
      int data;
      Node left;
      Node right;
  */
  public static void topView(Node root) {

    result.addLast(root.data);
    solve(root, 0, 0, true);
    solve(root, 0, 0, false);

    for (Integer i : result) {
      System.out.print(i + " ");

    }

//    System.out.println(root);
//
//    Node leftRoot = root;
//
//    List<Integer> left = new ArrayList<>();
//
//
//    while (leftRoot.left != null) {
//
//      left.add(leftRoot.left.data);
//      leftRoot = leftRoot.left;
//
//    }
//
//    List<Integer> right = new ArrayList<>();
//    Node rightRoot = root;
//    while (rightRoot.right != null) {
//      right.add(rightRoot.right.data);
//      rightRoot = rightRoot.right;
//
//    }
//
//    for (int i = left.size()-1;i>=0;i--){
//      System.out.print(left.get(i) +" ");
//    }
//    System.out.print(root.data +" ");
//    for (int i =0;i<right.size();i++) {
//      System.out.print(right.get(i) +" ");
//    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      return new Node(data);
    } else {
      Node cur;
      if (data <= root.data) {
        cur = insert(root.left, data);
        root.left = cur;
      } else {
        cur = insert(root.right, data);
        root.right = cur;
      }
      return root;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    topView(root);
  }
}