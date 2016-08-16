public E find (E target) {
        return find (root, target);
}

private E find (Node<E> localRoot, E target) {
        if(localRoot == null)
                return null;
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
                return localRoot.data;
        else if (compResult < 0)
                return find(localRoot.left, target);
        else 
                return find(localRoot.right, target);
}
