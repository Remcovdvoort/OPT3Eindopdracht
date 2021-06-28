public class NatuurkundeDocent extends Docent{
    public NatuurkundeDocent(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
    }

    @Override
    protected void printCijfers(Student student) {
        System.out.println("Cijfers van Natuurkunde van studentnummer: " + student.getStudentNummer());
        try{
            for (Double natuurkundeCijfer : student.getCijfersByVak("Natuurkunde")) {
                System.out.println(natuurkundeCijfer);
            }
            System.out.println();
        }catch(NullPointerException n){
            System.out.println("Student volgt het vak niet");
        }
    }
    @Override
    protected void cijferOpslaan(Student st, double cijfer) {
        st.getCijfersByVak("Natuurkunde").add(cijfer);
        System.out.println("Cijfer is opgeslagen in natuurkunde cijfers.");
    }
}
