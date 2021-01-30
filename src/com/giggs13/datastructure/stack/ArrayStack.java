package com.giggs13.datastructure.stack;

import com.giggs13.datastructure.list.model.Employee;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(final int capacity) {
        stack = new Employee[capacity];
    }

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(janeJones);
        arrayStack.push(johnDoe);
        arrayStack.push(marySmith);
        arrayStack.push(mikeWilson);

        arrayStack.printStack();
        System.out.println("peek -> " + arrayStack.peek());
        arrayStack.printStack();
        System.out.println("pop -> " + arrayStack.pop());
        System.out.println("pop -> " + arrayStack.pop());
        arrayStack.printStack();
    }

    public void push(final Employee employee) {
        if (top == stack.length) {
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;

        return employee;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public void printStack() {
        System.out.println();
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        System.out.println();
    }
}
