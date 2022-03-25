import java.util.Random;

public class Main {
    public static void genereer() {
        Random rand = new Random();
        int[][] temp = new int[250][250];
        for (int i = 0; i < 250; i++) {
            for (int j = 0; j < 250; j++) {
                if (i == j) {
                    temp[i][j] = 0;
                } else if (i > j) {
                    temp[i][j] = temp[j][i];
                } else {
                    temp[i][j] = rand.nextInt(100) + 1;
                }
            }
        }

        for (int i = 0; i < 250; i++) {
            for (int j = 0; j < 250; j++) {
                System.out.printf("%3d ", temp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int epochs = 1000;
        int cand = 100000;

        // RouteCalc alg = new RouteCalc(epochs, cand);
        // alg.readSituation("1.txt");
        // alg.bepaalRoute();

        testRouteSpecificAmountOfTimes(epochs, cand, 10, "3.txt");
    }

    // Test a situation with a specific amount of times
    private static void testRouteSpecificAmountOfTimes(int epochs, int candidates, int times, String file) {
        int[] scores = new int[times];

        for (int x = 0; x < times; x++) {
            RouteCalc alg = new RouteCalc(epochs, candidates);
            alg.readSituation(file);
            alg.bepaalRoute();

            scores[x] = alg.getScore();
        }

        System.out.print(getStatsForTest(scores));
    }

    // Get min / max / average stats for a int array of scores
    private static String getStatsForTest(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        int sum = 0;
        for (int x = 0; x < scores.length; x++) {
            if (scores[x] < min) {
                min = scores[x];
            }
            if (scores[x] > max) {
                max = scores[x];
            }
            sum += scores[x];
        }
        return "Min: " + min + " Max: " + max + " Average: " + (sum / scores.length);
    }
}
