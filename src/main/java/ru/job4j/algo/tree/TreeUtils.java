package ru.job4j.algo.tree;

import ru.job4j.collection.SimpleQueue;
import ru.job4j.collection.SimpleStack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
            } catch (NoSuchElementException e) {
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
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return result;
    }


    /**
     * Метод обходит дерево root и добавляет к узлу с ключом parent
     * новый узел с ключом child, при этом на момент добавления узел с ключом parent
     * уже должен существовать в дереве, а узла с ключом child в дереве быть не должно
     * @param root корень дерева
     * @param parent ключ узла-родителя
     * @param child ключ узла-потомка
     * @return true если добавление произошло успешно и false в обратном случае.
     * @throws IllegalArgumentException если root является null
     */
    public boolean add(Node<T> root, T parent, T child) {
        if (root == null) {
            throw new IllegalArgumentException("Root can`t be null.");
        }
        if (findByKey(root, child).isPresent()) {
            return false;
        }
        Optional<Node<T>> parentOptional = findByKey(root, parent);
        if (parentOptional.isEmpty()) {
            return false;
        }
        Node<T> parentNode = parentOptional.get();
        Node<T> childNode = new Node<>(child);
        parentNode.getChildren().add(childNode);
        return true;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException("Root can`t be null.");
        }
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        while (true) {
            try {
                Node<T> current = stack.pop();
                if (current.getValue().equals(key)) {
                    return Optional.of(current);
                } else {
                    for (Node<T> node : current.getChildren()) {
                        stack.push(node);
                    }
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return Optional.empty();
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key,
     * при этом из дерева root удаляется все поддерево найденного узла
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> divideByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException("Root can`t be null.");
        }
        if (root.getValue().equals(key)) {
            return Optional.of(root);
        }
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        while (true) {
            try {
                Node<T> current = stack.pop();
                List<Node<T>> children = current.getChildren();
                for (int i = 0; i < children.size(); i++) {
                    Node<T> child = children.get(i);

                    if (child.getValue().equals(key)) {
                        children.remove(i);
                        return Optional.of(child);
                    }
                    stack.push(child);
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return Optional.empty();
    }
}