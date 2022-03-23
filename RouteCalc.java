import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RouteCalc {

    final int TOTALDEST = 250;
    final int KANDIDATEN;
    final int EPOCHS;

    private int[] destinations;
    private int[] packages;
    private int[][] distances;
    private ArrayList<KandidaatRoute> epochKandidaatRoutes;

    private int epochTeller;

    public RouteCalc() {
        this(0, 0);
    }

    public RouteCalc(int epochs, int kandidaten) {
        this.EPOCHS = epochs;
        this.KANDIDATEN = kandidaten;
        this.epochKandidaatRoutes = new ArrayList<>();
    }

    public void readSituation(String file) {
        File situationfile = new File(file);
        Scanner scan = null;
        try {
            scan = new Scanner(situationfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size = scan.nextInt();
        destinations = new int[size];
        packages = new int[size];
        distances = new int[TOTALDEST][TOTALDEST];

        for (int i = 0; i < size; i++) {
            destinations[i] = scan.nextInt();
        }
        for (int i = 0; i < size; i++) {
            packages[i] = scan.nextInt();
        }
        for (int i = 0; i < TOTALDEST; i++) {
            for (int j = 0; j < TOTALDEST; j++) {
                distances[i][j] = scan.nextInt();
            }
        }

        System.out.println(packages.length);

        // Create test route array
        int[] routeArray = new int[packages.length];
        for (int x = 0; x < packages.length; x++) {
            routeArray[x] = x;
        }

        //KandidaatRoute route = new KandidaatRoute(routeArray);
        //int[] routeTest = {1, 1, 1, 1};
        //KandidaatRoute route = new KandidaatRoute(new int[] {1, 1, 1, 1});
        //evalueerKandidaat(route);

        randomKandidaat();

        System.out.println();
    }

    public void bepaalRoute() {

    }

    public void evalueerKandidaat(KandidaatRoute kandidaatRoute) {
        // The lower the better
        int totalScore = 0;
        int[] route = kandidaatRoute.getRoute();

        for (int x = 0; x < route.length - 1; x++)
            totalScore += distances[destinations[route[x]]][destinations[route[x + 1]]];

        // Check if the route starts at 1
        if (destinations[route[0]] != 1)
            totalScore += 10000;

        // Calculate distance travelled for every package
        int packageDistance = 0;
        for(int x = 1; x < route.length; x++) {
            packageDistance += distances[destinations[route[0]] - 1][destinations[x] - 1] * packages[x];
        }
    
        totalScore += packageDistance / 2 ;
        
        kandidaatRoute.setScore(totalScore);
    }

    public void evalueerEpoch() {
        for(KandidaatRoute route : epochKandidaatRoutes) {
            evalueerKandidaat(route);
        }
    }

    public KandidaatRoute randomKandidaat() {
        int[] route = new int[destinations.length];

        // Create route
        for (int x = 0; x < route.length; x++) {
            route[x] = x;
        }

        // Randomize route
        for (int x = 0; x < route.length; x++) {
            int random = (int) (Math.random() * route.length);
            int temp = route[x];
            route[x] = route[random];
            route[random] = temp;
        }

        return new KandidaatRoute(route);
    }

    public void startSituatie() {
        for(int x = 0; x < KANDIDATEN; x++) {
            epochKandidaatRoutes.add(randomKandidaat());
        }
    }

    public KandidaatRoute muteer(KandidaatRoute kandidaatRoute) {
        return null;
    }

    public void volgendeEpoch() {

    }
}
