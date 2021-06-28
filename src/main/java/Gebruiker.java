public abstract class Gebruiker {


    private String naam;
    private String gebruikersnaam;
    private String wachtwoord;


    public Gebruiker(String naam, String gebruikersnaam, String wachtwoord) {
        this.naam = naam;
        this.gebruikersnaam= gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public abstract void printMenu();

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord(){
        return wachtwoord;
    }

    public String getNaam() {
        return naam;
    }
}

