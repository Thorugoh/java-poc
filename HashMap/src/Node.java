class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;
    final int hash;

    Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class TreeNode<K, V> extends Node<K, V> {
    TreeNode<K, V> parent;
    TreeNode<K, V> left;
    TreeNode<K, V> right;
    boolean red;

    TreeNode(int hash, K key, V value, Node<K, V> next) {
        super(hash, key, value, next);
        this.red = true;
    }

    final void treeify(Node<K, V>[] table, int bucketIndex) {
        TreeNode<K, V> root = null;
        TreeNode<K, V> nodeToInsert = this;

        while(nodeToInsert != null) {
            TreeNode<K, V> nextNode = (TreeNode<K, V>) nodeToInsert.next;

            nodeToInsert.left = null;
            nodeToInsert.right = null;

            if(root == null) {
                nodeToInsert.parent = null;
                nodeToInsert.red = false;
                root = nodeToInsert;
            } else {
                K keyToInsert = nodeToInsert.key;
                int hashToInsert = nodeToInsert.hash;
                TreeNode<K, V> currentTreeElement = root;

                while(true) {
                    int direction; // -1 for left, 1 for right
                    int currentTreeHash = currentTreeElement.hash;
                    K currentTreeKey = currentTreeElement.key;

                    if(hashToInsert < currentTreeHash) {
                        direction = -1; //left
                    } else if (hashToInsert > currentTreeHash) {
                        direction = 1; //right
                    } else {
                        direction = tieBreakOrder(keyToInsert, currentTreeKey);
                    }

                    TreeNode<K, V> parentCandidate = currentTreeElement;

                    if(direction == -1) {
                        currentTreeElement = currentTreeElement.left;
                    } else {
                        currentTreeElement = currentTreeElement.right;
                    }

                    if(currentTreeElement == null) {
                        nodeToInsert.parent = parentCandidate;

                        if(direction == -1) {
                            parentCandidate.left = nodeToInsert;
                        } else {
                            parentCandidate.right = nodeToInsert;
                        }

                        // balanceInsertion(root, nodeToInsert);
                        break;
                    }
                }
            }
            nodeToInsert = nextNode;
        }
        moveRootToFront(table, bucketIndex, root);
    }

//    TreeNode<K, V> rotateLeft(TreeNode<K, V> root, TreeNode<K, V> nodeToRotate) {
//        TreeNode<K, V> rightChild;
//        TreeNode<K, V> middleNode;
//        TreeNode<K, V> grandParent;
//    }

    int tieBreakOrder(Object keyA, Object keyB) {
        int comparison;
        if (keyA == null || keyB == null ||
                (comparison = keyA.getClass().getName().compareTo(keyB.getClass().getName())) == 0) {
            // Se as classes forem iguais, usa o endereço de memória nativo
            comparison = (System.identityHashCode(keyA) <= System.identityHashCode(keyB) ? -1 : 1);
        }
        return comparison;
    }

    void moveRootToFront(Node<K, V>[] table, int index, TreeNode<K, V> root) {
        table[index] = root;
    }
}