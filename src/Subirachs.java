import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Subirachs {
    // Tried using gray codes which worked, but were very slow. One was recursive, and the other one may have been my
    // fault at its implementation as it generated all gray cdoes, and then itereated through all 2^n gray codes and
    // array indexes of subirachs square at the same time. Very fun problem, though. Also thought of a way to go
    // through and find addends of addends which would be the fastest way to do this i think, but would require a
    // sorted list and a lot of checking on special cases
    public static final int[] SUBIRACHS_SQUARE = {15, 14, 14, 13, 11, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static final int SUBIRACHS_MAX_SUM = IntStream.of(SUBIRACHS_SQUARE).sum();

    public static int searchFourSum(int[] arr, int sum) {
        final int MAX_SUM = IntStream.of(arr).sum();
        if (sum > MAX_SUM) {
            return 0;
        }
        int correctSums = 0;
        for (int[] combination : generateCombinations(arr, 4)) {
            if (IntStream.of(combination).sum() == sum) {
                correctSums += 1;
            }
        }
        return correctSums;
    }

    public static List<int[]> generateCombinations(int[] arr, int toChoose) {
        final int SIZE = arr.length;
        List<int[]> listOfLists = new ArrayList<>();
        int[] indexList = new int[toChoose];//array arr index to map to arr. makes loop easier

        for (int i = 0; i < toChoose; i++) {
            indexList[i] = i;
        }
        while (indexList[toChoose - 1] < SIZE) {
            int[] tempList = new int[toChoose];
            for (int i = 0; i < toChoose; i++) {
                tempList[i] = arr[indexList[i]];
            }
            listOfLists.add(tempList.clone());

            int temp = toChoose - 1;
            while (temp != 0 && indexList[temp] == SIZE - toChoose + temp) {
                temp--;
            }
            indexList[temp]++;
            for (int i = temp + 1; i < toChoose; i++) {
                indexList[i] = indexList[i - 1] + 1;
            }
        }

        return listOfLists;
    }

    public static int searchAllSums(int[] arr, int sum) {

        final int MAX_SUM = IntStream.of(arr).sum();
        if (sum == 0 || sum == MAX_SUM) {
            return 1;
        } else if (sum > MAX_SUM) {
            return 0;
        }

        int number = 0;
        for (int i = 1; i < arr.length; i++) {
            //will go from 16 c 1 to 16 c 16, which is all possible combinations. no optimizations as it has to
            // generate each combination first
            //does not start at 16 c 0 because that is always nothing ( 1 way to obtain nothing.) [unless you want 0?]
            for (int[] combination : generateCombinations(arr, i)) {
                if (IntStream.of(combination).sum() == sum) {
                    number += 1;
                }
            }
        }
        return number;
    }

    public static int findAllSums(int length) {
        return (int) Math.pow(2, length);
    }
    //interesting properties
}
