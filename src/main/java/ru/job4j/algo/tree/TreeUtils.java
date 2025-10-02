package ru.job4j.algo.tree;

import ru.job4j.collection.SimpleQueue;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils<T> {

    /**
     * Метод выполняет обход дерева и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        int result = 0;
        if (root == null) {
            throw new IllegalArgumentException("Корень не может быть пустым");
        }
        queue.push(root);
        while (true) {
            try {
                Node<T> node = queue.poll();
                result++;
                List<Node<T>> children = node.getChildren();
                for (Node<T> child : children) {
                    queue.push(child);
                }
            } catch (java.util.NoSuchElementException e) {
                break;
            }
        }
        return result;
    }

    /**
     * Метод выполняет обход дерева и возвращает коллекцию ключей узлов дерева
     * @param root корневой узел
     * @return коллекция с ключами, реализующая интерфейс Iterable<E>
     * @throws IllegalArgumentException если root является null
     */
    public Iterable<T> findAll(Node<T> root) {
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        List<T> result = new ArrayList<>();
        if (root == null) {
            throw new IllegalArgumentException("Корень не может быть пустым");
        }
        queue.push(root);
        while (true) {
            try {
                Node<T> node = queue.poll();
                result.add(node.getValue());
                List<Node<T>> children = node.getChildren();
                for (Node<T> child : children) {
                    queue.push(child);
                }
            } catch (java.util.NoSuchElementException e) {
                break;
            }
        }
        return result;
    }
}