package com.basic.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// removeLast necessary to be Optional<Node<T>> and here use LinkedList.Node<String>
// if removeLast uses Optional<Node> or Optional<LinkedList.Node> is wrong
// LinkedList.Node means LinkedList.Node
/**
 * Test class for testing linked list methods
 * This class is not thread safe
 *
 * @author Yongdi Wang
 *
 */

public class TestLinkedList {
    LinkedList linkedList;

    @Nested
    @DisplayName("Linked list tests")
    class TestLinkedListDetail {
        @BeforeEach
        @DisplayName("Set up linked list")
        void init() {
            linkedList = new LinkedList();
            // initialize a node which is not in linkedlist
            // LinkedList.Node node = linkedList.new Node("First Node");
            assertTrue(linkedList.isEmpty());
        }


        @Test
        @DisplayName("Add Node at the start of the linked list")
        void shouldAddNodeAtStartOfLinkedList() {
            linkedList.addStart("First Node");
            linkedList.addStart("Second Node");
            linkedList.addStart("Third Node");
            assertEquals(3, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("Third Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                Optional<LinkedList.Node<String>> rlt2 = linkedList.getNode(0);
                assertEquals("Second Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
                assertEquals("First Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

        @Test
        @DisplayName("Add Node at the last of the linked list")
        void shouldAddNodeAtLastOfLinkedList() {
            linkedList.addLast("First Node");
            linkedList.addLast("Second Node");
            linkedList.addLast("Third Node");
            assertEquals(3, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                Optional<LinkedList.Node<String>> rlt2 = linkedList.getNode(0);
                assertEquals("Second Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
                assertEquals("Third Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

        @Test
        @DisplayName("Add Node at invalid index of the linked list")
        void shouldThrowExceptionWhenAddNodeAtInvalidIndex() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                linkedList.add("First Node", -1);
            });
            assertEquals("Invalid Index", exception.getMessage());
        }

        @Test
        @DisplayName("Add Node at index larger than length of the linked list")
        void shouldThrowExceptionWhenAddNodeAtOutOfRangeIndex() {
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                linkedList.add("First Node", 10);
            });
            assertEquals("Index Exceed List Length", exception.getMessage());
        }

        @Test
        @DisplayName("Add Node at valid index in order -- add last")
        void shouldAddNodeAtValidIndexACS() {
            linkedList.add("First Node", 0);
            linkedList.add("Second Node", 1);
            linkedList.add("Third Node", 2);
            assertEquals(3, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                Optional<LinkedList.Node<String>> rlt2 = linkedList.getNode(0);
                assertEquals("Second Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
                assertEquals("Third Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

        @Test
        @DisplayName("Add Node at valid index in random order -- add at first")
        void shouldAddNodeAtValidIndexInOrderDESC() {
            linkedList.add("First Node", 0);
            linkedList.add("Second Node", 0);
            linkedList.add("Third Node", 0);
            assertEquals(3, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("Third Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                Optional<LinkedList.Node<String>> rlt2 = linkedList.getNode(0);
                assertEquals("Second Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
                assertEquals("First Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

        @Test
        @DisplayName("Add Node at valid index in random order -- add in between")
        void shouldAddNodeAtValidIndexInRandomOrder() {
            linkedList.add("First Node", 0);
            linkedList.add("Second Node", 1);
            linkedList.add("Third Node", 2);
            linkedList.add("Forth Node", 1);
            assertEquals(4, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                Optional<LinkedList.Node<String>> rlt2 = linkedList.getNode(0);
                assertEquals("Forth Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
                assertEquals("Second Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
                assertEquals("Third Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

        @Test
        @DisplayName("Get node at invalid index - exception")
        void shouldThrowExceptionWhenIndexInvalid() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                linkedList.getNode(-1);
            });
            assertEquals("Invalid Index", exception.getMessage());
        }

        @Test
        @DisplayName("Get node at valid index - return data")
        void shouldGetNodeDataAtIndex() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
        }

        @Test
        @DisplayName("Get node at index exceeded list length - null")
        void shouldReturnNullWhenIndexExceedLength() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                linkedList.getNode(3);
            });
            assertEquals("Index Exceed List Length", exception.getMessage());
        }

        @Test
        @DisplayName("Get node at last of list - empty list")
        void shouldAddNodeAtLastToEmptyLinkedList() {
            linkedList.addLast("First Node");
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
        }

        @Test
        @DisplayName("Get node at last of list - non empty list")
        void shouldAddNodeAtLastToNonEmptyLinkedList() {
            linkedList.add("First Node",0);
            linkedList.addLast("Second Node");
            assertEquals(2, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            // needs to specify type like String??
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                assertEquals("Second Node", rlt.isPresent() ?  iterator.next() : Optional.empty());
            }
            Exception exception = assertThrows(NoSuchElementException.class, () -> {
                iterator.next();
            });
            assertEquals("No Such Element", exception.getMessage());
        }

        @Test
        @DisplayName("Get middle node of the list - odd")
        void shouldGetMiddleNodeWhenListHasOddNodes() {
            linkedList.addLast("First Node");
            linkedList.addLast("Second Node");
            linkedList.addLast("Third Node");
            assertEquals(3, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getMiddle();
            assertEquals("Second Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
        }

        @Test
        @DisplayName("Get middle node of the list - even")
        void shouldGetMiddleNodeWhenListHasEvenNodes() {
            linkedList.addLast("First Node");
            linkedList.addLast("Second Node");
            linkedList.addLast("Third Node");
            linkedList.addLast("Forth Node");
            assertEquals(4, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt3 = linkedList.getMiddle();
            assertEquals("Third Node", rlt3.isPresent() ? rlt3.get().getData() : Optional.empty());
        }

        @Test
        @DisplayName("Empty list from last")
        void shouldEmptyListByRemoveLastNode() {
            linkedList.addLast("First Node");
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.removeLast();
            assertEquals(Optional.empty(), rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            assertEquals(0, linkedList.getSize());
        }

        @Test
        @DisplayName("Empty list from last")
        void shouldRemoveNodeFromLastofList() {
            linkedList.addLast("First Node");
            linkedList.addLast("Second Node");
            assertEquals(2, linkedList.getSize());

            Optional<LinkedList.Node<String>> rlt = linkedList.removeLast();
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            assertEquals(1, linkedList.getSize());
        }

        @Test
        @DisplayName("Empty list from start")
        void shouldEmptyListByRemoveFirstNode() {
            linkedList.addStart("First Node");
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.removeStart();
            assertEquals(Optional.empty(), rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            assertEquals(0, linkedList.getSize());
        }

        @Test
        @DisplayName("Empty list from last")
        void shouldRemoveNodeFromStartofList() {
            linkedList.addLast("First Node");
            linkedList.addLast("Second Node");
            assertEquals(2, linkedList.getSize());

            Optional<LinkedList.Node<String>> rlt = linkedList.removeStart();
            assertEquals("Second Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            assertEquals(1, linkedList.getSize());
        }

        @Test
        @DisplayName("Remove only node at index")
        void shouldRemoveOnlyNodeAtIndexofList() {
            linkedList.add("First Node", 0);
            assertEquals(1, linkedList.getSize());
            Optional<LinkedList.Node<String>> removedNode = linkedList.remove(0);
            assertEquals("First Node", removedNode.get().getData());
            assertEquals(0, linkedList.getSize());
        }

        @Test
        @DisplayName("Remove node at index")
        void shouldRemoveNodeAtIndexofList() {
            linkedList.add("First Node", 0);
            linkedList.add("Second Node", 1);
            linkedList.add("Third Node", 2);
            assertEquals(3, linkedList.getSize());
            Optional<LinkedList.Node<String>> removedNode = linkedList.remove(1);
            assertEquals("Second Node", removedNode.get().getData());
            assertEquals(2, linkedList.getSize());
            Optional<LinkedList.Node<String>> rlt = linkedList.getNode(0);
            assertEquals("First Node", rlt.isPresent() ? rlt.get().getData() : Optional.empty());
            Iterator<String> iterator = linkedList.iterator();
            if (iterator.hasNext()) {
                Optional<LinkedList.Node<String>> rlt2 = linkedList.getNode(0);
                assertEquals("Third Node", rlt2.isPresent() ?  iterator.next() : Optional.empty());
            }
        }

    }
}
