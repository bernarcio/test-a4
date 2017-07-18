/******************************************************************************
 *  PercolationStats.
 *
 ******************************************************************************/

//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] threshold; // threshold value

    /**
     * Constructors
     */
    public PercolationStats(int n, int trials) {
        int openCnt, row, col;
        if (n <= 0 || trials <= 0)
        throw new IllegalArgumentException("Invalid Arguments");

        threshold = new double[trials];
        openCnt = 0;

        for (int i = 0; i < trials; i++) {
            Percolation pclObj = new Percolation(n);

            do {
                row = StdRandom.uniform(1, n+1);
                col = StdRandom.uniform(1, n+1);
                if (pclObj.isOpen(row, col))
                continue;
                pclObj.open(row, col);
                openCnt++;
            } while (!pclObj.percolates());

            threshold[i] = (double) openCnt / (n * n);
            openCnt = 0;
        }
    }

    }

    public static void main(String[] args) {

    }
}
