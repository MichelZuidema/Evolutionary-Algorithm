import java.util.Arrays;

public class KandidaatRoute implements Comparable<KandidaatRoute> {
    private int score;
    private int[] route; 

    public KandidaatRoute(int[] route) {
        this.route = route;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int[] getRoute() {
        return route;
    }

    public void setRoute(int[] route) {
        this.route = route;
    }

    public KandidaatRoute copy() {
        int[] copy = new int[route.length];

        for (int x = 0; x < route.length; x++) 
            copy[x] = route[x];

        return new KandidaatRoute(copy);
    } 

    @Override
    public int compareTo(KandidaatRoute o) {
        if (this.score < o.getScore()) {
            return -1;
        } else if (this.score > o.getScore()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.route);
    }
}