import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    public int getResult() {
        //implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
        //
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private final int MOD = 1000000007;
    private long sum = 1;

    public int getResult() {
        //implement this
        return (int) sum;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            int v = node.getValue() == 0 ? 1 : node.getValue();
            sum = sum * v % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            int v = leaf.getValue() == 0 ? 1 : leaf.getValue();
            sum = sum * v % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumEvenN = 0;
    private int sumGLeaf = 0;

    public int getResult() {
        //implement this
        int sum = sumEvenN - sumGLeaf;
        return sum < 0 ? sum * -1 : sum;
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumEvenN += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGLeaf += leaf.getValue();
        }
    }
}

public class VisitorProblem {


//    private static int nodeValues[];
//    private static Color nodeColors[];
//    private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();

   /* public static Tree solve2() {

        Scanner in = new Scanner(System.in);

        int numberOfNodes = in.nextInt();

        nodeValues = new int[numberOfNodes];
        for(int index = 0; index < numberOfNodes; index++) {
            nodeValues[index] = in.nextInt();
        }

        nodeColors = new Color[numberOfNodes];
        for(int index = 0; index < numberOfNodes; index++) {
            nodeColors[index] = (in.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        Tree rootNode;
        if(numberOfNodes == 1) {
            rootNode = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
        }
        else {
            for(int index = 0; index < (numberOfNodes - 1); index++) {
                int u = in.nextInt();
                int v = in.nextInt();
                Set<Integer> uEdges = nodesMap.get(u);
                if(uEdges == null) {
                    uEdges = new HashSet<>();
                }
                uEdges.add(v);
                nodesMap.put(u, uEdges);
                Set<Integer> vEdges = nodesMap.get(v);
                if(vEdges == null) {
                    vEdges = new HashSet<>();
                }
                vEdges.add(u);
                nodesMap.put(v, vEdges);
            }

            rootNode = new TreeNode(nodeValues[0], nodeColors[0], 0);
            Set<Integer> rootEdges = nodesMap.get(1);
            Iterator<Integer> rootIterator = rootEdges.iterator();
            while(rootIterator.hasNext()) {
                Integer nodeIdentifier = rootIterator.next();
                nodesMap.get(nodeIdentifier).remove(1);
                createEdge(rootNode, nodeIdentifier);
            }
        }

        return rootNode;
    }

    private static void createEdge(Tree parentNode, Integer nodeIdentifier) {

        Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
        boolean hasChild = false;
        if(nodeEdges != null && !nodeEdges.isEmpty())
            hasChild = true;

        if(hasChild) {
            TreeNode node = new TreeNode(nodeValues[nodeIdentifier - 1], nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode) parentNode).addChild(node);
            Iterator<Integer> nodeIterator = nodeEdges.iterator();
            while(nodeIterator.hasNext()) {
                Integer neighborNodeIdentifier = nodeIterator.next();
                nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, neighborNodeIdentifier);
            }
        }
        else {
            TreeLeaf leaf = new TreeLeaf(nodeValues[nodeIdentifier - 1], nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode) parentNode).addChild(leaf);
        }
    }*/


    //39660110
    //259313238
    //14563025

    //40653
    //693537731
    //14761


    private static final Map<Integer, Set<Integer>> edges = new HashMap<>();
    private static int nodeValues[];
    private static Color nodeColors[];

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function

        Scanner in = new Scanner(System.in);
        int numberNodes = Integer.parseInt(in.nextLine());

        nodeValues = new int[numberNodes];
        for (int index = 0; index < numberNodes; index++) {
            nodeValues[index] = in.nextInt();
        }

        nodeColors = new Color[numberNodes];
        for (int index = 0; index < numberNodes; index++) {
            nodeColors[index] = (in.nextInt() == 1) ? Color.GREEN : Color.RED;
        }

        for (int i = 0; i < numberNodes - 1; i++) {

            int root = in.nextInt();
            int current = in.nextInt();

            Set<Integer> rEdge = edges.get(root - 1);
            Set<Integer> cEdge = edges.get(current - 1);

            if (rEdge == null) {
                rEdge = new HashSet<Integer>();
            }
            if (cEdge == null) {
                cEdge = new HashSet<Integer>();
            }

            rEdge.add(current - 1);
            cEdge.add(root - 1);
            edges.put(root - 1, rEdge);
            edges.put(current - 1, cEdge);
        }

        Tree rootNode = new TreeNode(nodeValues[0], nodeColors[0], 0);
        Set<Integer> rEdges = edges.get(0);
        for (Integer cNum : rEdges) {
            edges.get(cNum).remove(0);
            buildTree(rootNode, cNum);
        }
        return rootNode;

    }

    private static void buildTree(Tree parent, Integer child) {

        Set<Integer> cEdges = edges.get(child);
        if (cEdges == null || cEdges.isEmpty()) {
            TreeLeaf leaf = new TreeLeaf(nodeValues[child], nodeColors[child], parent.getDepth() + 1);
            ((TreeNode) parent).addChild(leaf);
        } else {
            TreeNode node = new TreeNode(nodeValues[child], nodeColors[child], parent.getDepth() + 1);
            for (Integer cNum : cEdges) {
                edges.get(cNum).remove(child);
                buildTree(node, cNum);
            }
            ((TreeNode) parent).addChild(node);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}