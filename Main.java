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
        RouteCalc alg = new RouteCalc(1, 100);
        alg.readSituation("1.txt");

        KandidaatRoute kandidaatRoute;
        int[] route;
        for (int i = 0; i < 100; i++) {
            kandidaatRoute = alg.randomKandidaat();
            //kandidaatRoute = new KandidaatRoute(new int[]{1, 1, 1, 1});
            route = kandidaatRoute.getRoute();
            System.out.print("[");
            for (int j = 0; j < route.length; j++) {
                System.out.print(route[j] + " ");
            }
            alg.evalueerKandidaat(kandidaatRoute);
            System.out.print("] - score: " + kandidaatRoute.getScore());
            System.out.println();
        }
    }
}
