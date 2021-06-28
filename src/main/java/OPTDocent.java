public class OPTDocent extends Docent{

    public OPTDocent(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
    }

    @Override
    protected void printCijfers(Student student) {
        System.out.println("Cijfers van OPT van studentnummer: " + student.getStudentNummer());
        try {
            for (Double optCijfer : student.getCijfersByVak("OPT")) {
                System.out.println(optCijfer);
            }
            System.out.println();
        }catch(NullPointerException n){
            System.out.println("Student volgt het vak niet");
        }
    }

    @Override
    protected void cijferOpslaan(Student st, double cijfer) {
        st.getCijfersByVak("OPT").add(cijfer);
        System.out.println("Cijfer is opgeslagen in OPT cijfers.");
    }
}
