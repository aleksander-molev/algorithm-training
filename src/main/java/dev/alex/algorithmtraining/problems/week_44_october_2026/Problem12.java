package dev.alex.algorithmtraining.problems.week_44_october_2026;

import java.util.PriorityQueue;

public class Problem12 {
    /**
     * Two arrays a and b are sorted in nondecreasing order. Each index pair
     * (i,j) contributes the value pair [a[i],b[j]]. Return the k pairs with the
     * smallest sums, sorted by (sum, i, j) ascending. Return values, not indices.
     * Different index pairs count separately even when their values are equal.
     * Leave both arrays unchanged. Do not materialize all index pairs.
     * Constraints: 1 <= a.length,b.length <= 100000;
     * 1 <= k <= min(10000, (long) a.length*b.length);
     * -1000000000 <= a[i],b[j] <= 1000000000.
     * Examples: a=[1,7,11], b=[2,4,6], k=3 -> [[1,2],[1,4],[1,6]];
     * a=[1,1,2], b=[1,2,3], k=4 -> [[1,1],[1,1],[1,2],[1,2]];
     * a=[-2,3], b=[-1,4], k=3 -> [[-2,-1],[-2,4],[3,-1]].
     */
    public int[][] smallestPairs(int[] a, int[] b, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((n1, n2) ->  {
            if (n2.sum.compareTo(n1.sum) == 0) {
                return n2.left.compareTo(n1.left) == 0
                        ? n2.right.compareTo(n1.right)
                        : n2.left.compareTo(n1.left);
            }
            return n2.sum.compareTo(n1.sum);
        });

        for(int i = 0; i < k && i < a.length; i++) {
            for( int j = 0; j < k && j < b.length; j++) {
                pq.add(new Pair(a[i], b[j]));
                if(pq.size() > k) {
                    pq.remove();
                }
            }
        }

        int [][] res = new int[k][2];
        for(int i = k - 1; i >= 0 && !pq.isEmpty(); i-- ) {
            res[i][0] = pq.peek().left;
            res[i][1] = pq.remove().right;
        }

        return res;
    }

    class Pair {
        Integer left;
        Integer right;
        Integer sum;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
            this.sum = this.left + this.right;
        }
    }
}
