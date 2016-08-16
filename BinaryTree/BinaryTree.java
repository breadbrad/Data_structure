import java.io.*;

public class BinaryTree<T> implements Serializable {
 	/** Three constructors */
 	public BinaryTree() {
 		root = null;
 	}

 	protected BinaryTree(Node<T> root) {
 		this.root = root;
 	}
 	// e.g. BinaryTree<Character> bt = new BinaryTree('*', lT, rT);
 	public BinaryTree(T data, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
 		root = new Node<T> (data);
 		if (leftTree != null) {
 			root.left = leftTree.root;
 		} else {
 			root.left = null;
 		}
 		if (rightTree != null) {
 			root.right = rightTree.root;
 		} else {
 			root.right = null;
 		}
 	}

 	public BinaryTree<T> getLeftSubtree() {
 		if (root != null && root.left != null) {
 			return new BinaryTree<T>(root.left);
 		} else {
 			return new BinaryTree<T> (null);
 		}
 	}

 	public BinaryTree<T> getRightSubtree() {
 		if (root != null && root.right != null) {
 			return new BinaryTree<T>(root.right);
 		} else {
 			return new BinaryTree<T> (null);
 		}
 	}

 	public boolean isLeaf() {
 		return root == null || (root.left == null && root.right == null);
 	}

        public String toString() {
                Stringbuilder sb = new Stringbuilder();
                preOrderTraversal(root, 1, sb);
                return sb.toString();
        }

        private void preOrderTraversal(Node<E> node, int depth, Stringbuilder sb) {
                for (int i = 1; i < depth; i++) {
                        sb.append(" ");
                }
                if (node == null) {
                        sb.append("null/n");
                } else {
                        node.append(node.toString());
                        node.append("/n");
                        preOrderTraversal(node.left, depth+1, sb);
                        preOrderTraversal(node.right,depth+1, sb);
                }
        }
        public static BinaryTree<String> readBinaryTree(Scanner scan) {
                String data = scan.next();
                if(data.equals("null")) {
                        return null;
                } else { 
                        BinaryTree<String> leftTree = readBinary(scan);
                        BinaryTree<String> rightTree = readBinary(scan);
                        return new BinaryTree<String>(data, leftTree, rightTree);
                }
        }

        
}