/******************************************************************************
 *  Deque.
 *
 ******************************************************************************/

//import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Deque<Item> implements Iterable<Item> {

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
    public Deque() {
        // constructor
    }

    /**
     * find index of of site
     *
     */
    private int findIndex(int row, int col) {

        if (row <= 0 || row > lineCnt)
        throw new IllegalArgumentException("Invalid Arguments");

        if (col <= 0 || col > lineCnt)
        throw new IllegalArgumentException("Invalid Arguments");

        return ((row-1) * lineCnt + col);
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
    private  int size () {
        //return (idx >= (lineCnt-1) * lineCnt +1);
    }

    /**
     * add first item
     */
    public void addFirst(Item item) {

    }

    /**
     * add last item
     */
    public void addLast(Item item) {

    }

    /**
     * remove first item
     */
    public Item removeFirst() {

    }

    /**
     * remove last item
     */
    public void removeLast() {

    }
    /**
     * Open site (row, col) if it is not yet open
     *
     */
    public Iterator<Item> iterator() {
        //if (isOpen(row, col)) return;

    }
}
