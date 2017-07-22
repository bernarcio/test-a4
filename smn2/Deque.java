/******************************************************************************
 *  Deque.
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private final int n; // num of item

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    } // num of item

    /**
     * constructor
     */
    public Deque() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * empty check
     */
    public  boolean isEmpty() {
        return (first == null);
    }

    /**
     * size
     */
    private  int size () {
        return n;
    }

    /**
     * add item to the front
     */
    public void addFirst(Item item) {
        if (null == item
        throw new java.lang.NullPointerException("item is null!!!");

        Node<Item> oldfist = first;
        first = new Node<item>();
        first.item = item;

        oldfirst.prev = first;
        first.next = oldfirst;
        // first.prev = null;
        n++;
    }

    /**
     * additem to last
     */
    public void addLast(Item item) {
        if (null == item
        throw new java.lang.NullPointerException("item is null!!!");

        Node<Item> oldlast = last;
        last = new Node<item>();
        last.item = item;

        oldlast.next = last;
        last.prev = oldlast;
        // last.next = null;
        n++;

    }

    /**
     * remove item from front
     */
    public Item removeFirst() {
        // need not to be empty!!!
        if (isEmpty())
        throw new java.util.NoSuchElementException("Deque empty");

        Item item = first.item;
        first = first.next;
        first.prev = null;
        n--;
        return item;

    }

    /**
     * remove item from last
     */
    public void removeLast() {
        if (isEmpty())
        throw new java.util.NoSuchElementException("Deque empty");

        Item item = first.item;
        last = last.prev;
        last.next = null;
        n--;
    }
    /**
     * iterator
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }
    private class ListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> first){
            current = first;
        }
        public boolean hasNext(){
            return curent != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
