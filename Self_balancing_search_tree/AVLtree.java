
// Critical unbalancing
// maintaining overall balance of a bst
// Left-Left : Rotate right around parent 
// Left-right : Rotate left child, rotate right parent 
// Right-right : Rotate left around parent 
// Right-left : Rotate right around child, rotate left around parent 

private static class AVLNode<E> extends Node<E> {
        public static final int LEFT_HEAVY = -1;
        public static final int BALANCED = 0; 
        public static final int RIGHT_HEAVY = 1;

        private int balance;

        public AVLNode(E item) {
                super(item);
                blanace = BALANCED;
        }

        @Override 
        public String toString() {
                return balance + ": " + super.toString();
        }

        private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
                AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;

                if (leftChild.balance > AVLNode.BALANCED) {
                        AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;

                        /** Adjust the balances to be their new values after the rotations */
                        if (leftRightChild.balance < AVLNode.BALANCED) {
                                leftChild.balance = AVLNode.BALANCED;
                                leftRightChild.balance = AVLNode.RIGHT_HEAVY;
                        } else if (leftRightChild.balance > AVLNode.BALANCED) {
                                leftChild.balance = AVLNode.LEFT_HEAVY;
                                leftRightChild.balance = AVLNode.BALANCED;
                                localRoot.balance = AVLNode.BALANCED;
                        } else {
                                leftChild.balance = AVLNode.BALANCED;
                                localRoot.balance = AVLNode.BALANCED;
                        }
                        localRoot.left = rotateLeft(leftChild);
                }
                return (AVLNode<E>) rotateRight(localRoot);
        }
        private void decrementBalance (AVLNode<E> node) {
                node.balance--;
                if (node.balance == AVLNode.BALANCED) {
                        increase = false;
                }
        }
}






