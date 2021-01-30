package com.giggs13.datastructure.list;

import com.giggs13.datastructure.list.model.Employee;

public class DoublyLinkedList {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.isEmpty());
        System.out.println(list.getSize());
        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        System.out.println(list.getSize());
        list.printList();

        list.removeFromEnd();
        list.removeFromEnd();
        System.out.println(list.getSize());
        list.printList();
    }

    private static class EmployeeNode {

        private Employee employee;
        private EmployeeNode next;
        private EmployeeNode previous;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getPrevious() {
            return previous;
        }

        public void setPrevious(EmployeeNode previous) {
            this.previous = previous;
        }

        public EmployeeNode getNext() {
            return next;
        }

        public void setNext(EmployeeNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return employee.toString();
        }
    }

    private static class EmployeeLinkedList {

        private EmployeeNode head;
        private EmployeeNode tail;
        private int size;

        public void addToFront(final Employee employee) {
            EmployeeNode node = new EmployeeNode(employee);

            if (head == null) {
                tail = node;
            } else {
                node.setNext(head);
                head.setPrevious(node);
            }

            head = node;
            size++;
        }

        public void addToEnd(final Employee employee) {
            EmployeeNode node = new EmployeeNode(employee);

            if (head == null) {
                head = node;
            } else {
                tail.setNext(node);
                node.setPrevious(tail);
            }

            tail = node;
            size++;
        }

        public EmployeeNode removeFromFront() {
            if (isEmpty()) {
                return null;
            }

            EmployeeNode removedNode = head;

            if (head.getNext() == null) {
                tail = null;
            } else {
                head.getNext().setPrevious(null);
            }

            head = head.getNext();
            removedNode.setNext(null);
            size--;

            return removedNode;
        }

        public EmployeeNode removeFromEnd() {
            if (isEmpty()) {
                return null;
            }

            EmployeeNode removedNode = tail;

            if (tail.getPrevious() == null) {
                head = null;
            } else {
                tail.getPrevious().setNext(null);
            }

            tail = tail.getPrevious();
            removedNode.setPrevious(null);
            size--;

            return removedNode;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void printList() {
            EmployeeNode current = head;
            System.out.print("HEAD -> ");
            while (current != null) {
                System.out.print(current);
                System.out.print(" <=> ");
                current = current.getNext();
            }
            System.out.println("null");
        }
    }
}