package com.basic.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// e.g. Assert.assertEquals("10 x 5 must be 50", 50, tester.multiply(10, 5));
//Should_ThrowException_When_AgeLessThan18
//Should_FailToWithdrawMoney_ForInvalidAccount
//Should_FailToAdmit_IfMandatoryFieldsAreMissing
/**
 * Test class for testing linked list methods
 * This class is not thread safe
 *
 * @author Yongdi Wang
 *
 */

public class TestLinkedList {
    LinkedList linkedList;
//    LinkedList.Node node = linkedList.new Node("First Node");

    @Nested
    @DisplayName("Linked list tests")
    class TestLinkedListDetail {
        @BeforeEach
        @DisplayName("Set up linked list")
        void init() {
            linkedList = new LinkedList();
            assertTrue(linkedList.isEmpty());
        }

        @Test
        @DisplayName("Get node at invalid index - exception")
        void should_ThrowException_When_IndexInvalid() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                linkedList.getNode(-1);
            });
            assertEquals("Invalid Index", exception.getMessage());
        }

        @Test
        @DisplayName("Get node at valid index - return data")
        void should_GetNodeData_AtIndex() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
        }

        @Test
        @DisplayName("Get node at index exceeded list length - null")
        void should_ReturnNull_When_IndexExceedLength() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                linkedList.getNode(3);
            });
            assertEquals("Index Exceed List Length", exception.getMessage());
        }

        @Test
        @DisplayName("Get node at last of list - empty list")
        void should_AddNode_AtLast_ToEmptyLinkedList() {
            linkedList.addLast("First Node");
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
        }

        @Test
        @DisplayName("Get node at last of list - non empty list")
        void should_AddNode_AtLast_ToNonEmptyLinkedList() {
            linkedList.add("First Node",0);
            linkedList.addLast("Second Node");
            assertEquals(2, linkedList.getSize());
            Optional<LinkedList.Node> rlt = linkedList.getNode(0);
            Iterator<LinkedList> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                assertEquals("First Node", rlt.isPresent() ? iterator.next() : Optional.empty());
                assertEquals("Second Node", rlt.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

//        @Test
//        @DisplayName("Empty list from last")
//        void addLastTest_1() {
//            linkedList.addLast(new Node("First Node"));
//            System.out.println("Before remove");
//            linkedList.toPrint();
//            Optional<Node> rlt = linkedList.removeLast();
//            assertEquals(Optional.empty(), rlt.isPresent() ? rlt.get().data : Optional.empty());
//            System.out.println("After remove");
//            assertEquals(0, linkedList.getSize());
//            linkedList.toPrint();
//        }
//
//        @Test
//        @DisplayName("Add and remove from last")
//        void addLastTest_2() {
//            linkedList.addLast(new Node("First Node"));
//            linkedList.addLast(new Node("Second Node"));
//            linkedList.addLast(new Node("Third Node"));
//            assertEquals(3, linkedList.getSize());
//            System.out.println("====Before remove====");
//            linkedList.toPrint();
//            Optional<Node> rlt = linkedList.removeLast();
//            assertEquals("Second Node", rlt.isPresent() ? rlt.get().data : Optional.empty());
//            assertEquals(2, linkedList.getSize());
//            System.out.println("====After remove====");
//            linkedList.toPrint();
//        }
//
//        @Test
//        @DisplayName("Empty list from start")
//        void addStartTest_1() {
//            linkedList.addStart(new Node("First Node"));
//            System.out.println("Before remove");
//            linkedList.toPrint();
//            Optional<Node> rlt = linkedList.removeStart();
//            assertEquals(Optional.empty(), rlt.isPresent() ? rlt.get().data : Optional.empty());
//            assertEquals(false, rlt.isPresent());
//            System.out.println("After remove");
//            assertEquals(0, linkedList.getSize());
//            linkedList.toPrint();
//        }
//
//        @Test
//        @DisplayName("Add and remove at start")
//        void addStartTest_2() {
//            linkedList.addStart(new Node("First Node"));
//            linkedList.addStart(new Node("Second Node"));
//            linkedList.addStart(new Node("Third Node"));
//            assertEquals(3, linkedList.getSize());
//            System.out.println("====Before remove====");
//            linkedList.toPrint();
//            Optional<Node> rlt = linkedList.removeStart();
//            assertEquals(true, rlt.isPresent());
//            assertEquals("Second Node", rlt.isPresent() ? rlt.get().data : Optional.empty());
//            assertEquals(2, linkedList.getSize());
//            System.out.println("====After remove====");
//            linkedList.toPrint();
//        }
//
//        @Test
//        @DisplayName("Add nodes at index")
//        void addTest() {
//            linkedList.add(new Node("First Node"), 0);
//            linkedList.add(new Node("Second Node"), 0);
//            linkedList.add(new Node("Third Node"), 1);
//            linkedList.toPrint();
//            assertEquals(3, linkedList.getSize());
//
//        }
//
//        @Test
//        @DisplayName("Get node at index")
//        void getTest() {
//            linkedList.add(new Node("First Node"), 0);
//            linkedList.add(new Node("Second Node"), 0);
//            linkedList.add(new Node("Third Node"), 1);
//            linkedList.addLast(new Node("Fourth Node"));
//            linkedList.addLast(new Node("Fifth Node"));
//            linkedList.toPrint();
//            Optional<Node> rlt = linkedList.getNode(5);
//            assertEquals( Optional.empty(), rlt.isPresent() ? rlt.get().data : Optional.empty());
//            Optional<Node> rlt2 = linkedList.getNode(0);
//            assertEquals("Second Node", rlt2.isPresent() ? rlt2.get().data : Optional.empty());
//            assertEquals(5, linkedList.getSize());
//        }
//
//        @Test
//        @DisplayName("Remove node at index")
//        void removeTest() {
//            linkedList.add(new Node("First Node"), 0);
//            linkedList.add(new Node("Second Node"), 0);
//            linkedList.add(new Node("Third Node"), 1);
//            System.out.println("====Before remove====");
//            linkedList.toPrint();
//            assertEquals("Third Node", linkedList.remove(1).get().data);
//            System.out.println("====After remove====");
//            linkedList.toPrint();
//            assertEquals(3, linkedList.getSize());
//        }
//
//        @Test
//        @DisplayName("Get middle node of the list - odd")
//        void getMiddleTest_1() {
//            Optional<Node> rlt = linkedList.getMiddle();
//            assertEquals(Optional.empty(), rlt.isPresent() ? rlt.get().data : Optional.empty());
//            linkedList.addLast(new Node("First Node"));
//            linkedList.addLast(new Node("Second Node"));
//            linkedList.addLast(new Node("Third Node"));
//            linkedList.addLast(new Node("Fourth Node"));
//            linkedList.addLast(new Node("Fifth Node"));
//            linkedList.toPrint();
//            Optional<Node> rlt2 = linkedList.getMiddle();
//            assertEquals("Third Node", rlt2.isPresent() ? rlt2.get().data : Optional.empty());
//            assertEquals(5, linkedList.getSize());
//        }
//
//        @Test
//        @DisplayName("Get middle node of the list - even")
//        void getMiddleTest_2() {
//            Optional<Node> rlt = linkedList.getMiddle();
//            assertEquals(Optional.empty(), rlt.isPresent() ? rlt.get().data : Optional.empty());
//            linkedList.addLast(new Node("First Node"));
//            linkedList.addLast(new Node("Second Node"));
//            linkedList.addLast(new Node("Third Node"));
//            linkedList.addLast(new Node("Fourth Node"));
//            linkedList.addLast(new Node("Fifth Node"));
//            linkedList.addLast(new Node("Sixth Node"));
//            linkedList.toPrint();
//            Optional<Node> rlt3 = linkedList.getMiddle();
//            assertEquals("Fourth Node", rlt3.isPresent() ? rlt3.get().data : Optional.empty());
//            assertEquals(6, linkedList.getSize());
//        }
//
//        @Test
//        @DisplayName("add node at index - optimized")
//        void addOptTest() {
//            linkedList.optimizedAdd(new Node("First Node"),0);
//            linkedList.optimizedAdd(new Node("Second Node"),0);
//            linkedList.optimizedAdd(new Node("Third Node"), 2);
//            // index invalid
//            linkedList.optimizedAdd(new Node("Fourth Node"),4);
//            linkedList.toPrint();
//            assertEquals(3, linkedList.getSize());
//            Optional<Node> rlt = linkedList.getNode(2);
//            assertEquals("Third Node", rlt.isPresent() ? rlt.get().data : Optional.empty());
//        }

    }
}
