public class Main {

    public static void main(String[] args) {
        while(LogIn.getInstance().isAuthenticated()){
            LogIn.getInstance().getLoggedIn().printMenu();
        }
    }
}
