import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TooManyListenersException;

public class RouteCalc {

    final int TOTALDEST = 250;
    final int KANDIDATEN;
    final int EPOCHS;

    private int[] destinations;
    private int[] packages;
    private int[][] distances;

    private int epochTeller;

    public RouteCalc() {
        this(0, 0);
    }

    public RouteCalc(int epochs, int kandidaten) {
        this.EPOCHS = epochs;
        this.KANDIDATEN = kandidaten;
    }

    public void readSituation(String file){
        File situationfile = new File (file);
        Scanner scan = null;
        try {
            scan = new Scanner(situationfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size = scan.nextInt ();
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
    }

    public void bepaalRoute() {

    }

    public void evalueerKandidaat(KandidaatRoute kandidaatRoute) {
        
    }

    public void evalueerEpoch() {

    }

    public KandidaatRoute randomKandidaat() {
        return null;
    }

    public void startSituatie() {

    }

    public KandidaatRoute muteer(KandidaatRoute kandidaatRoute) {
        return null;
    }

    public void volgendeEpoch() {

    }
}
