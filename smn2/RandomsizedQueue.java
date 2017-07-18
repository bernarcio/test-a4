/******************************************************************************
 *  Deque.
 *
 ******************************************************************************/

//import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class RandomSizedqueue<Item> implements Iterable<Item> {

    // private final WeightedQuickUnionUF grid;   // WeightedQuickUnionUF type grid
    // private boolean[] status;     // status for each site, true for open, flase block
    // private int openCnt;
    // private final int lineCnt; // num of row/col

    /**
     * Initializes a system with {@code n * n} sites
     * {@code 0} through {@code n *n-1}. Each site is initially blocked.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public RandomSizedqueue() {
        // constructor
    }

    /**
     * top site check
     */
    public  boolean isEmpty() {
        //return (idx <= lineCnt);
    }

    /**
     * Bottom site check
     */
    public  int size () {
        //return (idx >= (lineCnt-1) * lineCnt +1);
    }

    /**
     * add first item
     */
    public void enqueue(Item item) {

    }

    /**
     * add last item
     */
    public Item dequeue() {

    }

    /**
     * remove first item
     */
    public Item removeFirst() {

    }

    /**
     * remove last item
     */
    public Item sample() {

    }
    /**
     * Open site (row, col) if it is not yet open
     *
     */
    public Iterator<Item> iterator() {
        //if (isOpen(row, col)) return;

    }
}
