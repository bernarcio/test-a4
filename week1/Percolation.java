/******************************************************************************
 *  Percolation.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF grid;   // WeightedQuickUnionUF type grid
    private boolean[] status;     // status for each site, true for open, flase block
    private int openCnt;
    private int lineCnt; // num of row/col

    /**
     * Initializes a system with {@code n * n} sites
     * {@code 0} through {@code n *n-1}. Each site is initially blocked.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public Percolation(int n) {
        if (n <= 0)
        throw new IllegalArgumentException("Invalid Arguments");

        int count = n * n;
        lineCnt = n;
        grid = new WeightedQuickUnionUF(count + 2);// two virtual sites at the top and bottom, respectively.

        status = new boolean[count + 2];
        for (int i = 0; i < count +1; i++) {
            status[i] = false;
        }

        //open the virtual sites
        status[0] = true;
        status[count+1] = true;
        openCnt = 0;
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
    private  boolean isTopSite(int idx) {
        return (idx <= lineCnt);
    }

    /**
     * Bottom site check
     */
    private  boolean isBottomSite(int idx) {
        return (idx >= (lineCnt-1) * lineCnt +1);
    }

    /**
     * check if neighbour sites are open, and connect if yes
     *
     */
    private  void tryNeighbours(int row, int col, int idx) {
        if (row != 1 && isOpen(row-1, col)) {
            grid.union(idx, findIndex(row-1, col));
        }

        if (row != lineCnt && isOpen(row+1, col)) {
            grid.union(idx, findIndex(row+1, col));
        }
        if (col != 1 && isOpen(row, col-1)) {
            grid.union(idx, findIndex(row, col-1));
        }

        if (col != lineCnt && isOpen(row, col + 1)) {
            grid.union(idx, findIndex(row, col+1));
        }

    }

    /**
     * Open site (row, col) if it is not yet open
     *
     */
    public void open(int row, int col) {
        if (isOpen(row, col)) return;

        int idx = findIndex(row, col);
        status[idx] = true;
        openCnt++;
        tryNeighbours(row, col, idx); //check neighbours sites, connect if they are already open.

        //check if from top/bottom
        if (isTopSite(idx)) grid.union(idx, 0);

        if (isBottomSite(idx)) grid.union(idx, status.length-1);
    }

    /**
     * Is site(row, col) open
     *
     */
    public boolean isOpen(int row, int col) {
        int idx = findIndex(row, col);
        return status[idx];
    }

    /**
     * Is site(row, col) full
     *
     */
    public boolean isFull(int row, int col) {
        int idx = findIndex(row, col);
        return grid.connected(idx, 0); //is connected with grid[0]
    }

    /**
     * number of open site
     *
     */
    public int numberOfOpenSites() {
        return openCnt;
    }

    /**
     * does the system percolate?
     *
     */
    public boolean percolates() {
        return grid.connected(0,status.length-1);
    }
}
