package practice.custom_data_structure;

import java.util.HashMap;

class LRUCache {

    static class LinkedListNode<T> {
        int key;
        T data;
        LinkedListNode<T> next;
        LinkedListNode<T> prev;

        public LinkedListNode(int key, T data) {
            this.key = key;
            this.data = data;
        }
    }

    static public class LinkedList<T> {
        private LinkedListNode<T> head;
        private LinkedListNode<T> tail;
        private int length;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public int size() {
            return this.length;
        }

//        public void insertAtHead(T data) {
//            LinkedListNode<T> newNode = new LinkedListNode<T>(data);
//            if (this.head == null) {
//                this.head = newNode;
//                this.tail = newNode;
//            } else {
//                newNode.next = this.head;
//                this.head.prev = newNode;
//                this.head = newNode;
//            }
//            this.length++;
//        }

//        public void insertAtTail(T data) {
//            LinkedListNode<T> newNode = new LinkedListNode<T>(data);
//            if (this.head == null) {
//                this.head = newNode;
//                this.tail = newNode;
//            } else {
//                this.tail.next = newNode;
//                newNode.prev = this.tail;
//                this.tail = newNode;
//            }
//            this.length++;
//        }

        public void addFirst(LinkedListNode<T> newNode) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }
            this.length++;
        }

        public void addLast(LinkedListNode<T> newNode) {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                this.tail = newNode;
            }
            this.length++;
        }

        public void remove(T data) {
            LinkedListNode<T> tmp = this.head;
            while (tmp != null) {
                if (tmp.data == data) {
                    this.remove(tmp);
                    return;
                }
                tmp = tmp.next;
            }
        }

        public void remove(LinkedListNode<T> node) {
            if (node == null)
                return;
            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            if (node == this.head)
                this.head = this.head.next;
            if (node == this.tail) {
                this.tail = this.tail.prev;
                if (this.tail != null)
                    this.tail.next = null;
            }
            this.length--;
            node = null;
        }

        public void removeFirst() {
            this.remove(this.head);
        }

        public void removeLast() {
            this.remove(this.tail);
        }

        public LinkedListNode<T> getFirst() {
            return this.head;
        }

        public LinkedListNode<T> getLast() {
            return this.tail;
        }
    }

    private HashMap<Integer, LinkedListNode<Integer>> keyToLinkedListNodeMap;
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private int size;

    // Constructor that sets the size of the cache
    public LRUCache(int size) {
        this.size = size;
        this.keyToLinkedListNodeMap = new HashMap<>(size);
    }

    int get(int key) {
        if (keyToLinkedListNodeMap.containsKey(key)) {
            LinkedListNode<Integer> node = keyToLinkedListNodeMap.get(key);
            int ret = node.data;
            linkedList.remove(node);
            linkedList.addFirst(node);
            return ret;
        }
        return -1;
    }

    void set(int key, int value) {
        if (keyToLinkedListNodeMap.containsKey(key)) {
            LinkedListNode<Integer> node = keyToLinkedListNodeMap.get(key);
            node.data = value;
            linkedList.remove(node);
            linkedList.addFirst(node);
        } else {
            if (keyToLinkedListNodeMap.size() == size) {
                Integer keyToRemove = linkedList.tail.key;
                linkedList.removeLast();
                keyToLinkedListNodeMap.remove(keyToRemove);
            }
            LinkedListNode<Integer> node = new LinkedListNode<>(key, value);
            linkedList.addFirst(node);
            keyToLinkedListNodeMap.put(key, node);
        }
    }
}