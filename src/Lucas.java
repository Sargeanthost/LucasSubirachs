//Lucas is also known for inventing the towers of hanoi problem
public class Lucas {
    public static int generate(int nthNumber) {
        if (nthNumber == 0) {
            return 2;
        } else if (nthNumber == 1) {
            return 1;
        } else {
            return generate(nthNumber - 1) + generate(nthNumber - 2);
        }
    }
}
