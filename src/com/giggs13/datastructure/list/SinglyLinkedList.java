package com.giggs13.datastructure.list;

import com.giggs13.datastructure.list.model.Employee;

public class SinglyLinkedList {

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
    }

    private static class EmployeeNode {

        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
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
        private int size;

        public void addToFront(final Employee employee) {
            EmployeeNode node = new EmployeeNode(employee);
            node.setNext(head);
            head = node;
            size++;
        }

        public EmployeeNode removeFromFront() {
            if (isEmpty()) {
                return null;
            }

            EmployeeNode removedNode = head;
            head = head.getNext();
            removedNode.setNext(null);
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
                System.out.print(" -> ");
                current = current.getNext();
            }
            System.out.println("null");
        }
    }
}