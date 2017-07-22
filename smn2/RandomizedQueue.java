/******************************************************************************
 *  Deque.
 *
 ******************************************************************************/

//import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class RandomSizedqueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int cnt;
    private int last;
    private int first;

    /**
     * constructor
     */
    public RandomSizedqueue() {
        a = (Item[]) new Object[1];
        last = 0;
        first = 0;
        cnt = 0;
    }

    /**
     * isEmpty
     */
    public  boolean isEmpty() {
        return (cnt == 0);
    }

    /**
     * resize
     */
    public  int size() {
        return cnt ;
    }

    private void resize(int n){
        Item[] temp = (Item[]) new Object[n];

        for (int i =0; i < n; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * add item
     */
    public void enqueue(Item item) {
        if (item == null)
        throw new java.lang.NullPointerException("null pointer: item");

        if (cnt == a.length) resize(2 * a.length);
        a[last++] = item;
        cnt++;
    }

    /**
     * remove and return item
     */
    public Item dequeue() {
        if (isEmpty())
        throw new NoSuchElementException("stack underflow");

        int idx = StdRandom.uniform(last);
        Item item = a[idx];

        a[idx] = a[--last];
        a[last] = null;

        cnt--;
        if (cnt > 0 && cnt == a.length/4) resize(a.length/2);
        return item;

    }

    /**
     * sample
     */
    public Item sample() {
        if (isEmpty())
        throw new NoSuchElementException("stack underflow");

        return a[StdRandom.uniform(cnt);

    }
    /**
     * iteration
     */
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<item> {
        private int n = 0;
        private Item[] array;

        public ArrayIterator(){
            array = Item[] new Object[cnt];
            for (int j = 0; j < cnt; j++){
                array[j] = a[j];
            }
            for (int j = 0; j < cnt; j++){
                array[j] = a[j];
                Item temp = array[j];
                array[j] = array[r];
                array[r] = temp;
            }
        }

        public boolean hasNext(){return i < cnt}

        public void remove(){
            throw new UnSupportedOperationException();
        }
        public Item next(){
            if (!hasNext())
            throw new NoSuchElementException();
            return array[i++]
        }
    }