package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(parent).isPresent() && findBy(child).isEmpty()) {
            result = findBy(parent).get().children.add(new Node<>(child));
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(eNode -> eNode.value.equals(value));
//        Optional<Node<E>> result = Optional.empty();
//        Queue<Node<E>> data = new LinkedList<>();
//        data.offer(this.root);
//        while (!data.isEmpty()) {
//            Node<E> element = data.poll();
//            if (element.value.equals(value)) {
//                result = Optional.of(element);
//                break;
//            }
//            data.addAll(element.children);
//        }
//        return result;
    }

    public boolean isBinary() {
        return findByPredicate(eNode -> eNode.children.size() > 2).isEmpty();

//        boolean result = true;
//        Queue<Node<E>> data = new LinkedList<>();
//        data.offer(this.root);
//        while (!data.isEmpty()) {
//            Node<E> element = data.poll();
//            if (element.children.size() > 2) {
//                result = false;
//                break;
//            }
//            data.addAll(element.children);
//        }
//        return result;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (condition.test(element)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return result;
    }
}