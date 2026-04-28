package org.example;

public class BinaryTree<K extends Comparable<K>, V> {
    private Node<Association<K, V>> root;

    public void insert(K key, V value) {
        root = insertRec(root, new Association<>(key, value));
    }

    private Node<Association<K, V>> insertRec(Node<Association<K, V>> node, Association<K, V> data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.getKey().compareTo(node.data.getKey()) < 0) {
            node.left = insertRec(node.left, data);
        } else {
            node.right = insertRec(node.right, data);
        }

        return node;
    }

    public V search(K key) {
        return searchRec(root, key);
    }

    private V searchRec(Node<Association<K, V>> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.data.getKey());

        if (cmp == 0) {
            return node.data.getValue();
        } else if (cmp < 0) {
            return searchRec(node.left, key);
        } else {
            return searchRec(node.right, key);
        }
    }

    // Recorrido in-order
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<Association<K, V>> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println("(" + node.data.getKey() + ", " + node.data.getValue() + ")");
            inOrderRec(node.right);
        }
    }
}