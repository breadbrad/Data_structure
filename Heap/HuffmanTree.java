import java.util.*;
import java.io.*;

public class HuffmanTree implements Serializable {
        // Nested Classes
        public sattic class HuffData implements Serializable {
                private double weight;
                private Character symbol;

                public HuffData(double weight, Character symbol) {
                        this.weight = weight;
                        this.symbol = symbol;
                }

        }

        /** A reference to the completed Huffman tree */
        private BinaryTree<HuffData> huffTree;

        // BinaryTree class does not implement Comparable 
    u   // -> Comparator needs to be defined (compare() for comparing two BinaryTree<HuffData> objects

        /** A Comparator for Huffman trees; nested class*/
        private static class CompareHuffmaTrees implements Comparator<BinaryTree<HuffData>> {
                /** Compare two objects  
                        -1 left < right 
                         0 left == right
                         1 left > right */
                public int compare(BinaryTree<HuffData> treeLeft, BinaryTree<HuffData> treeRight) {
                        double wLeft = treeLeft.getData().weight;
                        double wRight = treeRight.getData().weight;
                        return Double.compare(wLeft, wRight);
                }
        }

        public void buildTree(HuffData[] symbols) {
                Queue<BinaryTree<HuffData>> theQueue = new PriorityQueue<BinaryTree<HuffData>>();
                // Load the queue with the leaves 
                for(HuffData nextSymbol: symbols) {
                        BinaryTree<HuffData> aBinaryTree = new BinaryTree<HuffData> (nextSymbol, null, null);
                        theQueue.offer(aBinaryTree);
                }

                while (theQueue.size() > 1) {
                        BinaryTree<HuffData> left  = theQueue.poll(); 
                        BinaryTree<HuffData> right = theQueue.poll();
                        double wl = treeLeft.getData().weight;
                        double wr = treeRight.getData().weight;
                        HuffData sum = new HuffData(wl+wr, null);
                        BinaryTree<HuffData> newTree = new BinaryTree<HuffData> (sum, left, right) 
                        theQueue.offer(newTree);
                }

                huffTree = theQueue.poll();
        }

        private void printCode(PriorityQueue out, String code, BinaryTree<HuffData> tree) {
                HuffData theData = tree.getData();
                if (theData.symbol != null) {
                        if(theData.symbol.equals(" ")) {
                        out.println("space: " + space);
                        } else { 
                                out.println(theData.symbol + ": " + code);
                        }
                } else {
                        printCode(out, code + "0", tree.getLeftSubtree());
                        printCode(out, code + "1", tree.getRightSubtree());
                }
        }
        
        public String decode(String codeMessage) {
                StringBuilder result = new StringBuilder();
                BinaryTree<HuffData> currentTree = huffTree;
                for (int i = 0; i < codeMessage.length(); i++) {
                        if (codeMessage.charAt(i) == '1') {
                                currentTree = currentTree.getRightSubtree();
                        } else {
                                currentTree = currentTree.getLeftSubtree();
                        } if (currentTree.isLeaf()) {
                                HuffData theData = currentTree.getData();
                                result.append(theData.symbol);
                                currentTree = huffTree;
                        }
                }
                return result.toString();
        }
}
        
