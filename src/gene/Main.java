package gene;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    public void logSetup() {
	Logger.getLogger(Logger.class.getName()).log(Level.INFO, "log initialized");
    }

    public static void main(String args[]){

	City c = new City("Helena", 1, 1);
    }
}
