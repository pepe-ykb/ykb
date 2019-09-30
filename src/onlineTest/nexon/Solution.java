package onlineTest.nexon;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by ykb on 2018-06-06.
 */

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        SinglyLinkedList listHead = new SinglyLinkedList();

        int aaa[] = {50,89,23,38,35,40,33,20,21};

        for (int i = 0; i < aaa.length; i++) {
            int listHeadItem = aaa[i];

            listHead.insertNode(listHeadItem);
        }

        SinglyLinkedListNode res = deleteOdd(listHead.head);

    }

    static SinglyLinkedListNode deleteOdd(SinglyLinkedListNode listHead) {
        SinglyLinkedListNode node = listHead;
        SinglyLinkedList prev = new SinglyLinkedList();

        while (node != null) {
            if (node.data %2 != 0) {    // 홀수
                node = node.next;
            } else {    // 짝수
//                prev.head = node;
                prev.insertNode(node.data);
                node = node.next;

            }
        }


        return prev.head;
    }

}
