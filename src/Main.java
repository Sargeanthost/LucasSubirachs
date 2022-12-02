import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            System.out.println("Lucas number: " + i + " is " + Lucas.generate(i));
        }

        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Stats for Lucas' " + i + "th pair:");
            long startTop = System.nanoTime();
            double top = Lucas.generate(i + 1);
            long stopTop = System.nanoTime() - startTop;

            long startBottom = System.nanoTime();
            double bottom = Lucas.generate(i);
            long stopBottom = System.nanoTime() - startBottom;

            double timeRatio = stopTop / (double) stopBottom;
            double ratio = top / bottom;
            System.out.println("  Ratio in millis: " + timeRatio / 1e6 + "\n  Ratio: " + ratio);
            //golden ratio for number
            //O(n^2)
        }
        // our fun
        for (int i = 0; i <= 40; i++) {
            System.out.println("Our fun number: " + i + " is " + OurFun.generate(i));
        }
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Stats for our fun number's " + i + "th pair:");
            long startTop = System.nanoTime();
            double top = OurFun.generate(i + 1);
            long stopTop = System.nanoTime() - startTop;

            long startBottom = System.nanoTime();
            double bottom = OurFun.generate(i);
            long stopBottom = System.nanoTime() - startBottom;

            double timeRatio = stopTop / (double) stopBottom;
            double ratio = top / bottom;
            System.out.println("  Ratio in millis: " + timeRatio / 1e6 + "\n  Ratio: " + ratio);
            //-.4 ratio for number
            //O(n^2)
        }

        //subirachs
        System.out.println("Number of 4 addend sums of 33 in subirachs square is " + Subirachs.searchFourSum(
            Subirachs.SUBIRACHS_SQUARE, 33));
        System.out.println("Number of n addend sums of 33 in subirachs square is " + Subirachs.searchAllSums(
            Subirachs.SUBIRACHS_SQUARE, 33));
        System.out.println(
            "The number of ways all sums can be formed is " + Subirachs.findAllSums(Subirachs.SUBIRACHS_SQUARE.length));

        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i <= Subirachs.SUBIRACHS_MAX_SUM; i++) {
            sums.add(Subirachs.searchAllSums(Subirachs.SUBIRACHS_SQUARE, i));
        }
        Integer max = sums.stream().mapToInt(x -> x).max().orElseThrow(NoSuchElementException::new);
        System.out.println("The max value of a sum is " + max + ", with the sum being " + (sums.indexOf(max))
                           + ". This is special because its half of the max sum and the sums have a bell curve "
                           + "distribution");
    }
}