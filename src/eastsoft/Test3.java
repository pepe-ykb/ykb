package eastsoft;

import java.util.*;

/**
 * Created by ykb on 2018-12-15.
 */
public class Test3 {

    public static Map <Integer, Node> insertTree(List<Integer> list, int parent, Map <Integer, Node> map, Map <Integer, Node> temp) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == parent && i != parent) {
                map.put(i, new Node(list.get(i)));
                parent = list.get(i);
                temp = map.get(i).getMap();
                Map <Integer, Node> _temp = new HashMap<>();
                insertTree(list, parent, temp, _temp);
            }
        }
        return temp;
    }

    public static void main(String args[]) {
        int[] T = {9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
        Integer parent = 0;
        List<Integer> list = new ArrayList<>();
        Map <Integer, Node> map = new HashMap<>();
        Map <Integer, Node> temp = new HashMap<>();

        for(int t : T) {
            list.add(t);
        }

        for(int i = 0; i < list.size(); i++) {
            if(i == list.get(i)) {
                map.put(list.get(i), new Node(list.get(i)));
                parent = list.get(i);
                break;
            }
        }

        temp = map.get(parent).getMap();
        temp = insertTree(list, parent, map, temp);
//        for(int i = 0; i < list.size(); i++) {
//            if(list.get(i) == parent && i != parent) {
//                temp.put(i, new Node(list.get(i)));
//                parent = list.get(i);
//            }
//        }


        System.out.print("dfdf");
    }

    public void sss() {

    }

    public static class Node {
        private int data;
        private Map<Integer, Node> map = new HashMap<>();

        public Node(int data, Map<Integer, Node> map) {
            this.data = data;
            this.map = map;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Map<Integer, Node> getMap() {
            return map;
        }

        public void setMap(Map<Integer, Node> map) {
            this.map = map;
        }
    }


//    static class SinglyLinkedList {
//        public SinglyLinkedListNode head;
//        public SinglyLinkedListNode tail;
//
//        public SinglyLinkedList() {
//            this.head = null;
//            this.tail = null;
//        }
//
//        public void insertNode(int nodeData) {
//            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
//
//            if (this.head == null) {
//                this.head = node;
//            } else {
//                this.tail.next = node;
//            }
//
//            this.tail = node;
//        }
//    }
//
//    static class SinglyLinkedListNode {
//        public int data;
//        public SinglyLinkedListNode next;
//
//        public SinglyLinkedListNode(int nodeData) {
//            this.data = nodeData;
//            this.next = null;
//        }
//    }

}
