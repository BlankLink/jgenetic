package gene;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    public static void setup() {
	//setup log
	Logger.getLogger(Logger.class.getName()).log(Level.INFO, "log initialized");
	//setup singleton
       	CityMap.getCityMap().print("dat/citymap.txt");
    }

    public static void main(String args[]){
	setup();
    }
}
