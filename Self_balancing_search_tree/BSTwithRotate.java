public class BSTwithRotate<E extends Comparable<E>> extends BST<E> {
        protected Node<E> rotateRight(Node<E> root) {
                Node<E> temp = root.left;
                root.left = temp.right;
                temp.right = root;
                return temp;
        }
        
        protected Node<E> rotateLeft(Node<E> root) {
                Node<E> temp = root.right;
                root.right = temp.left;
                temp.left = root;
                retunr temp;
        }
}
