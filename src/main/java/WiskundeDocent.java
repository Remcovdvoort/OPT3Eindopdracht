public class WiskundeDocent extends Docent {
    public WiskundeDocent(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
    }

    @Override
    protected void printCijfers(Student student) {
        System.out.println("Cijfers van Wiskunde van studentnummer: " + student.getStudentNummer());
        try{
            for (Double wiskundeCijfer : student.getCijfersByVak("Wiskunde")) {
                System.out.println(wiskundeCijfer);
            }
            System.out.println();
        }catch(NullPointerException n){
            System.out.println("Student volgt het vak niet");
        }
    }


    @Override
    protected void cijferOpslaan(Student st, double cijfer) {
        st.getCijfersByVak("Wiskunde").add(cijfer);
        System.out.println("Cijfer is opgeslagen in wiskunde cijfers.");
    }
}
