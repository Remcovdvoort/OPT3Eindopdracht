import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LogIn {

    private static LogIn singleton;
    private ArrayList<Gebruiker> gebruikers;
    private Gebruiker ge;

    private LogIn() {
        gebruikers = new ArrayList<> ();
        Collections.addAll(gebruikers, new Student("Remco", "remco", "domeinmodel"), new Student("Dylan", "dylan", "DJ")) ;
        Collections.addAll(gebruikers, new WiskundeDocent("Karel", "karel", "Wiskunde"), new OPTDocent("Steven", "steven", "OPT"), new NatuurkundeDocent("Job", "job", "Natuurkunde"));
        Student.students.get(0).voegVakToe("OPT");
        Student.students.get(0).voegVakToe("Wiskunde");
        Student.students.get(0).voegVakToe("Natuurkunde");
        ge = null;
    }

    public Gebruiker getLoggedIn(){
        return ge;
    }

    public static LogIn getInstance () {
        if (singleton == null) {
            singleton = new LogIn();
        }
        return singleton;
    }

    private boolean userExists (String naam) {

        for (Gebruiker ge : gebruikers) {
            if (ge.getGebruikersnaam ().equals (naam)) {
                this.ge = ge;
                return true;
            }
        }
        return false;
    }

    public boolean isAuthenticated () {
        if (ge != null) {
            return true;
        }
        else {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                System.out.print("Geef uw gebruikersnaam: ");
                String gebruikersnaam = scanner.nextLine();
                System.out.print ("Geef uw wachtwoord: ");
                String wachtwoord = scanner.nextLine();
                if (userExists (gebruikersnaam) && wachtwoord.equals(ge.getWachtwoord())) {
                    System.out.println ();
                    return true;
                }
                System.out.println ("De combinatie van je gebruikersnaam en wachtwoord kloppen niet.");
            }
            return false;
        }
    }

    public void logUit() {
        ge=null;
    }
}
