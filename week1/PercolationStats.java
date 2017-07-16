/******************************************************************************
 *  PercolationStats.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

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

    /**
     * halfInterval
    **/
    private double halfInterval() {
        return 1.96 * stddev() / Math.sqrt(threshold.length);
    }

    /**
     * Sample mean of percolation threshold
    **/
    public double mean() {
        return StdStats.mean(threshold);
    }

    /**
     * standard deviation of percolation threshold
    **/
    public double stddev() {
        return StdStats.stddev(threshold);
    }

    /**
     * low endpoint of %95 confidence level
    **/
    public double confidenceLo() {
        return mean() - halfInterval();
    }

    /**
     * high endpoint of 95% confidence level
     *
     */
    public double confidenceHi() {
        return mean() + halfInterval();
    }

    public static void main(String[] args) {
        PercolationStats pclsObj = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.printf("mean                     = %f\n", pclsObj.mean());
        System.out.printf("stddev                   = %f\n", pclsObj.stddev());
        System.out.printf("95%% confidence Interval = %f, %f\n", pclsObj.confidenceLo(), pclsObj.confidenceHi());

    }
}
