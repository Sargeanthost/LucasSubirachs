public class OurFun {
    /**
     * OEIS A168230. Initial condition is 1.
     *
     * @param nthTerm the term to compute
     * @return returns the nth term of the integer sequence
     */
    private static int helper(int nthTerm) {
        if (nthTerm == 1) {
            return 0;
        } else {
            return (nthTerm + 2) - helper(nthTerm - 1);
        }
    }

    /**
     * Interesting way to get something like A168309.
     *
     * @param nthTerm the term to compute
     * @return returns the nth term
     */
    public static int generate(int nthTerm) {
        if (nthTerm == 0) {
            return 5;
        } else if (nthTerm == 1) {
            return -2;
        } else {
            //you can mess with this to get it to count up sequentially
            return helper(nthTerm + 2) - helper(nthTerm - 1);
        }
    }
}
