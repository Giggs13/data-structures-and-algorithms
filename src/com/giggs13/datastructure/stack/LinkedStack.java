package com.giggs13.datastructure.stack;

import com.giggs13.datastructure.list.model.Employee;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedStack {

    private LinkedList<Employee> stack = new LinkedList<>();

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(janeJones);
        linkedStack.push(johnDoe);
        linkedStack.push(marySmith);
        linkedStack.push(mikeWilson);

        linkedStack.printStack();
        System.out.println("peek -> " + linkedStack.peek());
        linkedStack.printStack();
        System.out.println("pop -> " + linkedStack.pop());
        System.out.println("pop -> " + linkedStack.pop());
        linkedStack.printStack();
    }

    public void push(final Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public void printStack() {
        System.out.println();
        stack.forEach(System.out::println);
        System.out.println();
    }
}
