package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.function.Consumer;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {

    public static class Node<T>{
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> root;
    private int size;

    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        throw new ExerciseNotCompletedException();
    }

    @Override
    public boolean insert(T element) {
        if (root==null){                //якщо кореня не існує
            root = new Node<>(element); // то ми його створюємо
            size++;
            return true;
        }else {
            return insert(root, element); // інакше викликаємо рекурсивний метод insert
        }
    }

    private boolean insert(Node<T> current, T element){
        if(element.compareTo(current.element)<0){ //якщо елемент, що додаєм, за значенням менший ніж поточний, то ми просуваємось вліво
            if (current.left == null) { //якщо лівого елементу не існує...
                current.left = new Node<>(element); // ... додаємо новий
                size++;
                return true;
            } else {
                return insert(current.left, element);// якщо лівий елемент існує, то ми йдемо рекурсивно вліво
            }

        }else if(element.compareTo(current.element)>0){ //якщо елемент, що додаєм, за значенням більший ніж поточний, то ми просуваємось вправо
               if (current.right == null){ //якщо правого немає
                   current.right = new Node<>(element); // ... додаємо новий
                   return true;
               }else {
                   return insert(current.right, element);// якщо правий елемент існує, то ми йдемо рекурсивно вправо
               }

        } else {
            return false;
        }

    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node<T> current, T element){
        if(current == null){
            return false;
        }else if(element.compareTo(current.element) < 0){ //якщо той елемент, який ми шукаємо є за значенням меншим, ніж той, в якому ми знаходмиось
            return contains(current.left, element); // рухаємось вліво
        }else if(element.compareTo(current.element) > 0){//якщо той елемент, який ми шукаємо є за значенням ,більшим, ніж той, в якому ми знаходмиось
            return contains(current.right, element); // рухаємось вправо
        }else {
            return true;
        }
    }

    @Override
    public int size() {
       return size;
    }

    @Override
    public int depth() {
        return root != null ? depth(root) -1 : 0;
    }

    private int depth(Node<T> current){
        if (current==null){
            return 0;
        }else {
            return 1 + Math.max(depth(current.left), depth(current.right));
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        throw new ExerciseNotCompletedException();
    }
}
