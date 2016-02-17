package gene;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    public static void logSetup() {
	Logger.getLogger(Logger.class.getName()).log(Level.INFO, "log initialized");
    }

    public static void main(String args[]){
	logSetup();
	CityMap m = new CityMap("dat/cities.dat");
	m.print("dat/citymap.txt");
    }
}
