package de.sunbits.hackerrank.java.even_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;


class NodeTree {

  private int id;
  private NodeTree parent = null;

  private HashMap<Integer, NodeTree> childs = new HashMap<>();

  private int totalChildsCount = 0;

  public NodeTree(final int id) {
    this.id = id;
  }

  public void addChild(NodeTree child, int parentId) {
    if (parentId == this.id) {
      child.parent = this;
      childs.put(child.id, child);
      totalChildsCount++;
    } else {
      addChild(this, child, parentId);
    }
  }

  private boolean addChild(NodeTree parent, NodeTree child, int parentId) {
    boolean found = false;
    if (parentId == parent.id) {
      child.parent = parent;
      parent.childs.put(child.id, child);
      parent.totalChildsCount++;

      found = true;
    } else { // use hashmap parent id to get node
      for (NodeTree node : parent.childs.values()) {
        found = addChild(node, child, parentId);
        if (found) {
          parent.totalChildsCount++;
          break;
        }
      }
    }
    return found;
  }


  public int countCuts() {
    return countCuts(this);
  }

  private int countCuts(NodeTree node) {

    int cuts = 0;

    if (node.totalChildsCount > 3) {
      System.out.println("cutting: 1 " + node + "---> " + cuts);
      for (NodeTree aNode : node.childs.values()) {
        if (aNode.totalChildsCount % 2 != 0) {
          System.out.println("cutting: 1.2 " + node + "---> " + cuts + " with: " + aNode);
          cuts++;
          node.totalChildsCount -= aNode.totalChildsCount - 1;
          if (node.parent != null) {
            node.parent.totalChildsCount -= aNode.totalChildsCount - 1;
          }
          System.out.println("cutting: 1.2.1 " + node + "---> " + cuts + " with: " + aNode);
        }
        if (aNode.totalChildsCount > 3) {
          System.out.println("cutting: 1.1 " + node + "---> " + cuts + " with: " + aNode);
          cuts += countCuts(aNode);
          System.out.println("cutting: 1.1.1 " + node + "---> " + cuts + " with: " + aNode);
        }


      }
    }
    if (node.totalChildsCount % 2 != 0 && node.parent != null) {
      System.out.println("cutting: 2 " + node + "---> " + cuts);
      cuts++;
      node.totalChildsCount -= node.totalChildsCount - 1;
      node.parent.totalChildsCount -= node.totalChildsCount - 1;
      System.out.println("cutting: 2.1 " + node + "---> " + cuts);
    }
    System.out.println("cutting: " + node + "---> " + cuts);
    return cuts;


  }

  @Override
  public String toString() {
    return "NodeTree{" +
            "id=" + id +
            ", parent=" + parent +
//            ", childs=" + childs +
            ", totalChildsCount=" + totalChildsCount +
            '}';
  }
}

public class Solution {

  // Complete the evenForest function below.

  static int countCuts(int nodeId, List<List<Integer>> graph, int[] count) {
    count[nodeId] = 1;
    int cuts = 0;
    for (Integer childNodeId : graph.get(nodeId)) {
      if (count[childNodeId] == 0) {
        cuts += countCuts(childNodeId, graph, count);
        count[nodeId] += count[childNodeId];

        System.out.print(nodeId + " --> CHECK Counts :[");
        for (int i =1; i< count.length;i++) {
          if (i > 1)
            System.out.print(", ");
          System.out.print(count[i]);
        }
        System.out.println("]");

        if (count[childNodeId] % 2 == 0) {
          System.out.println("cutting " + childNodeId +" from: " +nodeId );
          cuts++;
        }
      }
    }
    System.out.print(nodeId + " --> Counts :[");
    for (int i =1; i< count.length;i++) {
      if (i > 1)
        System.out.print(", ");
      System.out.print(count[i]);
    }
    System.out.println("]");
    return cuts;
  }

  static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {

    List<List<Integer>> graph = new ArrayList<List<Integer>>(t_nodes + 1);

    for (int i = 0; i <= t_nodes; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < t_to.size(); i++) {
      int to = t_to.get(i);
      int from = t_from.get(i);
      graph.get(to).add(from);
//      graph.get(from).add(to);
    }

    System.out.println("Graph: " + graph);

    int[] count = new int[t_nodes + 1];
    int cuts = countCuts(1, graph, count);

    System.out.println("Cuts: " + cuts);

    return cuts;

//    NodeTree root = new NodeTree(t_to.get(0));
//    root.addChild(new NodeTree(t_from.get(0)), t_to.get(0));
//    for (int i = 1; i < t_to.size(); i++) {
//      root.addChild(new NodeTree(t_from.get(i)), t_to.get(i));
//
//    }
//    int cuts = root.countCuts();
//    System.out.println("Cuts: " + cuts);
//    return cuts;

  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int tNodes = Integer.parseInt(tNodesEdges[0]);
    int tEdges = Integer.parseInt(tNodesEdges[1]);

    List<Integer> tFrom = new ArrayList<>();
    List<Integer> tTo = new ArrayList<>();

    IntStream.range(0, tEdges).forEach(i -> {
      try {
        String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        tFrom.add(Integer.parseInt(tFromTo[0]));
        tTo.add(Integer.parseInt(tFromTo[1]));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    int res = evenForest(tNodes, tEdges, tFrom, tTo);

//    bufferedWriter.write(String.valueOf(res));
//    bufferedWriter.newLine();

    bufferedReader.close();
//    bufferedWriter.close();
  }
}