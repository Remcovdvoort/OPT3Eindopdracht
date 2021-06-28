import java.util.ArrayList;

public class CijferLijst {
    private ArrayList<Double> cijfers = new ArrayList<>();
    private String vak;

    public ArrayList<Double> getCijfers() {
        return cijfers;
    }

    public CijferLijst(String vak) {
        this.vak = vak;
    }

    public void printCijfers() {
        for (Double c : cijfers) {
            System.out.println(c);
        }
    }

    public boolean cijferCheck() {
        double gemiddelde = 0.0;
        for (Double c : cijfers) {
            gemiddelde += c;
            if (c < 4.5) {
                return false;
            }
        }
        gemiddelde /= cijfers.size();
        if (gemiddelde < 5.5) {
            return false;
        }
        if (cijfers.size() < 2) {
            return false;
        }
        return true;
    }

    public String getVak() {
        return vak;
    }
}
