import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public abstract class Docent extends Gebruiker {

    public static ArrayList<Docent> docenten = new ArrayList<>();

    public Docent(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);

    }

    public void printMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1) Cijfers bekijken");
        System.out.println("2) Cijfers invoeren");
        System.out.println("3) Toekenningspunten bekijken");
        System.out.println("4) Log uit");
        int keuze = sc.nextInt();
        switch (keuze) {
            case 1:
                try{
                    cijferBekijken();
                }catch(InputMismatchException i){
                    System.out.println("Foute invoer");
                    cijferBekijken();
                }
                break;
            case 2:
                try{
                    cijferToevoegen();
                }catch(InputMismatchException i){
                    System.out.println("Foute invoer");
                    cijferToevoegen();
                }
                break;
            case 3: bekijkRequirements();
                break;
            case 4: LogIn.getInstance().logUit();
        }
    }

    public void bekijkRequirements(){
        System.out.println("De toekenningspunten van een cijfer zijn als volgt:");
        System.out.println(" - Als de dagen te laat meer dan 2 dagen is, dan wordt het cijfer automatisch een 1.0");
        System.out.println(" - Als de dagen te laat meer dan 0 dagen en minder dan 2 of gelijk aan 2 dagen, dan word er automatisch 2 punten van het cijfer afgetrokken");
        System.out.println(" - Als de student plagiaat heeft gepleegd, dan word het cijfer automatisch een 1.0");
        System.out.println(" - Als de student de bonus opdracht correct heeft gemaakt, dan worden er 2 punten bij het cijfer opgeteld");
        System.out.println(" - Als de student een github invite heeft gestuurd naar de docent, dan word er 1 punt opgeteld bij het cijfer");
        System.out.println(" - Als de student geen github invite heeft gestuurd, dan word er 0.5 afgetrokken van het cijfer");
    }

    public void cijferBekijken(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Geef je studentennummer op:");
        int studentennummer = sc.nextInt();
        for (Student student : Student.students) {
            if(student.getStudentNummer()==studentennummer){
                printCijfers(student);
            }
        }
    }

    protected abstract void printCijfers(Student student);


    public void cijferToevoegen(){
        Scanner sc = new Scanner(System.in);
        Student st = null;
        while(st == null){
            System.out.println("Geef het studentnummer van de student:");
            Integer studentNummer = sc.nextInt();
            st = Student.getStudent(studentNummer);
        }
        System.out.println("Voer het cijfer in:");
        sc.useLocale(Locale.US);
        double cijfer = sc.nextDouble();
        System.out.println("Voer het aantal dagen te laat in:");
        Integer dagenTelaat = sc.nextInt();
        System.out.println("Geef aan of de student plagiaat heeft gepleegd ('true'/'false'):");
        boolean plagiaat = sc.nextBoolean();
        System.out.println("Geef aan of de student de bonusopdracht heeft gemaakt ('true'/'false'):");
        boolean bonusOpdracht = sc.nextBoolean();
        System.out.println("Geef aan of de student een Github invite heeft gestuurd naar de docent ('true'/'false'):");
        boolean githubInvite = sc.nextBoolean();
        cijfer = bepaalCijfer(cijfer, dagenTelaat, plagiaat, bonusOpdracht, githubInvite );
        try{
            cijferOpslaan(st, cijfer);
        }catch(NullPointerException n){
            System.out.println("Student volgt het vak niet");
        }
    }

    protected abstract void cijferOpslaan(Student st, double cijfer);


    public static double bepaalCijfer(double cijfer, Integer dagenTelaat, boolean plagiaat, boolean bonusOpdracht, boolean githubInvite){

        if(dagenTelaat >2){
            return 1.0;
        }
        else if(dagenTelaat>0 && dagenTelaat<=2){
            cijfer-=2;
        }
        if(plagiaat){
            return 1.0;
        }
        if(bonusOpdracht){
            cijfer+=2;
        }
        if(githubInvite){
            cijfer+=1;
        }else{
            cijfer-=0.5;
        }
        if(cijfer>10.0){
            return 10.0;
        }
        return cijfer;
    }
}
