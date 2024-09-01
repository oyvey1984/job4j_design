package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int inputSize;
    private int outputSize;

    public T poll() {
        if (inputSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        while (inputSize != 0) {
            output.push(input.pop());
            inputSize--;
            outputSize++;
        }
        T result = output.pop();
        outputSize--;
        while (outputSize != 0) {
            input.push(output.pop());
            outputSize--;
            inputSize++;
        }
        return result;
    }

    public void push(T value) {
        input.push(value);
        inputSize++;
    }
}