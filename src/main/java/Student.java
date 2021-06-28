import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Gebruiker {
    private Integer studentNummer;
    private static Integer vorigStudentNummer = 0;
    public static ArrayList<Student> students = new ArrayList<>();
    private ArrayList <CijferLijst> cijferlijsten = new ArrayList<>();


    public Student(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        studentNummer = vorigStudentNummer++;
        students.add(this);
    }

    public void voegVakToe(String vak){
        cijferlijsten.add(new CijferLijst(vak));
    }



    public ArrayList<Double> getCijfersByVak(String vak) {
        for(CijferLijst cij: cijferlijsten){
            if(vak.equals(cij.getVak())){
                return cij.getCijfers();
            }
        }
        return null;
    }

    public Integer getStudentNummer() {
        return studentNummer;
    }

    public static Student getStudent(Integer studentNummer) {
        for (Student s : students) {
            if (s.studentNummer.equals(studentNummer)) {
                return s;
            }
        }
        System.out.println("Student niet gevonden...\n");
        return null;
    }


    public void printMenu() {
        Scanner sc = new Scanner(System.in);
        int keuze;
        System.out.println("Menu");
        System.out.println("1) Cijfers bekijken");
        System.out.println("2) Kijken welke vakken je hebt behaald");
        System.out.println("3) Zie studenten nummer");
        System.out.println("4) Loguit");
        keuze = sc.nextInt();
        switch (keuze) {
            case 1:
                cijfersBekijken();
                break;
            case 2:
                for(CijferLijst cij: cijferlijsten) {
                    if (cij.cijferCheck()) {
                        System.out.println("Voor het vak "+ cij.getVak()+ " heb je het gemiddelde, alles boven de 4.5 en het aantaltoetsen behaald");
                    } else {
                        System.out.println("Voor het vak "+ cij.getVak()+ " is een of meer van de requirements niet behaald");
                    }
                }
                break;
            case 3:
                viewStudentNummer();
                break;
            case 4: LogIn.getInstance().logUit();
        }
    }

    public void cijfersBekijken() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kies je vak:");
        for(int i =0; i<cijferlijsten.size();i++) {
            System.out.println(i + ") " + cijferlijsten.get(i).getVak() + " cijfers");
        }
        int keuze = sc.nextInt();
        System.out.println("Uw cijfers voor " + cijferlijsten.get(keuze).getVak());
        cijferlijsten.get(keuze).printCijfers();
        System.out.println();
    }

    public void viewStudentNummer(){
        System.out.println("Dit is uw studenten nummer:\n" + getStudentNummer()+ "\n");
    }
}

