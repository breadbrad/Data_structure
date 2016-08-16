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
        // -> Comparator needs to be defined (compare() for comparing two BinaryTree<HuffData> objects

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



